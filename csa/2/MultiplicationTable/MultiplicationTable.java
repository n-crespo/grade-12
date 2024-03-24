import java.util.Scanner;

public class MultiplicationTable {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the number of rows: ");
    int rows = scanner.nextInt();

    System.out.print("Enter the number of columns: ");
    int cols = scanner.nextInt();

    int[][] multiplicationTable = new int[rows][cols];

    // Populate the multiplication table
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        multiplicationTable[i][j] = (i + 1) * (j + 1);
      }
    }

    // Print the multiplication table header
    System.out.print("0 ");
    printSpaces(5 - countDigits(0));
    for (int j = 1; j <= cols; j++) {
      System.out.print(j);
      printSpaces(5 - countDigits(j));
    }
    System.out.println();

    for (int i = 0; i < rows; i++) {
      System.out.print((i + 1));
      printSpaces(6 - countDigits(i + 1));
      for (int j = 0; j < cols; j++) {
        System.out.print(multiplicationTable[i][j]);
        printSpaces(5 - countDigits(multiplicationTable[i][j]));
      }
      System.out.println();
    }

    scanner.close();
  }

  // Function to print spaces
  private static void printSpaces(int count) {
    for (int i = 0; i < count; i++) {
      System.out.print(" ");
    }
  }

  public static int countDigits(int number) {
    int count = 0;
    if (number == 0) {
      return 1;
    }
    while (number != 0) {
      number /= 10;
      count++;
    }
    return count;
  }

}
