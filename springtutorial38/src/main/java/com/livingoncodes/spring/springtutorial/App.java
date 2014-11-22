package com.livingoncodes.spring.springtutorial;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("com/livingoncodes/spring/springtutorial/beans/beans.xml");
    	
    	Parrot parrot = (Parrot) context.getBean("parrot");
    	
    	parrot.speak();
 
    	
    	((ClassPathXmlApplicationContext) context).close();
    }
}
