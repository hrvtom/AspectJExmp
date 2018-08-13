public aspect Intercept{
	pointcut sum(): this(Sum) && execution(* get*(..));
	pointcut multi(): this(Multi) && execution(* get*(..));
	pointcut a(): this(A) && execution(* get*(..));
	
	pointcut a2(): execution(* A+.get*(..));
	pointcut sum2(): execution(* Sum.get*(..));	// this doesn't work, get*() defined in A class
	pointcut multi2(): execution(* Multi.get*(..));// this doesn't work, get*() defined in A class
												   // similar like reflection !?
	
	pointcut sum3(): this(Sum) && call(* get*(..));	
	pointcut multi3(): this(Multi) && call(* get*(..));


	before(): sum() || multi(){
		System.out.println("Sum or Multi pointcut "+thisJoinPoint);
	}
	
	before(): a(){
		System.out.println("A pointcut "+thisJoinPoint);
	}
	
	before(): a2(){
		System.out.println("A2 pointcut "+thisJoinPoint);
	}
	
	before(): sum2() || multi2(){
		System.out.println("Sum2 or Multi2 pointcut "+thisJoinPoint);
	}
	
	before(): sum3() || multi3(){
		System.out.println("Sum3 or Multi3 pointcut "+thisJoinPoint);
	}
	
}