package com.livingoncodes.spring.aop;

import org.springframework.stereotype.Component;

@Component
public class Fan implements IFan {

	/* (non-Javadoc)
	 * @see com.livingoncodes.spring.aop.IFan#activate(int)
	 */
	@Override
	public void activate(int level) {
		System.out.println("Fan running at level " + level);
	}
}
