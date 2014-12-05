package com.livingoncodes.spring.aop;

import org.springframework.stereotype.Component;

@Component
public class Camera {

	public void snap() {
		System.out.println("SNAP");
	}

	public void snap(int exposure) {
		System.out.println("SNAP with exposure: " + exposure);
	}

	public void snap(String name) {
		System.out.println("SNAP with name: " + name);
	}
}
