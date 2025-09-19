package lab2;

import java.util.Arrays;

/* 
 * ІО-33 Замковий Віталій
 * Залікова №3310
 */
public class lab2 {
  private static void printResult(String text, char c) {
    String[] words = text.split("\\s+");

    Arrays.sort(words, (w1, w2) -> {
      int count1 = countChar(w1, c);
      int count2 = countChar(w2, c);
      if (count1 != count2) {
        return Integer.compare(count2, count1);
      } else {
        return w1.compareTo(w2);
      }
    });

    System.out.println("Вiдсортованi слова:");
    for (String word : words) {
      System.out.println(c + " = " + countChar(word, c) + ": " + word);
    }
  }

  private static int countChar(String word, char c) {
    int count = 0;
    for (int i = 0; i < word.length(); i++) {
      if (word.charAt(i) == c) {
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    // C3 = 3310 % 3 = 1
    String text = "bruuuh nah uh equal to no no";
    // C17 = 3310 % 17 = 12
    char count = 'u';
    printResult(text, count);
  }

}
