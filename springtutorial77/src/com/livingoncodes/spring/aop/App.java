package com.livingoncodes.spring.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.livingoncodes.spring.camera.accessories.Lens;

public class App {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"com/livingoncodes/spring/aop/beans.xml");
		
		Camera camera = (Camera) context.getBean("camera");
		Lens lens = (Lens) context.getBean("lens");
		
		camera.snap();
		camera.snap(1000);
		camera.snap("Parliament House");
		camera.snapNightTime();
		
		lens.zoom(3);
				
		context.close();

	}

}
