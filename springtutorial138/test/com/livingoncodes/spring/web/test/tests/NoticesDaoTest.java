package com.livingoncodes.spring.web.test.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

import com.livingoncodes.spring.web.dao.Notice;
import com.livingoncodes.spring.web.dao.NoticesDao;
import com.livingoncodes.spring.web.dao.User;
import com.livingoncodes.spring.web.dao.UsersDao;

@ActiveProfiles("dev")
@ContextConfiguration(locations = {
		"classpath:com/livingoncodes/spring/web/config/dao-context.xml",
		"classpath:com/livingoncodes/spring/web/config/security-context.xml",
		"classpath:com/livingoncodes/spring/web/test/config/datasource.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class NoticesDaoTest {
	
	@Autowired
	private NoticesDao noticesDao;
	
	@Autowired
	private UsersDao usersDao;
	
	@Autowired
	private DataSource dataSource;

	@Before
	public void init() {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		
		jdbc.execute("delete from notices");
		jdbc.execute("delete from users");
	}
	
	@Test
	public void testNotices() {
		
		User user = new User("mozammel", "Mozammel Haque", "hellohello",
				"mozammel@livingoncodes.com", true, "ROLE_USER");
		
		usersDao.create(user);
		
		Notice notice = new Notice(user, "This is a test notice.");
		
		assertTrue("Notice creation should return true", noticesDao.create(notice));
		
		List<Notice> notices = noticesDao.getNotices();
		
		assertEquals("Should be one offer in database.", 1, notices.size());
		
		assertEquals("Retrieved notice should match created notice.", notice, notices.get(0));
		
		// Get the notice with ID filled in.
		notice = notices.get(0);
		
		notice.setText("Updated offer text.");
		assertTrue("Notice update should return true", noticesDao.update(notice));
		
		Notice updated = noticesDao.getNotice(notice.getId());
		
		assertEquals("Updated notice should match retrieved updated notice", notice, updated);
		
		Notice notice2 = new Notice(user, "This is a test notice. Hello from test notice.");
		
		assertTrue("Notice crecation should return true", noticesDao.create(notice2));
		
		List<Notice> userNotices = noticesDao.getNotices(user.getUsername());
		
		assertEquals("Should be two notices for user.", 2, userNotices.size());
		
		
//		noticesDao.delete(notice.getId());
//		
//		List<Notice> empty = noticesDao.getNotices();
//		
//		assertEquals("Notices lists should be empty.", 0, empty.size());
	}
	
}
