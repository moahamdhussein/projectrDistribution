package methods;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 *
 * @author Anas
 */
public class Shortest implements Runnable  {
     Scanner txtFile;

    public Shortest()  {
        try {
            this.txtFile = new Scanner(new File("E:\\distributed\\projectrDistribution\\New Text Document.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
@Override
    public void run() {
      String shortestWord = txtFile.next();
 while (txtFile.hasNext()) {
        String Word = txtFile.next();
         if (Word.length() < shortestWord.length()) {
            shortestWord = Word;

        }
    }
     txtFile.close();
     System.out.println("the shortest Word in text file is "+shortestWord);

    }
    
}
