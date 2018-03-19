public aspect BusinessAspect{
	
	pointcut someOperation(): execution(public * BusinessClass.*(..));
		
	// before() : someOperation(){
		// System.out.println("Starting "+thisJoinPoint.getSignature().toString());
	// }
	
	// after() returning : someOperation(){
		// System.out.println("Completing "+thisJoinPoint.getSignature().toString());
	// }
	
	// after() throwing(Exception e): someOperation(){
		// System.out.println("Exception "+thisJoinPoint.getSignature().toString());
	// }

	pointcut someOperationWithArgs(String cardNum, Integer amount):
		someOperation() && args(cardNum, amount);
	
	// C:\Local_Data\projects\AspectJExmp\creditcard\BusinessAspect.java:28 [error] circular advice precedence: can't determine precedenc
	// e between two or more pieces of advice that apply to the same join point: method-execution(void BusinessClass.performSomeOperation
	// (java.lang.String, java.lang.Integer))
	
	// ali ovako imam samo advice oko performSomeOperation()
	// before(String cardNum, Integer amount): someOperationWithArgs(cardNum, amount){
		// System.out.println("Starting "+thisJoinPoint.getSignature().toString()+", credit card:"+cardNum+", amount:"+amount);
	// }
	
	// after(String cardNum, Integer amount) returning : someOperationWithArgs(cardNum, amount){
		// System.out.println("Completing "+thisJoinPoint.getSignature().toString()+", credit card:"+cardNum+", amount:"+amount);
	// }
	
	// after(String cardNum, Integer amount) throwing(InvalidBusinesException e) : someOperationWithArgs(cardNum, amount){
		// System.out.println("Cant perform operation "+thisJoinPoint.getSignature().toString()+", credit card:"+cardNum+", amount:"+amount);	
	// }
	
	// Ovako ne ide
	// C:\Local_Data\projects\AspectJExmp\creditcard\BusinessAspect.java:37 [error] name binding only allowed in target, this, and args pcds
	// pointcut someOperationWithStrInt(String cardNum, Integer amount):
		// execution(public * BusinessClass.*(cardNum, amount));
	//Eighth, self-, target-, and arguments-type pointcuts capture joinpoints based on the self-object, target-object, and argument types.
	//These are the only constructs that can capture context at the joinpoints.
	
	pointcut someOperationWithStrInt():
		execution(public * BusinessClass.*(String, Integer));
	
	pointcut someOperationWithArgs2(String cardNum, Integer amount):
	    someOperationWithStrInt() && args(cardNum, amount);
		
	pointcut someOperationNoArgs():
		execution(public * BusinessClass.*());

	before() : someOperationNoArgs(){
		System.out.println("Starting "+thisJoinPoint.getSignature().toString());
	}
	
	after() returning : someOperationNoArgs(){
		System.out.println("Completing "+thisJoinPoint.getSignature().toString());
	}
	
	after() throwing(Exception e): someOperationNoArgs(){
		System.out.println("Exception "+thisJoinPoint.getSignature().toString());
	}

	before(String cardNum, Integer amount): someOperationWithArgs2(cardNum, amount){
		System.out.println("Starting "+thisJoinPoint.getSignature().toString()+", credit card:"+cardNum+", amount:"+amount);
	}
	
	after(String cardNum, Integer amount) returning : someOperationWithArgs2(cardNum, amount){
		System.out.println("Completing "+thisJoinPoint.getSignature().toString()+", credit card:"+cardNum+", amount:"+amount);
	}
	
	after(String cardNum, Integer amount) throwing(InvalidBusinesException e) : someOperationWithArgs2(cardNum, amount){
		System.out.println("Cant perform operation "+thisJoinPoint.getSignature().toString()+", credit card:"+cardNum+", amount:"+amount);	
	}

}
