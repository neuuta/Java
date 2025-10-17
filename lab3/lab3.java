package lab3;

import java.util.Arrays;
import java.util.Objects;

/* 
 * ІО-33 Замковий Віталій
 * Залікова №3310
 */

/**
 * Клас Block представляє об'єкт "блок" з певними характеристиками:
 * назвою, вагою, висотою, шириною та кількістю.
 */
class Block {
  String name;
  int weight, height, width, amount;

  /**
   * Конструктор для створення блоку з параметрами.
   */
  public Block(String name, int weight, int height, int width, int amount) {
    this.name = name;
    this.weight = weight;
    this.height = height;
    this.width = width;
    this.amount = amount;
  }

  /**
   * Повертає текстове представлення об'єкта Block.
   */
  public String toString() {
    return "Block{" + "name='" + name + '\'' + ", weight=" + weight +
        ", height=" + height + ", width=" + width + ", amount=" + amount + '}';
  }

  /**
   * Перевіряє рівність двох об'єктів Block за всіма полями.
   */
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof Block))
      return false;
    Block block = (Block) o;
    return weight == block.weight &&
        height == block.height &&
        width == block.width &&
        amount == block.amount &&
        Objects.equals(name, block.name);
  }

}

/**
 * Основний клас програми для демонстрації роботи з масивом об’єктів Block.
 */
public class lab3 {
  // C11 = 3310 % 11 = 10

  /**
   * Головний метод програми.
   * Створює масив блоків, сортує їх і перевіряє наявність заданого елемента.
   */
  public static void main(String[] args) {
    // Створення масиву блоків
    Block[] blocks = {
        new Block("Stone", 10, 5, 5, 100),
        new Block("Wood", 5, 5, 5, 50),
        new Block("Iron", 15, 5, 5, 30),
        new Block("Sand", 1, 5, 5, 200),
        new Block("Diamond", 15, 5, 5, 40)
    };

    // Сортування блоків за вагою, а при рівній вазі — за кількістю 
    Arrays.sort(blocks, (b1, b2) -> {
      int weightCompare = Integer.compare(b1.weight, b2.weight);
      if (weightCompare != 0) {
        return weightCompare;
      } else {
        return Integer.compare(b2.amount, b1.amount);
      }
    });

    // Вивід відсортованих блоків
    System.out.println("Вiдсортованi блоки:");
    for (Block b : blocks) {
      System.out.println(b);
    }

    // Створення блоку для пошуку в масиві
    Block target = new Block("Wood", 5, 5, 5, 50);
    boolean found = Arrays.asList(blocks).contains(target);

    // Виведення результату пошуку
    System.out.println("\nЧи є об'єкт " + target + " в масивi? " + "\nРезультат:"+found);
  }
}
