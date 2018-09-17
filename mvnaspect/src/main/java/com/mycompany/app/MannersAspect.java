package com.mycompany.app;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

// MannersAspect.java
@Aspect
public class MannersAspect {
	@Pointcut("call(public static void HelloWorld.say*(..))")
    public void  callSayMessage() {
		
	}
	
    @Before("callSayMessage()")
    public void sayMessageBeforeAdvice(){
	System.out.println("Aspect before: Good day!");
    }

    @After("callSayMessage()")
    public void sayMessageAfterAdvice(){
	System.out.println("Aspect after: Thank you!");
    }
}


