import java.util.Scanner;

/**
 * IpAddresses
 */
public class IpAddresses {

  public static void main(String[] args) {
    // 128.253.21.58

    Scanner scan = new Scanner(System.in);

    System.out.println("Enter the first number: ");
    int num1 = scan.nextInt();

    System.out.println("Enter the first number: ");
    int num2 = scan.nextInt();

    System.out.println("Enter the first number: ");
    int num3 = scan.nextInt();

    System.out.println("Enter the first number: ");
    int num4 = scan.nextInt();

    boolean goodIP = true;
    // check for bad address
    if (!(0 <= num1 && num1 <= 255)) {
      System.out.println("Octet 1 is incorrect. ");
      goodIP = false;
    }
    if (0 <= num2 && num2 <= 255) {
      System.out.println("Octet 2 is incorrect. ");
      goodIP = false;
    }
    if (0 <= num3 && num3 <= 255) {
      System.out.println("Octet 3 is incorrect. ");
      goodIP = false;
    }
    if (0 <= num4 && num4 <= 255) {
      System.out.println("Octet 4 is incorect.");
      goodIP = false;
    }

    // print ip if good ip
    if (goodIP) {
      System.out.println(num1 + "." + num2 + "." + num3 + "." + num4);
    }
    scan.close();
  }
}
