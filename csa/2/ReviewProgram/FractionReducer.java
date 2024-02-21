import java.util.Scanner;

public class FractionReducer {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the numerator: ");
    int numerator = scanner.nextInt();

    System.out.print("Enter the denominator: ");
    int denominator = scanner.nextInt();

    if (denominator == 0) {
      System.out.println("Error: Denominator cannot be zero.");
      scanner.close(); // i have an LSP which checks the code for simple errors, it gets mad at me
                       // whenever i don't "close" the scanner
      return;
    }

    int i = Math.min(denominator, numerator);

    while (i > 1) {
      if (numerator % i == 0 && denominator % i == 0) {
        numerator /= i;
        denominator /= i;
        break;
      }
      i--;
    }

    if (i == 1 || i == 0) {
      System.out.println("The fraction is already reduced.");
    } else {
      System.out.println("reduced by " + i);
      System.out.println("Reduced fraction: " + numerator + "/" + denominator);
    }
    scanner.close(); // see line 15
  }
}
