import java.rmi.*;
import java.util.Date;

public interface DateFetcher extends Remote {
    public Date getCurrentDate() throws RemoteException;
}
