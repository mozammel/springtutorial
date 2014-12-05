package com.livingoncodes.spring.aop;

import org.springframework.stereotype.Component;

@Component
public class Camera implements PhotoSnapper, ICamera {
	

	
	/* (non-Javadoc)
	 * @see com.livingoncodes.spring.aop.ICamera#snap()
	 */
	@Override
	public void snap() throws Exception {
		
		
		System.out.println("SNAP");
		
		throw new Exception("bye bye!");
	}
}
