// DateFetcherLocalImpl.java

import java.rmi.*;
import java.rmi.server.*;
import java.util.Date;

public class DateFetcherImpl extends UnicastRemoteObject 
    implements DateFetcher {

    public DateFetcherImpl() throws RemoteException {
    }

    public Date getCurrentDate() throws RemoteException {
	return new Date();
    }
}
