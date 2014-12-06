package com.livingoncodes.spring.camera.accessories;

import org.springframework.stereotype.Component;

@Component
@Deprecated
public class Lens {
	
	@Deprecated
	public void zoom(int factor) {
		System.out.println("Zooming lens: " + factor);
	}

}
