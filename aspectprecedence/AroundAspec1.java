public aspect AroundAspec1 extends PresedenceAspec{
	
	void around() : printoutPointcut(){
		System.out.println("AroundAspec1 around in");
		proceed();
		System.out.println("AroundAspec1 around out");
	}
}
