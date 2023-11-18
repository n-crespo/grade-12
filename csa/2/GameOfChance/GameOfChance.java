import java.util.Scanner;

public class GameOfChance {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.println("***WELCOME***");
    System.out.println("Let's see if you won...");

    System.out.println("What is your guess on the dice roll? (1-6) ");
    int diceGuess = scan.nextInt();

    System.out.println("What is your guess on the coin flip, Heads (1) or Tails (2)? ");
    int coinGuess = scan.nextInt();

    System.out.println("What is your guess on the spinner, [r]ed, [g]reen, [b]lue, or [y]ellow? ");
    String spinnerGuess = scan.next();

    // System.out.println("you guessed: " + diceGuess + "|" + coinGuess + "|" +
    // spinnerGuess);

    int diceReal = (int) (Math.random() * 6) + 1;
    System.out.println("\nYou rolled a " + diceReal);

    int coinToss = (int) (Math.random() * 2);
    int coinResult = 0;
    if (coinToss == 1) {
      System.out.println("You flipped heads");
      coinResult = 1;
    } else if (coinToss == 0) {
      System.out.println("You flipped tails");
      coinResult = 2;
    } else {
      System.out.println("Something bad happened...");
    }

    String spinnerResult = "";
    int spinnerSpin = (int) (Math.random() * 4) + 1;
    if (spinnerSpin == 1) {
      System.out.println("You spun red");
      spinnerResult = "r";
    } else if (spinnerSpin == 2) {
      System.out.println("You spun green");
      spinnerResult = "g";
    } else if (spinnerSpin == 3) {
      System.out.println("You spun blue");
      spinnerResult = "b";
    } else if (spinnerSpin == 4) {
      System.out.println("You spun yellow");
      spinnerResult = "y";
    }

    int total = 0;
    System.out.println();
    if (coinGuess == coinResult) {
      System.out.println("You got the coin toss correct.");
      total++;
    }
    if (spinnerGuess.equals(spinnerResult)) {
      System.out.println("You got the spinner color correct");
      total++;

    }
    if (diceGuess == diceReal) {
      System.out.println("You got the dice roll correct");
      total++;
    }
    // System.out.println("You got " + total + " guess(es) correct. ");
    if (total == 3) {
      System.out.println("Congrats! You got all guesses correct.");
    } else if (total == 0) {
      System.out.println("Sorry, you somehow managed to get NOTHING correct.");
    } else if (total == 1 || total == 2) {
      System.out.println("Congrats... I guess. You can do better!");

    }
    // System.out.println("you guessed: " + diceGuess + "|" + coinGuess + "|" +
    // spinnerGuess);
    scan.close();
  }
}
