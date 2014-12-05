package com.livingoncodes.spring.aop;

import org.springframework.stereotype.Component;

@Component
public class Camera implements PhotoSnapper, ICamera {
	

	
	/* (non-Javadoc)
	 * @see com.livingoncodes.spring.aop.ICamera#snap()
	 */
	@Override
	public void snap() {
		
		
		System.out.println("SNAP");
		
	}
}
