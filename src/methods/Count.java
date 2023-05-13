package methods;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Anas
 */
public class Count implements Runnable {

    Scanner txtFile;

    public Count() {
        try {
            this.txtFile = new Scanner(new File("E:\\distributed\\projectrDistribution\\New Text Document.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        int numchar = 0;

        while (txtFile.hasNext()) {
            String Word = txtFile.next();
            int size = Word.length();
            for (int i = 0; i < size; i++) {
                numchar++;
            }
        }
        txtFile.close();
        System.out.println(" number of character " + numchar);
    }
}
    

