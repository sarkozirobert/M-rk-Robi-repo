import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        ReadFile bori = new ReadFile();
        bori.removePunctuationMarks();
        System.out.println(bori.topTenMostUsedWords());
    }
}
