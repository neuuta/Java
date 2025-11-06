package lab4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


/* 
 * ІО-33 Замковий Віталій
 * Залікова №3310
 */
public class lab4 {

    /**
     * Сортує та виводить результат.
     */
    private static void printResult(Text text, char c) {
        List<Word> allWords = new ArrayList<>();
        for (Sentence s : text.getSentences()) {
            allWords.addAll(s.getWords());
        }

        allWords.sort(Comparator
                .comparingInt((Word w) -> w.countChar(c))
                .reversed()
                .thenComparing(Word::getWord));

        System.out.println("Відсортовані слова:");
        for (Word w : allWords) {
            System.out.printf("%c = %d: %s%n", c, w.countChar(c), w);
        }
    }

    public static void main(String[] args) {
        // C3 = 3310 % 3 = 1
        String inputText = "bruuuh nah  uh equal to no no";
        // C17 = 3310 % 17 = 12
        char countChar = 'u';

        Text text = new Text(inputText);
        printResult(text, countChar);
    }
}