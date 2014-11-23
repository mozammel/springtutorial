package com.livingoncodes.spring.springtutorial;

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
    		
    		Notice notice1 = new Notice("Prince", "prince@livingoncodes.com", "Where is my princess?");
    		noticesDao.create(notice1);
    		    		
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
