public aspect BeforeAspec1 extends PresedenceAspec{
	
	before() : printoutPointcut(){
		System.out.println("BeforeAspec1 before ");
	}
}
