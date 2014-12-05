package com.livingoncodes.spring.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.livingoncodes.spring.camera.accessories.Lens;

public class App {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"com/livingoncodes/spring/aop/beans.xml");
		
		ICamera camera = (ICamera) context.getBean("camera");
		
		System.out.println("Getting an object of: " + camera.getClass());
		System.out.println("camera is instanceof PhotoSnapper: " +  (camera instanceof PhotoSnapper) );
		
		try {
			camera.snap();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
				
		context.close();

	}

}
