// EventListenerUniqueness.java
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

import javax.swing.table.*;

public abstract aspect EventListenerUniqueness 
    extends EventListenerManagement {
    void around(Object model, EventListener listener) 
	: addListenerCall(model, listener) {

	EventListener[] listeners = getCurrentListeners(model);
	System.out.println(">>>EventListenerUniqueness: get current listeners");
	if (!Utils.isInArray(listeners, listener)) {
	    System.out.println(">>>EventListenerUniqueness: Adding Listener, accepting new " + listener);
	    proceed(model, listener);
	} else {
	    System.out.println(">>>EventListenerUniqueness: Adding listener, listener already listening " + listener);
	}
    }

    public abstract EventListener[] getCurrentListeners(Object model);
}
