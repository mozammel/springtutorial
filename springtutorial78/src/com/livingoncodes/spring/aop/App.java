package com.livingoncodes.spring.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.livingoncodes.spring.camera.accessories.Lens;

public class App {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"com/livingoncodes/spring/aop/beans.xml");
		
		Camera camera = (Camera) context.getBean("camera");
		
		try {
			camera.snap();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
				
		context.close();

	}

}
