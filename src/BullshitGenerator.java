import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class BullshitGenerator {

    static ArrayList<String> words = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        readFile();
        //generateSentence("emigráció", words, 10);
    }

    public static void readFile() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("C:/MarkRobiRepo/Mark-Robi-repo/txtFiles/AranyLaszlo.txt"));
        while (sc.hasNext()) {
            String word = sc.next();
            if (word.contains(",") || word.contains(".") || word.contains("-") || words.contains(":") || words.contains("?") || words.contains("!") || words.contains("*")) {
                String modifiedWord = word.substring(0, word.length() - 1);
                word = modifiedWord;
            }
            words.add(word);
        }
        System.out.println(words);
    }

    public static void generateSentence (String from, ArrayList<String> words, int number) {
        ArrayList<String> sentence = new ArrayList<>();
        int index = 0;
        int count = 0;
        for (int i = 0; i < words.size(); i++) {
            if (from.equals(words.get(i))){
                sentence.add(words.get(i));
                index = i;
                count ++;
                break;
            }
            else if (count == 0){
                System.out.println("Ez a szó nem szerepel a szövegben, kérem adjon meg egy új szót!");
            }
        }
        String element = words.get(index + 1);
        /*int counter = 0;
        for (int j = index + 1; j < words.size(); j++) {
            String tempElement = words.get(j);
            int tempCounter = 0;
            for (int p = index + 2; p < words.size(); p++) {
                if (words.get(p).equals(tempElement)){
                    tempCounter++;
                    if (tempCounter > counter){
                        element = tempElement;
                        counter = tempCounter;
                    }
                }
            }
        }
        sentence.add(element);
        System.out.println(sentence);*/
        HashMap<String, Integer> x = new HashMap<>();
        for (int i = index + 1; i < words.size(); i++) {
            if (x.containsKey(words.get(i))){
                int counter = x.get(words.get(i)) + 1;
                x.put(words.get(i), counter);
            }
            x.putIfAbsent(words.get(i), 1);
        }
        System.out.println(x);
        Set<Map.Entry<String, Integer>> xy = x.entrySet();
        for (int i = 0; i < number; i++) {
            int minValue = 0;
            String actualString = "";
            for (Map.Entry<String, Integer> wordEntries : xy) {
                if (wordEntries.getValue() > minValue && !sentence.contains(wordEntries.getKey())){
                    minValue = wordEntries.getValue();
                    actualString = wordEntries.getKey();
                }
            }
            sentence.add(actualString);
        }
        System.out.println(sentence);
    }
}
