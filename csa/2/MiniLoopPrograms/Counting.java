import java.util.Scanner;

/**
 * Counting
 */
public class Counting {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int num;
    int sum = 0;
    int pos = 0;
    int neg = 0;
    int count = 0;

    while (true) {
      System.out.print("Please enter an integer: ");
      num = scan.nextInt();
      if (num == 0) {
        break;
      } else {
        count++;
        sum += num;
        if (num < 0) {
          neg++;
        } else if (num > 0) {
          pos++;
        }
      }

    }
    System.out.println("You entered " + pos + " positive numbers.");
    System.out.println("You entered " + neg + " negative numbers.");
    System.out.println("The average of your numbers is " + sum / count + ".");
    scan.close();

  }
}
