import java.util.Date;

public class Test {
    public static void main(String[] args) {
	DateFetcher dfLocal = new DateFetcherImpl();
	Date currentDate = dfLocal.getCurrentDate();

	System.out.println("Current date is: " + currentDate);
    }

    private static aspect SoftenDateFetcherRemoteException {
	declare soft : 
	    RemoteException : (call(public * DateFetcher.*(..))
			       || call(public DateFetcherImpl.new(..)))
	                      && within(Test);
    }
}
