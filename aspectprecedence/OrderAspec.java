public aspect OrderAspec {
	
	//In such cases, it is the lexical order e.g. the order in which the advices are declared
	//in source code which applies
	
	pointcut printout2Pointcut(): execution(public * MonitorClass.printout2(..));


	// following order works
	// OrderAspec before
	// OrderAspec around in
		// MonitorClass printout2
	// OrderAspec after
	// OrderAspec around out
	
	// after() : printout2Pointcut(){
		// System.out.println("OrderAspec after ");
	// }
	
	// before() : printout2Pointcut(){
		// System.out.println("OrderAspec before ");
	// }
	
	// void around() : printout2Pointcut(){
		// System.out.println("OrderAspec around in  ");
		// proceed();
		// System.out.println("OrderAspec around out ");
	// }

	// but this ordering doesn't work
	// C:\Local_Data\projects\AspectJExmp\aspectprecedence\OrderAspec.java:41 [error] circular advice precedence: can't determine precede
	// nce between two or more pieces of advice that apply to the same join point: method-execution(void MonitorClass.printout2())

	// C:\Local_Data\projects\AspectJExmp\aspectprecedence\OrderAspec.java:37 [error] circular advice precedence: can't determine precede
	// nce between two or more pieces of advice that apply to the same join point: method-execution(void MonitorClass.printout2())

	// C:\Local_Data\projects\AspectJExmp\aspectprecedence\OrderAspec.java:31 [error] circular advice precedence: can't determine precede
	// nce between two or more pieces of advice that apply to the same join point: method-execution(void MonitorClass.printout2())

	// void around() : printout2Pointcut(){
		// System.out.println("OrderAspec around in  ");
		// proceed();
		// System.out.println("OrderAspec around out ");
	// }

	// after() : printout2Pointcut(){
		// System.out.println("OrderAspec after ");
	// }
	
	// before() : printout2Pointcut(){
		// System.out.println("OrderAspec before ");
	// }
	
	
	// and this one works
	// OrderAspec around in
	// OrderAspec before
		// MonitorClass printout2
	// OrderAspec around out
	// OrderAspec after
	
	void around() : printout2Pointcut(){
		System.out.println("OrderAspec around in  ");
		proceed();
		System.out.println("OrderAspec around out ");
	}
	
	before() : printout2Pointcut(){
		System.out.println("OrderAspec before ");
	}
	
	after() : printout2Pointcut(){
		System.out.println("OrderAspec after ");
	}


}