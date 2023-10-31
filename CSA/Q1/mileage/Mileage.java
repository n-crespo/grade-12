import java.util.Scanner;

public class Mileage {
  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    double expression = scan.nextDouble();

    System.out.println(expression);
    scan.close();
    System.out.println("--------------------------------");
    System.out.println("--------------------------------");
    int a[] = new int[5];// declaration and instantiation

    a[0] = 10;// initialization
    a[1] = 20;
    a[2] = 70;
    a[3] = 40;
    a[4] = 50;
    // traversing array
    for (int i = 0; i < a.length; i++)// length is the property of array
      System.out.println(a[i]);
  }
}
