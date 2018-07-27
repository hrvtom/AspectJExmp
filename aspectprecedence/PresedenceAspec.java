public abstract aspect PresedenceAspec{
	
	pointcut printoutPointcut(): execution(public * MonitorClass.printout());
	
}
