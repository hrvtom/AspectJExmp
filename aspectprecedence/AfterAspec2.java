public aspect AfterAspec2 extends PresedenceAspec{
	
	after() : printoutPointcut(){
		System.out.println("AfterAspec2 after ");
	}
}
