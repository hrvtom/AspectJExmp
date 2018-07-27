public aspect AspectOrdering{
	declare precedence: AfterAspec1,AroundAspec1,BeforeAspec2,BeforeAspec1,AroundAspec2,AfterAspec2;
}
