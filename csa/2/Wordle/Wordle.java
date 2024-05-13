import java.util.ArrayList;
import java.util.Scanner;

/**
 * Wordle
 */
public class Wordle {
  public static boolean charInCorrectPosition(String word, String guess) {
    for (int i = 0; i < word.length(); i++) {
      if (guess.charAt(i) == word.charAt(i)) {
        return true;
      }
    }
    return false;
  }

  public static boolean charInWord(String word, String guess) {
    for (int i = 0; i < word.length(); i++) {
      if (word.contains(guess.charAt(i) + "")) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("***Welcome to Wordle!***");
    System.out.println("Have someone enter in a five letter word for you to guess, all caps:");
    String word = scanner.nextLine();
    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

    // clear the screen
    // System.out.print("\033[H\033[2J");
    // System.out.flush();

    System.out.println("Enter a 5 letter word in all caps: ");
    String guess = scanner.nextLine();
    ArrayList<Character> guesses = new ArrayList<Character>();
    for (int i = 0; i < guess.length(); i++) {
      guesses.add(guess.charAt(i));
      if (guess.charAt(i) == word.charAt(i)) {
        System.out.println("*");
      }

      boolean done = false;
      while (!done) {
        for (int j = 0; j < word.length(); j++) {
          if (guess.charAt(i) == word.charAt(j) && !done) {
            System.out.println("@");
            done = true;
          }
        }
      }
    }
    scanner.close();
  }
}
