package com.livingoncodes.spring.web.dao;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@Component("noticesDao")
public class NoticesDao {

	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public Session session() {
		return sessionFactory.getCurrentSession();
	}
	
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	@SuppressWarnings("unchecked")
	public List<Notice> getNotices() {
		
		Criteria crit = session().createCriteria(Notice.class);
		
		crit.createAlias("user", "u").add(Restrictions.eq("u.enabled", true));
		
		return crit.list();

	}
	
	@SuppressWarnings("unchecked")
	public List<Notice> getNotices(String username) {
		
		Criteria crit = session().createCriteria(Notice.class);
		
		crit.createAlias("user", "u");
		
		crit.add(Restrictions.eq("u.enabled", true));
		crit.add(Restrictions.eq("u.username", username));
		
		
		return crit.list();
		
	}

	public boolean delete(int id) {

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);

		return jdbc.update("delete from notices where id = :id", params) == 1;

	}
	
	public boolean update(Notice notice) {

		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(notice);
		
		return jdbc.update("update notices set text=:text where id=:id", params) == 1;
	}
	
	

	public void create(Notice notice) {

		session().save(notice);
	}
	
	public Notice getNotice(int id) {

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);

		return jdbc.queryForObject("select * from notices, users where notices.username=users.username and users.enabled=true and id = :id",
				params, new NoticeRowMapper());

	}

}
