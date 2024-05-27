package csa;

public class Animal {
  public void eat() {
    System.out.println("Eating");
  }

  public Animal() {
    System.out.println("Animal constructor");
  }

  public Animal(int n) {
    System.out.println("Animal constructor with a number");
  }

  public static void insertionSort(int[] elements) {
    for (int j = 1; j < elements.length; j++) {
      int temp = elements[j];
      int possibleIndex = j;
      while (possibleIndex > 0 && temp < elements[possibleIndex - 1]) {
        elements[possibleIndex] = elements[possibleIndex - 1];
        possibleIndex--;
      }
      elements[possibleIndex] = temp;
    }
  }

  public static void main(String[] args) {
  }
}
