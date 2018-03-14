import java.awt.*;

/**
 * Aspect that warns if swing components are updated from a
 * non-event dispatch thread.
 *
 * Since current AspectJ does not allow byte-code weaving, the implementation
 * is little complex. It is required to manually
 * encode each method that updates model. Besides, it does not take care of
 * custom models.
 *
 * The implementation is for illustration only. It takes care of only
 * part of DefaultTableModel and DefaultListModel. 
 */
public aspect SwingThreadSafetyCheckAspect {
    private static final String WARNING_MESSAGE
	= "BEWARE: Swing update called from non-AWT thread\n"
	+ "Change code to use EvenetQueue.invokeLater() or invokeAndWait()";
    
    // Define a pointcut to capture calls to TableModel and its subclass's
    // method that would update UI. Note, this list is incomplete.
    pointcut swingTableUpdateCalls() : 
	   call(* javax..*TableModel+.set*(..))
	|| call(* javax..*TableModel+.add*(..))
	|| call(* javax..*TableModel+.remove*(..));
    
    // Define a pointcut to capture calls to ListModel and its subclass's
    // method that would update UI. Note, this list is not complete.
    pointcut swingListUpdateCalls() :
	   call(* javax..*ListModel+.set*(..))
	|| call(* javax..*ListModel+.insert*(..));

    // Pointcuts for tree, text, etc. models
    // Implementation left out...

    // Pointcut for update to any swing model (use || to add pointcuts
    // to be defined above for tree, text etc.)
    pointcut swingUpdateCalls() 
	: swingTableUpdateCalls() || swingListUpdateCalls();

    /**
     * Advice to print a warning and stack trace that led to call
     * to swing update methods from non-event dispatch thread.
     */
    before() : swingUpdateCalls() && !if(EventQueue.isDispatchThread()) {
	// Real implementation would probably just log these.
	// It won't be nice for user to see this.
	System.err.println(WARNING_MESSAGE);
	System.err.println("Joinpoint captured: " + thisJoinPoint);
	Thread.dumpStack();
	System.err.println();
    }
}
