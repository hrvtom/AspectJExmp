package com.mycompany.app;

// JapaneseMannersAspect.java
public aspect JapaneseMannersAspect {
    pointcut callSayMessageToPerson(String person) 
	: call(* HelloWorld.sayToPerson(String, String))
	       && args(*, person);

    void around(String person) 
	: callSayMessageToPerson(person) {
		System.out.println("Aspect around:");
	proceed(person + "-san");
    }
}
