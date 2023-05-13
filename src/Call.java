import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;

public interface Call extends Remote {
    public void theredsMethods(String path) throws RemoteException ;

    public String[] repeatedWords(String path) throws RemoteException ;
    public String[][] repeat(String path) throws RemoteException ;
    public int count(String path) throws RemoteException ;

    public  String longest(String path) throws RemoteException ;
    public String shortest(String path) throws RemoteException ;


}
