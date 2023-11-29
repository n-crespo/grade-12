import java.util.Scanner;

/**
 * GuessingGame
 */
public class GuessingGame {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int secret = (int) (Math.random() * 100 + 1);
    int guess;
    int guesses = 0;

    while (true) {
      System.out.print("Enter your guess: ");
      guess = scan.nextInt();
      guesses++;

      if (guess > secret) {
        System.out.println("Too high");
      } else if (guess < secret) {
        System.out.println("Too low");
      } else if (guess == secret) {
        System.out.println("You got it!");
        System.out.println("It took you " + guesses + " guesses. ");
        break;
      }

    }
    scan.close();
  }
}
