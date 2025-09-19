package lab1;

/* 
 * ІО-33 Замковий Віталій
 * Залікова №3310
 */
public class lab1 {
  // C7 = 3310 % 7 = 5
  char[][] B = {
      { 'a', 'b', 'c', 'd' },
      { 'e', 'f', 'g', 'h' },
      { 'i', 'j', 'k', 'l' },
      { 'm', 'n', 'o', 'p' }
  };

  int a = 2;
  int rows = B.length;
  int cols = B[0].length;

  int[][] C = new int[rows][cols];
  // C5 = 3310 % 5 = 0
  public lab1() {
    for (int i = 0; i < rows; i++) {
      for (int k = 0; k < cols; k++) {
        C[i][k] = a * B[i][k];
      }
    }
  }

  public void printC() {
    System.out.println("Матриця С:");
    for (int i = 0; i < rows; i++) {
      for (int k = 0; k < cols; k++) {
        System.out.print(C[i][k] + " ");
      }
      System.out.println();
    }
  }
  // C5 = 3310 % 11 = 10
  public void averageValue() {
    int sum = 0;
    int count = 0;
    System.out.println("Середня значення елементів матриці:");
    for (int i = 0; i < rows; i++) {
      for (int k = 0; k < cols; k++) {
        sum += C[i][k];
        count += 1;
      }
    }
    System.out.println(sum/count);
  }

  public static void main(String[] args) {
    lab1 obj = new lab1();
    obj.printC();
    obj.averageValue();
  }

}
