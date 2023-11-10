import java.util.Scanner;

public class Program2 {
  public static void main(String[] args) {
    
    Scanner scan  = new Scanner(System.in);
    System.out.print("Enter name one: ");
    String name1 = scan.nextLine();
    System.out.print("Enter name two: ");
    String name2 = scan.nextLine();
    System.out.print("Enter name three: ");
    String name3 = scan.nextLine();

    System.out.println(name3 + ", " + name2 + "," + name1);

  }
}
