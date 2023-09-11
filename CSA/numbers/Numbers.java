import java.util.Scanner;
public class Numbers {
    public static void main(String args[]) {
      Scanner scan = new Scanner(System.in);

      System.out.print("num1: ");
      int num1 = scan.nextInt();

      System.out.print("num2: ");
      int num2 = scan.nextInt();

      System.out.print("num3: ");
      int num3 = scan.nextInt();

      double result = num1 * num2;
      result = (result)/num3;
      System.out.println("result: " + result);

      System.out.println("rounded: " + ((int) Math.round(result)));
    }
}
