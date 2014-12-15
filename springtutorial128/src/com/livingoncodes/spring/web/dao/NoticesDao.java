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
public class NoticesDao {

	private NamedParameterJdbcTemplate jdbc;

	
	
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public List<Notice> getNotices() {

		return jdbc.query("select * from notices, users where notices.username=users.username and users.enabled=true", new RowMapper<Notice>() {

			public Notice mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setAuthority(rs.getString("authority"));
				user.setEmail(rs.getString("email"));
				user.setEnabled(true);
				user.setName(rs.getString("name"));
				user.setUsername(rs.getString("username"));
				
				Notice notice = new Notice();
				notice.setId(rs.getInt("id"));
				notice.setText(rs.getString("text"));
				notice.setUser(user);

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
		
		return jdbc.update("update notices set text=:text where id=:id", params) == 1;
	}
	
	public int[] create(List<Notice> notices) {
		
		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(notices.toArray());
		
		return jdbc.batchUpdate("insert into notices (username, text) values (:username, :text)", params);
	}
	

	public boolean create(Notice notice) {

		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(notice);
		
		return jdbc.update("insert into notices (username, text) values (:username, :text)", params) == 1;
	}
	
	public Notice getNotice(int id) {

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);

		return jdbc.queryForObject("select * from notices, users where notices.username=users.username and users.enabled=true and id = :id",
				params, new RowMapper<Notice>() {

					public Notice mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						User user = new User();
						user.setAuthority(rs.getString("authority"));
						user.setEmail(rs.getString("email"));
						user.setEnabled(true);
						user.setName(rs.getString("name"));
						user.setUsername(rs.getString("username"));
						
						Notice notice = new Notice();
						notice.setId(rs.getInt("id"));
						notice.setText(rs.getString("text"));
						notice.setUser(user);

						return notice;
					}

				});

	}

}
