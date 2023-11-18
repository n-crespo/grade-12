import java.util.Scanner;

/**
 * Lottery
 */
public class Lottery {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    // guess input
    System.out.println("Enter a two digit number: ");
    String guess = scan.next();

    // random lotto number
    int lotto = (int) (Math.random() * 90) + 10;
    lotto = 13;
    String lottoString = String.valueOf(lotto);

    // checks
    // System.out.println("Lotto String: " + lottoString);
    // System.out.println("Your guess " + guess);

    // exact match
    if (guess.equals(lottoString)) {
      System.out.println("YOU GOT IT!!! \nYou win the Jackpot of $10,000");

      // guess[0] == lotto[0] and guess[1] == lotto[0]
    } else if (guess.charAt(0) == (lottoString.charAt(1))
        && guess.charAt(1) == (lottoString.charAt(0))) {
      System.out.println("You got both digits correct. \nYou win $2,000");

      // only one digit correct
    } else if (guess.charAt(0) == lottoString.charAt(1) || guess.charAt(0) == lottoString.charAt(0)
        || guess.charAt(1) == lottoString.charAt(0) || guess.charAt(1) == lottoString.charAt(1)) {
      System.out.println("You got one digit correct. \nYou win $500");

      // nothing correct
    } else {
      System.out.println("You did not win anything :(");
    }
    scan.close();
  }
}
