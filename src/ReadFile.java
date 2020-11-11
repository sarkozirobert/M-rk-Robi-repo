import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ReadFile {
    List<String> words = new ArrayList<>();


    public ReadFile() throws FileNotFoundException{
        readFile();
    }

    public void readFile()throws FileNotFoundException {
        Scanner sc = new Scanner(new File("files/borbala.txt"));
        while(sc.hasNext()){
            String word = sc.next();
            if(word.contains(".") || word.contains("!") || word.contains("?") || word.contains(",") || word.contains(";") || word.contains("-")){
                String store = word.substring(0, word.length() - 1);
                word = store;
            }

            words.add(word);
        }
        System.out.println(words);
    }

    public void removePunctuationMarks(){
        String  probe= "dontWork";
                probe.substring(4);
                String tr = probe.substring(4);
        System.out.println(tr);
    }

    public Map<Integer, String> toptenMostUsedWords(){
        Map<Integer,String> topTen = new HashMap<>();
        for (String word : words){

        }

        return topTen;
    }

    @Override
    public String toString() {
        return "ReadFile{}";
    }
}
