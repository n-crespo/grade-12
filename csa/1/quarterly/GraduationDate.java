import java.util.Scanner;

public class GraduationDate {

  public static void main(String[] args) {

    System.out.print("Enter the number of days until graduation: ");
    Scanner scan = new Scanner(System.in);
    int days = scan.nextInt();

    int months = days / 30;
    days -= months * 30;
    int weeks = days / 7;
    days -= weeks * 7;

    System.out.println("Months: " + months);
    System.out.println("Weeks: " + weeks);
    System.out.println("Days: " + days);

  }
  // this is a test
}
