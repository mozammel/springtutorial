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
	
	private User user1 = new User("hillol", "Hillol Sharkar", "hellothere", "hillol@livingoncodes.com",
			true, "ROLE_USER");
	private User user2 = new User("mozammel", "Mozammel Haque", "hellohello", "mozammel@livingoncodes.com",
			true, "ROLE_ADMIN");
	private User user3 = new User("imran", "Hillol Sharkar", "thelionking", "imran@livingoncodes.com",
			true, "ROLE_USER");
	private User user4 = new User("qasif", "Hillol Sharkar", "showmethemoney", "qasif@livingoncodes.com",
			false, "user");
	
	private Notice notice1 = new Notice(user1, "This is a test notice.");
	private Notice notice2 = new Notice(user1, "This is a another test notice.");
	private Notice notice3 = new Notice(user2, "This is a yet again another test notice.");
	private Notice notice4 = new Notice(user3, "This is a test notice again.");
	private Notice notice5 = new Notice(user3, "This is a test notice which is very interesting.");
	private Notice notice6 = new Notice(user3, "This is a just test notice.");
	private Notice notice7 = new Notice(user4, "This is a test notice which is not enabled.");

	@Before
	public void init() {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		
		jdbc.execute("delete from notices");
		jdbc.execute("delete from users");
	}
	
	@Test
	public void testCreateRetrive() {
		usersDao.create(user1);
		usersDao.create(user2);
		usersDao.create(user3);
		usersDao.create(user4);
		
		noticesDao.create(notice1);
		
		List<Notice> notices1 = noticesDao.getNotices();
		
		assertEquals("Should be one notice.", 1, notices1.size());
		assertEquals("Retried notice should be equal to inserted notice", notice1, notices1.get(0));
		
		
		
		
		noticesDao.create(notice2);
		noticesDao.create(notice3);
		noticesDao.create(notice4);
		noticesDao.create(notice5);
		noticesDao.create(notice6);
		noticesDao.create(notice7);
		
		List<Notice> notices2 = noticesDao.getNotices();
		
		assertEquals("Should be six notices for enabled users.", 6, notices2.size());
		
	}
	
	@Test
	public void testGetUsername() {
		usersDao.create(user1);
		usersDao.create(user2);
		usersDao.create(user3);
		usersDao.create(user4);
		
		
		noticesDao.create(notice1);
		noticesDao.create(notice2);
		noticesDao.create(notice3);
		noticesDao.create(notice4);
		noticesDao.create(notice5);
		noticesDao.create(notice6);
		noticesDao.create(notice7);
		
		List<Notice> notices1 = noticesDao.getNotices(user3.getUsername());
		assertEquals("Should be three notices for this user.", 3, notices1.size());
		
		List<Notice> notices2 = noticesDao.getNotices("adslfj");
		assertEquals("Should be zero notices for this user.", 0, notices2.size());

		List<Notice> notices3 = noticesDao.getNotices(user2.getUsername());
		assertEquals("Should be one notice for this user.", 1, notices3.size());
	
	}
	
	@Test
	public void testNotices() {
		
		User user = new User("mozammel", "Mozammel Haque", "hellohello",
				"mozammel@livingoncodes.com", true, "ROLE_USER");
		
		usersDao.create(user);
		
		Notice notice = new Notice(user, "This is a test notice.");
		
		noticesDao.create(notice);
		
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
		
		noticesDao.create(notice2);
		
		List<Notice> userNotices = noticesDao.getNotices(user.getUsername());
		
		assertEquals("Should be two notices for user.", 2, userNotices.size());
		
		
//		noticesDao.delete(notice.getId());
//		
//		List<Notice> empty = noticesDao.getNotices();
//		
//		assertEquals("Notices lists should be empty.", 0, empty.size());
	}
	
}
