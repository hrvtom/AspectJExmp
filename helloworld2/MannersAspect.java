// MannersAspect.java
public aspect MannersAspect {
    pointcut callSayMessage() : call(public static void HelloWorld.say*(..));

    before() : callSayMessage() {
	System.out.println("Aspect before: Good day!");
    }

    after() : callSayMessage() {
	System.out.println("Aspect after: Thank you!");
    }
}


