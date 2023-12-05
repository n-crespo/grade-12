import java.util.Scanner;

public class SlotMachine {
  public static void main(String[] args) {
    int wallet = 120;
    Scanner scan = new Scanner(System.in);
    String answer = "p";
    while (answer == "p") {
      wallet -= 20;
      int matches = 0;
      int num1 = (int) (Math.random() * 10);
      System.out.print("\n[" + num1 + "] ");
      int num2 = (int) (Math.random() * 10);
      System.out.print("[" + num2 + "] ");
      int num3 = (int) (Math.random() * 10);
      System.out.println("[" + num3 + "] \n");

      if (num1 == num2 && num2 == num3) {
        matches = 2;
      } else if (num1 == num2 || num2 == num3 || num3 == num1) {
        matches = 1;
      } else {
        matches = 0;
      }

      if (matches == 0) {
        System.out.println("You got 0 matches.");
      } else if (matches == 1) {
        System.out.println("You matched 2 numbers!");
        wallet += 100;
      } else if (matches == 2) {
        System.out.println("You matched all 3 numbers!");
        wallet += 500;

      }
      System.out.println("Balance = " + wallet);
      System.out.print("Type p to play again (for $20), or q to quit: ");
      answer = scan.nextLine();
      if (answer == "p") {
        wallet -= 20;
      } else if (answer == "q") {
        break;
      }
    }
    scan.close();

  }
}
