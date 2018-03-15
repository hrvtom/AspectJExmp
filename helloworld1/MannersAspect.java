// MannersAspect.java
public aspect MannersAspect {
    pointcut callSayMessage() : call(public static void HelloWorld.say*(..));
    
    before() : callSayMessage() {
	System.out.println("Aspect before "+thisJoinPoint+" : Good day!");
    }

    after() : callSayMessage() {
	System.out.println("Aspect after "+thisJoinPoint+" : Thank you!");
    }
}
