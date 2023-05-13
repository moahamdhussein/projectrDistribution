import methods.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class remoteService extends UnicastRemoteObject implements Call {
    public remoteService() throws RemoteException {
        super();
    }

    @Override
    public void theredsMethods(String path) throws RemoteException {
        Repeat a1;
        Count a2;
        Longest a3;
        Shortest a4;
        Repeatedwords a5;
        a1 = new Repeat();
        a2 = new Count();
        a3 = new Longest();
        a4 = new Shortest();
        a5 = new Repeatedwords();
        Thread t1 = new Thread(a1);
        Thread t2 = new Thread(a2);
        Thread t3 = new Thread(a3);
        Thread t4 = new Thread(a4);
        Thread t5 = new Thread(a5);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

    @Override
    public String[] repeatedWords(String path) throws RemoteException {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        Scanner txtFile = null;
        String[] words = new String[300];
        try {
            txtFile = new Scanner(new File(path));
            while (txtFile.hasNext()) {
                String Word = txtFile.next();

                if (map.containsKey(Word)) {
                    int count = map.get(Word) + 1;
                    map.put(Word, count);
                } else {
                    map.put(Word, 1);
                }

            }
            txtFile.close();

            int i = 0;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() > 1) {
                    words[i] = entry.getKey();
                    i++;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return words;
    }



    @Override
    public String[][] repeat(String path) throws RemoteException {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        Scanner txtFile = null;
        String[][] words = new String[300][2];
        try {
            txtFile = new Scanner(new File(path));
            while (txtFile.hasNext()) {
                String Word = txtFile.next();

                if (map.containsKey(Word)) {
                    int count = map.get(Word) + 1;
                    map.put(Word, count);
                } else {
                    map.put(Word, 1);
                }

            }
            txtFile.close();
            int i = 0;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    words[i][0] = entry.getKey();
                    words[i][1] = entry.getValue().toString();
                    i++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return words;
    }

    @Override
    public int count(String path) throws RemoteException {
        int numchar = 0;
        Scanner txtFile = null;
        try {
            txtFile = new Scanner(new File(path));
            while (txtFile.hasNext()) {
                String Word = txtFile.next();
                int size = Word.length();
                for (int i = 0; i < size; i++) {
                    numchar++;
                }
            }
            txtFile.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return numchar;

    }

    @Override
    public String longest(String path) throws RemoteException {
        String longestWord = "";
        Scanner txtFile = null;
        try {
            txtFile = new Scanner(new File(path));
            while (txtFile.hasNext()) {
                String Word = txtFile.next();
                if (Word.length() > longestWord.length()) {
                    longestWord = Word;
                }
            }
            txtFile.close();
            System.out.println("the longest Word in text file is " + longestWord);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return longestWord;
    }

    @Override
    public String shortest(String path) throws RemoteException {
        String shortestWord = "kkkkkkkkkkkkkkkkkkkkkkkkkk";
        Scanner txtFile = null;
        try {
            txtFile = new Scanner(new File(path));
            while (txtFile.hasNext()) {
                String Word = txtFile.next();
                if (Word.length() < shortestWord.length()) {
                    shortestWord = Word;
                }
            }
            txtFile.close();
            System.out.println("the shortest Word in text file is " + shortestWord);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return shortestWord;
    }




}
