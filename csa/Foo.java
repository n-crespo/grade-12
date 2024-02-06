import java.util.Scanner;

public class Foo {
  public static void main(String[] args) {
    // int[] numbers = { 1, 2, 3, 4, 5 };

    // // // Manipulate values in the array using a regular for loop
    // // for (int i = 0; i < numbers.length; i++) {
    // // // You can modify the original elements of the array
    // // numbers[i] = numbers[i] * 2;
    // // System.out.println(numbers[i]);
    // // }

    // for (int number : numbers) {
    // number = number * 2;
    // System.out.println(number);
    // }

    // System.out.println("-----------");

    // for (int num : numbers) {
    // System.out.println(num);
    // }

    // for (int number : numbers) {
    // number = number * 2;
    // System.out.println(number);
    // }

    // System.out.println("-----------");
    // for (int num : numbers) {
    // System.out.println(num);
    // }

    // System.out.println("-----------");
    int[] originalArray = { 1, 2, 3, 4, 5 };
    int[] modifiedArray = new int[originalArray.length];

    // Iterate through the original array using a for-each loop
    int index = 0;
    for (int value : originalArray) {
      // Multiply each value by 2 and store it in the new array
      modifiedArray[index] = value * 2;
      index++;
    }

    // Print the modified values
    System.out.println("Modified Values:");
    for (int modifiedValue : modifiedArray) {
      System.out.println(modifiedValue);
    }
    // for (int number : numbers) {
    // numbers[numbers.indexOf(number)]

    // }

    // The original array has been modified
    // for (int num : numbers) {
    // System.out.println(num);
    // }
  }
}
