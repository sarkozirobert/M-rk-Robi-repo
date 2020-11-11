import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BullshitGenerator {

    public static void main(String[] args) throws FileNotFoundException {
        readFile();
    }

    public static void readFile() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("txtFiles/Arany László A magyar emigráció mozgalmai.txt"));
        ArrayList<String> words = new ArrayList<>();
        while (sc.hasNext()) {
            String word = sc.next();
            if (word.contains(",") || word.contains(".") || word.contains("-") || words.contains(":") || words.contains("?") || words.contains("!") || words.contains("*")) {
                String modifiedWord = word.substring(0, word.length() - 1);
                word = modifiedWord;
            }
            words.add(word);
        }
    }
}
