public aspect MyAspectOrdering{
	//ne radi s apstraknitm apectima
	//declare precedence: EventListenerWeakening,EventListenerUniqueness;
	declare precedence: TableModelListenerWeakening,TableModelListenerUniqueness;
	declare precedence: ListDataListenerWeakening,ListDataListenerUniqueness;

}
