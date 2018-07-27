public aspect BeforeAspec2 extends PresedenceAspec{
	
	before() : printoutPointcut(){
		System.out.println("BeforeAspec2 before ");
	}
}
