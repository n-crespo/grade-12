import java.util.Scanner;

public class Foo {
  public static void main(String[] args) {
    System.out.println("hello");
    Scanner scan = new Scanner(System.in);
    System.out.print("Say something: ");
    String inp = scan.nextLine();
    System.out.println("You said " + inp);
    scan.close();
  }
}
