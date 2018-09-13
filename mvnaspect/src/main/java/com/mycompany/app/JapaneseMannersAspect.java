package com.mycompany.app;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

// JapaneseMannersAspect.java
@Aspect
public class JapaneseMannersAspect {

	@Pointcut("call (* HelloWorld.sayToPerson(String, String)) && args(msg, person)")
	public void callSayMessageToPerson(String msg, String person) {

	}

	@Around("callSayMessageToPerson(msg, person)")
	public void aroundAdvice(ProceedingJoinPoint joinPoint, String msg, String person) {
		System.out.println("Aspect around:");
		String personSan = person + "-san";
		try {
			joinPoint.proceed(new Object[] { msg, personSan });
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
