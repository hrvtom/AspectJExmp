public aspect AfterAspec1 extends PresedenceAspec{
	
	after() : printoutPointcut(){
		System.out.println("AfterAspec1 after ");
	}
}