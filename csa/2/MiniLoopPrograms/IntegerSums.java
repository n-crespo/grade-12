import java.util.Scanner;

/**
 * IntegerSums
 */
public class IntegerSums {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int num;
    int count = 0;
    int sum = 0;
    while (true) {
      if (count == 10) {
        break;
      }
      System.out.print("Enter a number: ");
      num = scan.nextInt();
      if (num == 0) {
        break;
      } else {
        sum += num;
      }
      count++;
    }
    System.out.println(sum);

    scan.close();
  }
}
