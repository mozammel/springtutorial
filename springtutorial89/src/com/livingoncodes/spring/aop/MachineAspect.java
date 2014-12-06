package com.livingoncodes.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class MachineAspect {
	
	@DeclareParents(value="com.livingoncodes.spring.aop.*", defaultImpl=com.livingoncodes.spring.aop.Machine.class)
	private IMachine machine;
	
	
	@Around("within(com.livingoncodes.spring.aop.*)")
	public void runMachine(ProceedingJoinPoint jp) {
		
		System.out.println("Running ...");
		try {
			jp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("... completed.");
	}
}
