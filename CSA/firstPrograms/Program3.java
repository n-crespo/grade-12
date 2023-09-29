import java.util.Scanner;

public class Program3 {
  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    System.out.print("Enter your weight on Earth: ");
    final double earthWeight = scan.nextDouble();

    System.out.println("On Mercury you weigh: " + earthWeight * 0.4);
    System.out.println("On Venus you weigh: " + earthWeight * 0.9);
    System.out.println("On Mars you weigh: " + earthWeight * 0.38);
    System.out.println("On Jupiter you weigh: " + earthWeight * 2.3);
    System.out.println("On Saturn you weigh: " + earthWeight * 1.1);
    System.out.println("On Uranus you weigh: " + earthWeight * 0.92);
    System.out.println("On Neptune you weigh: " + earthWeight * 1.2);

    scan.close();

  }

}
