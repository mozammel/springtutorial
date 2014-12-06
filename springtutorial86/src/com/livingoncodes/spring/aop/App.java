package com.livingoncodes.spring.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.livingoncodes.spring.camera.accessories.Lens;

public class App {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"com/livingoncodes/spring/aop/beans.xml");
		
		ICamera camera = (ICamera) context.getBean("camera");

		camera.snap();
		camera.snap(500);
		camera.snap(1.8);
		camera.snap(500, 1.8);
		camera.snapNighttime();
		
		Car car = (Car)context.getBean("car");
		car.start();
		
		camera.snapCar(new Car());
		
		context.close();

	}

}
