package com.livingoncodes.spring.springtutorial;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

public class App 
{
    public static void main( String[] args )
    {
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("com/livingoncodes/spring/springtutorial/beans/beans.xml");
    	
    	NoticesDAO noticesDao = (NoticesDAO) context.getBean("noticesDao");
    	
    	try {
    		

    		Notice notice1 = new Notice(4, "Bobby4", "bobby1@livingoncodes.com", "Late fees will be imposed!");
    		Notice notice2 = new Notice(2, "Bobby2", "bobby2@livingoncodes.com", "Late fees will be imposed!");
    		Notice notice3 = new Notice(5, "Bobby5", "bobby3@livingoncodes.com", "Late fees will be imposed!");
    		
    		List<Notice> noticeList = new ArrayList<Notice>();
    		
    		noticeList.add(notice1);
    		noticeList.add(notice2);
    		noticeList.add(notice3);
    		
    		
    		noticesDao.create(noticeList);
    		    		
        	List<Notice> notices = noticesDao.getNotices();
        	
        	for(Notice notice: notices) {
        		System.out.println(notice);
        	}
        	
 
    	} catch(CannotGetJdbcConnectionException ex) {
    		System.out.println("Could not get jdbc connection.");
    	}
    	catch (DataAccessException ex) {
    		System.out.println(ex.getMessage());
    		System.out.println(ex.getClass());
    	}
    	
 
    	
    	((ClassPathXmlApplicationContext) context).close();
    }
}
