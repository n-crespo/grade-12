import java.util.Scanner;

/**
 * RockPaperScissors
 */
public class RockPaperScissors {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.println("Enter Rock (0), Paper (1), Scissors (2): ");
    int choice = scan.nextInt();
    int computer = (int) (Math.random() * 4);

    if (choice == 0) {
      System.out.print("You played rock. ");
    } else if (choice == 1) {
      System.out.print("You played paper. ");
    } else if (choice == 2) {
      System.out.print("You played scissors. ");
    }

    if (computer == 0) { // rock
      System.out.println("The computer played rock. ");
    } else if (computer == 1) { // paper
      System.out.println("The computer played paper. ");
    } else if (computer == 2) { // scissors
      System.out.println("The computer played scissors. ");
    }

    if (choice == computer) {
      System.out.println("It is a draw!");
    } else if (choice == 0) { // you chose rock
      if (computer == 1) {
        System.out.println("Paper beats rock, you lose!");
      } else if (computer == 2) {
        System.out.println("Rock beats scissors, you win!");
      }
    } else if (choice == 1) { // you chose paper
      if (computer == 0) { // rock
        System.out.println("Paper beats rock, you win!");
      } else if (computer == 2) { // scissors
        System.out.println("Scissors beats paper, you lose!");
      }
    } else if (choice == 2) { // you chose scissors
      if (computer == 0) {
        System.out.println("Rock beats scissors, you lose!");
      } else if (computer == 1) {
        System.out.println("Scissors beats paper, you won! ");
      }
    } else {
      System.out.println("Something went wrong...");
    }
    scan.close();
  }
}
