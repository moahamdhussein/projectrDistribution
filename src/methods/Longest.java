import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Anas
 */
public class Longest implements Runnable  {
     Scanner txtFile;

    public Longest() throws FileNotFoundException {
        this.txtFile = new Scanner(new File("E:\\distributed\\projectrDistribution\\New Text Document.txt"));
    }

@Override
    public void run() {
     String longestWord = "";
     while (txtFile.hasNext()) {
        String Word = txtFile.next();
if (Word.length() > longestWord.length()) {
            longestWord = Word;
        }
    }
         txtFile.close();
     System.out.println("the longest Word in text file is "+longestWord);

}}