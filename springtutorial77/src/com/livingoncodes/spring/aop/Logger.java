package com.livingoncodes.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
	
	@Pointcut("execution(* com.livingoncodes.spring.aop.Camera.*(..))")
	public void cameraSnap() {
		
	}
	
	@Pointcut("execution(* *.*(..))")
	public void cameraActivity() {
		
	}
	
	@Before("cameraSnap()")
	public void aboutToTakePhoto() {
		System.out.println("About to take photo...");
	}
	
	@Before("cameraActivity()") 
	public void cameraRelatedActivity() {
		System.out.println("Doing something related to camera...");
	}
	

}
