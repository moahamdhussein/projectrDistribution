import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class Client {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        Call stub =
                (Call) Naming.lookup("//localhost:5000/test");

        Scanner scanner = new Scanner(System.in);
        System.out.println("enter 1 for thread and enter 2 for sequential");
        int x = scanner.nextInt();
        if (x == 1) {
            ExecutorService executor = Executors.newFixedThreadPool(5);
            executor.submit(() -> {
                try {
                    long startTime = System.currentTimeMillis();
                    int count = stub.count("E:\\distributed\\projectrDistribution\\New Text Document.txt");
                    long endTime = System.currentTimeMillis();
                    long elapsedTime = endTime - startTime;
                    System.out.println("Thread: " + Thread.currentThread().getName() + " | Count: " + count + " | Time: " + elapsedTime + "ms");
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }); // count
            executor.submit(() -> {
                try {
                    long startTime = System.currentTimeMillis();
                    String[] repeatedWords = stub.repeatedWords("E:\\distributed\\projectrDistribution\\New Text Document.txt");
                    long endTime = System.currentTimeMillis();
                    long elapsedTime = endTime - startTime;
                    System.out.println("Thread: " + Thread.currentThread().getName() + " | Time: " + elapsedTime + "ms"+ "\n"+"Repeated Words: " + Arrays.toString(repeatedWords));
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }); // repeated word
            executor.submit(() -> {
                try {
                    long startTime = System.currentTimeMillis();
                    String[][] word = stub.word("E:\\distributed\\projectrDistribution\\New Text Document.txt");
                    long endTime = System.currentTimeMillis();
                    long elapsedTime = endTime - startTime;
                    System.out.println("Thread: " + Thread.currentThread().getName() + " | Time: " + elapsedTime + "ms");
                    for (int i = 0; i < word.length; i++) {
                        if (word[i][0] != null) {
                            System.out.print(" ");
                            System.out.print(word[i][0] + ":\t");
                            System.out.print(word[i][1]);
                            System.out.print(" ");
                        }
                    }
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }); // word
            executor.submit(() -> {
                try {
                    long startTime = System.currentTimeMillis();
                    String shortest = stub.shortest("E:\\distributed\\projectrDistribution\\New Text Document.txt");
                    long endTime = System.currentTimeMillis();
                    long elapsedTime = endTime - startTime;
                    System.out.println("Thread: " + Thread.currentThread().getName() + " | shortest Words: " + shortest + " | Time: " + elapsedTime + "ms");
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }); // shortest word
            executor.submit(() -> {
                try {
                    long startTime = System.currentTimeMillis();
                    String longest = stub.longest("E:\\distributed\\projectrDistribution\\New Text Document.txt");
                    long endTime = System.currentTimeMillis();
                    long elapsedTime = endTime - startTime;
                    System.out.println("Thread: " + Thread.currentThread().getName() + " | longest Words: " + longest + " | Time: " + elapsedTime + "ms");
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }); // longest word
            executor.shutdown();
        }
        else if (x == 2) {
            Long startTime = System.currentTimeMillis(); // start time

            // print all word with count of each word
            String[][] word = stub.word("E:\\distributed\\projectrDistribution\\New Text Document.txt");
            System.out.println("The number of word");
            for (int i = 0; i < word.length; i++) {
                if (word[i][0] != null) {
                    System.out.print(word[i][0] + ":\t");
                    System.out.println(word[i][1]);
                }
            }


            // print repeatedWord
            System.out.println("\nThe number of repeated word");
            String[] repeatedWord = stub.repeatedWords("E:\\distributed\\projectrDistribution\\New Text Document.txt");
            System.out.println("repeatedWord : " + Arrays.toString(repeatedWord));

            // print longest word
            System.out.println("Longest Word: " + stub.longest("E:\\distributed\\projectrDistribution\\New Text Document.txt"));

            // print shortest word
            System.out.println("Shortest word: " + stub.shortest("E:\\distributed\\projectrDistribution\\New Text Document.txt"));

            // print Count of character
            System.out.println("Count of character: " + stub.count("E:\\distributed\\projectrDistribution\\New Text Document.txt"));

            // print eclipsed time
            System.out.println("time for print  " + (System.currentTimeMillis() - startTime));
        }
    }
}
