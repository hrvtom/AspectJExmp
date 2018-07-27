public aspect AroundAspec2 extends PresedenceAspec{
	
	void around() : printoutPointcut(){
		System.out.println("AroundAspec2 around in");
		proceed();
		System.out.println("AroundAspec2 around out");
	}
}
