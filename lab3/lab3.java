package lab3;

import java.util.Arrays;
import java.util.Objects;

/* 
 * ІО-33 Замковий Віталій
 * Залікова №3310
 */
class Block {
  String name;
  int weight, height, width, amount;

  public Block(String name, int weight, int height, int width, int amount) {
    this.name = name;
    this.weight = weight;
    this.height = height;
    this.width = width;
    this.amount = amount;
  }

  public String toString() {
    return "Block{" + "name='" + name + '\'' + ", weight=" + weight +
        ", height=" + height + ", width=" + width + ", amount=" + amount + '}';
  }

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

public class lab3 {
  // C11 = 3310 % 11 = 10
  public static void main(String[] args) {
    Block[] blocks = {
        new Block("Stone", 10, 5, 5, 100),
        new Block("Wood", 5, 5, 5, 50),
        new Block("Iron", 15, 5, 5, 30),
        new Block("Sand", 1, 5, 5, 200),
        new Block("Diamond", 17, 5, 5, 10)
    };

    Arrays.sort(blocks, (b1, b2) -> {
      int weightCompare = Integer.compare(b1.weight, b2.weight);
      if (weightCompare != 0) {
        return weightCompare;
      } else {
        return Integer.compare(b2.amount, b1.amount);
      }
    });

    System.out.println("Відсортовані блоки:");
    for (Block b : blocks) {
      System.out.println(b);
    }

    Block target = new Block("Wood", 5, 5, 5, 50);
    boolean found = Arrays.asList(blocks).contains(target);

    System.out.println("\nЧи є об'єкт " + target + " в масиві? " + found);
  }
}
