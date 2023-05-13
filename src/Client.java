import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        Call stub =
                (Call) Naming.lookup("//localhost:5000/test");

        String[][] repeat = stub.repeat("E:\\distributed\\projectrDistribution\\New Text Document.txt");
        System.out.println("The number of word");
        for (int i =0 ; i < repeat.length;i++){
            if (repeat[i][0]!= null){
                System.out.print(repeat[i][0]+":\t");
                System.out.println(repeat[i][1]);
            }
        }
        System.out.println("\nThe number of repeated word");
        String[] repeatedWord = stub.repeatedWords("E:\\distributed\\projectrDistribution\\New Text Document.txt");
        for (int i = 0 ; i<repeatedWord.length;i++){
            if (repeatedWord[i]!=null){
                System.out.println(repeatedWord[i]);
            }
        }

        System.out.println("Longest Word: "+stub.longest("E:\\distributed\\projectrDistribution\\New Text Document.txt"));
        System.out.println("Shortest word: "+stub.shortest("E:\\distributed\\projectrDistribution\\New Text Document.txt"));
        System.out.println("Count of character: "+stub.count("E:\\distributed\\projectrDistribution\\New Text Document.txt"));
    }
}
