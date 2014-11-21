package com.livingoncodes.spring.springtutorial;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("com/livingoncodes/spring/springtutorial/beans/beans.xml");
    	
    	Logger logger = (Logger) context.getBean("logger");
    	
    	logger.writeConsole("Hello there");
    	logger.writeFile("Hi there");
 
    	
    	((ClassPathXmlApplicationContext) context).close();
    }
}
