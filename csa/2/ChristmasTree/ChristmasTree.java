import java.util.Scanner;

/**
 * ChristmasTree
 */
public class ChristmasTree {

  public static void main(String[] args) {
    System.out.print("How many Christmas Trees would you like to print? ");
    Scanner scan = new Scanner(System.in);
    int num = scan.nextInt();
    for (int i = 0; i < num; i++) {
      System.out.println("\t     *     ");
      System.out.println("\t    ***    ");
      System.out.println("\t   *****   ");
      System.out.println("\t  *******  ");
      System.out.println("\t    ***    ");
      System.out.println("\t   *****   ");
      System.out.println("\t  *******  ");
      System.out.println("\t ********* ");
      System.out.println("\t   *****   ");
      System.out.println("\t  *******  ");
      System.out.println("\t ********* ");
      System.out.println("\t***********");
      System.out.println("\t     *     ");
      System.out.println("\t     *     ");
      System.out.println("\t  *******  ");
      System.out.println();
    }

    scan.close();

  }

}
