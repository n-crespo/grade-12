import java.util.Scanner;
public class Program1 {
  public static void main(String[] args){
  System.out.println("Enter your name: ");
  Scanner scan = new Scanner(System.in);
  String input = scan.nextLine();

  System.out.println("Hi" + input + ", welcome to CSA!");
  }
}
