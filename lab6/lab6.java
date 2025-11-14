package lab6;

import java.util.Arrays;

public class lab6 {
  public static void main(String[] args) {
    // Створюємо кілька літаків (використовуємо класи з ЛР5)
    PassengerAircraft pa1 = new PassengerAircraft("Passenger Aircraft1", 5000, 2600, 180);
    PassengerAircraft pa2 = new PassengerAircraft("Passenger Aircraft2", 6100, 2500, 170);
    CargoAircraft ca1 = new CargoAircraft("Cargo Aircraft1", 4800, 7200, 120);
    CargoAircraft ca2 = new CargoAircraft("Cargo Aircraft2", 7800, 6800, 130);

    // Порожній список
    MyLinkedList<Aircraft> list1 = new MyLinkedList<>();

    // Список з одним літаком
    MyLinkedList<Aircraft> list2 = new MyLinkedList<>(pa1);

    // Список із колекції
    MyLinkedList<Aircraft> list3 = new MyLinkedList<>(Arrays.asList(pa2, ca1, ca2));

    // Додаємо ще кілька елементів до першого списку
    list1.add(pa1);
    list1.add(pa2);
    list1.add(ca1);
    list1.add(ca2);

    System.out.println("=== Вміст колекції (MyLinkedList) ===");
    for (Aircraft a : list1) {
      a.displayInfo();
    }

    System.out.println("\nРозмір списку: " + list1.size());
    System.out.println("Елемент з індексом 2: " + list1.get(2).getModel());

    // Видалення елемента
    list1.remove(1);
    System.out.println("\nПісля видалення елемента №1:");
    for (Aircraft a : list1) {
      System.out.println(a);
    }
  }
}
