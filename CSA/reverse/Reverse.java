import java.util.Scanner;

public class Reverse {
  public static void main(String[] args) {
    System.out.print("Enter your number: ");
    Scanner scan = new Scanner(System.in);
    String input = scan.nextLine();
    StringBuilder input1 = new StringBuilder();
    input1.append(input);
    input1.reverse();
    System.out.println(input1);
    scan.close();
  }
}