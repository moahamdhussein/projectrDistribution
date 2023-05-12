import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Anas
 */
public class Repeat implements Runnable  {
     HashMap<String, Integer> map = new HashMap<String, Integer>();
     Scanner txtFile;
    public Repeat() throws FileNotFoundException {
        this.txtFile = new Scanner(new File("E:\\distributed\\projectrDistribution\\New Text Document.txt"));
    }
@Override
    public void run() {

        while (txtFile.hasNext()) {
        String Word = txtFile.next();
       
        if(map.containsKey(Word)){
            int count = map.get(Word)+1;
            map.put(Word, count);
        }
        else{
            map.put(Word, 1);
        }
        }
     txtFile.close();
     for (Map.Entry<String, Integer>entry : map.entrySet()){
         System.out.println(entry);
    }

}
}

    

