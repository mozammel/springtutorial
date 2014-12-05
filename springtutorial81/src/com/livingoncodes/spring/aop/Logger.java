package com.livingoncodes.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
	
	@Pointcut("within(com.livingoncodes.spring.aop.*)")
	public void withinDemo() {
		
	}
	
	@Pointcut("target(com.livingoncodes.spring.aop.Camera)")
	public void targetDemo() {
		
	}
	
	@Pointcut("this(com.livingoncodes.spring.aop.ICamera)")
	public void thisDemo() {
		
	}
	
	@Before("withinDemo()")
	public void withinBeforeDemo() {
		System.out.println("***** WITHIN DEMO *****");
	}
	
	@Before("targetDemo()")
	public void targetBeforeDemo() {
		System.out.println("***** TARGET DEMO *****");
	}
	
	@Before("thisDemo()")
	public void thisBeforeDemo() {
		System.out.println("***** THIS DEMO *****");
	}
	
}
