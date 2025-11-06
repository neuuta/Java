package lab4;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас, що представляє слово, яке складається з літер.
 */
public class Word {
    private final List<Letter> letters = new ArrayList<>();

    public Word(String word) {
        for (char c : word.toCharArray()) {
            letters.add(new Letter(c));
        }
    }

    /**
     * Підрахунок кількості входжень певного символу в слові.
     */
    public int countChar(char c) {
        int count = 0;
        for (Letter l : letters) {
            if (l.getSymbol() == c) {
                count++;
            }
        }
        return count;
    }

    public String getWord() {
        StringBuilder sb = new StringBuilder();
        for (Letter l : letters) {
            sb.append(l.getSymbol());
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return getWord();
    }
}
