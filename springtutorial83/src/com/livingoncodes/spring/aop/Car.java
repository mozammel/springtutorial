package com.livingoncodes.spring.aop;

import org.springframework.stereotype.Component;

@Component
public class Car {
	public void start() {
		System.out.println("Car engine started.");
	}
}
