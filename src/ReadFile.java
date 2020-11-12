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
            if(word.contains(".") || word.contains("!") || word.contains("?") || word.contains(",") || word.contains(";") || word.contains(":")){
                String store = word.substring(0, word.length() - 1);
                word = store;
            }
            words.add(word);
            if(word.equals("-") || word.equals(" ")){
                words.remove(word);
            }
        }
        System.out.println(words);
    }

    public void removePunctuationMarks(){
        String  probe = "dontWork";
                probe.substring(4);
                String pr = probe.substring(4);
        System.out.println(pr);
    }

    public Map<String, Integer> topTenMostUsedWords(){
        int max = 0;
        Map<String, Integer> topTen = new HashMap<>();
        Map<String, Integer> counting = new HashMap<>();

        for (String word : words) {
            counting.putIfAbsent(word, 0);
            int count = counting.get(word);
            counting.put(word, ++count);
        }
        while (topTen.size() <= 10) {
            max = 0;
            String word= "grh";
            for (String key : counting.keySet()) {
                if (max < counting.get(key) && !topTen.containsKey(key)) {
                    max = counting.get(key);
                    word = key;
                }
            }
                    topTen.put(word, max);
            }
        return topTen;
    }

    @Override
    public String toString() {
        return "ReadFile{}";
    }
}
