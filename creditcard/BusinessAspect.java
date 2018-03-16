public aspect BusinessAspect{
	
	pointcut someOperation(): execution(public * BusinessClass.*(..));
	
	before() : someOperation(){
		System.out.println("Starting "+thisJoinPoint.getSignature().toString());
	}
	
	after() returning : someOperation(){
		System.out.println("Completing "+thisJoinPoint.getSignature().toString());
	}
	
	after() throwing(Exception e): someOperation(){
		System.out.println("Exception "+thisJoinPoint.getSignature().toString());
	}
	
}
