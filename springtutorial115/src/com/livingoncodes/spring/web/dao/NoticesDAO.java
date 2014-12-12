package com.livingoncodes.spring.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;

@Component("noticesDao")
public class NoticesDAO {

	private NamedParameterJdbcTemplate jdbc;

	
	
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public List<Notice> getNotices() {

		return jdbc.query("select * from notices", new RowMapper<Notice>() {

			public Notice mapRow(ResultSet rs, int rowNum) throws SQLException {
				Notice notice = new Notice();

				notice.setId(rs.getInt("id"));
				notice.setName(rs.getString("name"));
				notice.setEmail(rs.getString("email"));
				notice.setText(rs.getString("text"));

				return notice;
			}

		});

	}

	public boolean delete(int id) {

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);

		return jdbc.update("delete from notices where id = :id", params) == 1;

	}
	
	public boolean update(Notice notice) {

		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(notice);
		
		return jdbc.update("update notices set name=:name, email=:email, text=:text where id=:id", params) == 1;
	}
	
	public int[] create(List<Notice> notices) {
		
		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(notices.toArray());
		
		return jdbc.batchUpdate("insert into notices (name, email, text) values (:name, :email, :text)", params);
	}
	

	public boolean create(Notice notice) {

		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(notice);
		
		return jdbc.update("insert into notices (name, email, text) values (:name, :email, :text)", params) == 1;
	}
	
	public Notice getNotice(int id) {

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);

		return jdbc.queryForObject("select * from notices where id = :id",
				params, new RowMapper<Notice>() {

					public Notice mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Notice notice = new Notice();

						notice.setId(rs.getInt("id"));
						notice.setName(rs.getString("name"));
						notice.setEmail(rs.getString("email"));
						notice.setText(rs.getString("text"));

						return notice;
					}

				});

	}

}
