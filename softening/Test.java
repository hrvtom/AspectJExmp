import java.util.Date;
import java.rmi.RemoteException;

public class Test {
    public static void main(String[] args) {
	DateFetcher dfLocal = new DateFetcherImpl();
	Date currentDate = dfLocal.getCurrentDate();

	System.out.println("Current date is: " + currentDate);
    }

	public static aspect SoftenAspect {
	declare soft : 
	    RemoteException : (call(public * DateFetcher.*(..))
			       || call(public DateFetcherImpl.new(..)))
	                      && within(Test);
    }
}
