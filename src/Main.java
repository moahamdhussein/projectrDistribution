import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {
    public static void main(String[] args) throws RemoteException {
            Registry r = LocateRegistry.createRegistry(5000);
            r.rebind("test", new remoteService());
            System.out.print("server is ready");
    }
}