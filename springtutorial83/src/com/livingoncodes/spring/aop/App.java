package com.livingoncodes.spring.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.livingoncodes.spring.camera.accessories.Lens;

public class App {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"com/livingoncodes/spring/aop/beans.xml");
		
		ICamera camera = (ICamera) context.getBean("camera");

		Lens lens = (Lens) context.getBean("lens");

		camera.snap();
		camera.snap(1000);
		camera.snap("Parliament House");
		camera.snapNighttime();
		
		lens.zoom(5);
		
		Car car = (Car) context.getBean("car");
		
		camera.snapCar(car);
		
		context.close();

	}

}
