package com.livingoncodes.spring.web.test.tests;

import static org.junit.Assert.*;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.livingoncodes.spring.web.dao.User;
import com.livingoncodes.spring.web.dao.UsersDao;

@ActiveProfiles("dev")
@ContextConfiguration(locations = {
		"classpath:com/livingoncodes/spring/web/config/dao-context.xml",
		"classpath:com/livingoncodes/spring/web/config/security-context.xml",
		"classpath:com/livingoncodes/spring/web/test/config/datasource.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTests {
	
	@Autowired
	private UsersDao usersDao;
	
	@Autowired
	private DataSource dataSource;
	
	private User user1 = new User("hillol", "Hillol Sharkar", "hellothere", "hillol@livingoncodes.com",
			true, "ROLE_USER");
	private User user2 = new User("mozammel", "Mozammel Haque", "hellohello", "mozammel@livingoncodes.com",
			true, "ROLE_ADMIN");
	private User user3 = new User("imran", "Hillol Sharkar", "thelionking", "imran@livingoncodes.com",
			true, "ROLE_USER");
	private User user4 = new User("qasif", "Hillol Sharkar", "showmethemoney", "qasif@livingoncodes.com",
			false, "user");
	
	@Before
	public void init() {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		
		jdbc.execute("delete from notices");
		jdbc.execute("delete from users");
		
		
	}
	
	
	@Test
	public void testCreateRetrive() {
		usersDao.create(user1);
		
		List<User> users1 = usersDao.getAllUsers();
		
		assertEquals("One user should have been created and retrived", 1, users1.size());
		
		assertEquals("Inserted user should match retrived", user1, users1.get(0));
		
		usersDao.create(user2);
		usersDao.create(user3);
		usersDao.create(user4);
		
		List<User> users2 = usersDao.getAllUsers();
		
		assertEquals("Four user should have been created and retrived", 4, users2.size());
		
		
	}
	
	@Test
	public void testExists() {
		
		usersDao.create(user1);
		usersDao.create(user2);
		usersDao.create(user3);
		
		assertTrue("User should exist.", usersDao.exists(user2.getUsername()));
		assertFalse("User should not exist.", usersDao.exists("abcd"));
		
	}
	
	// TODO - Reimplement this
	@Test
	public void testCreateUser() {
		
		User user = new User("mozammel", "Mozammel Haque", "hellohello", "mozammel@livingoncodes.com", true, "ROLE_USER");
		
		
		
		usersDao.create(user);
		
		List<User> users = usersDao.getAllUsers();
		
		assertEquals("Number of users should be 1.", 1, users.size());
		
		assertTrue("User should exist.", usersDao.exists(user.getUsername()));
		assertFalse("User should not exist.", usersDao.exists("abcd"));
		
		assertEquals("Created user should be identical to retrived user", user, users.get(0));
		
	}

}
