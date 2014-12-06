package com.livingoncodes.spring.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/livingoncodes/spring/aop/beans.xml");

		IBlender blender = (IBlender)context.getBean("blender");
		
		((IMachine)blender).start();
		blender.blend();
		
		
		IFan fan = (IFan)context.getBean("fan");
		((IMachine)fan).start();
		
		
		fan.activate(5);
		
		
		context.close();
	}

}
