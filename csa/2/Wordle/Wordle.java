import java.util.Scanner;

/**
 * Wordle
 */
public class Wordle {
  public static String getInput(String message) {
    String input = "";
    @SuppressWarnings("resource") // FIXME: REMOVE THIS LATER
    Scanner scan = new Scanner(System.in);
    System.out.print(message);
    input = scan.next();
    System.out.println("This is working 1");
    while (input.length() != 5) {
      System.out.println("This is working 2");
      System.out.print("Please enter a FIVE letter word: ");
      input = scan.next();
    }
    return input.toLowerCase();
  }

  public static boolean charInCorrectPosition(String word, char guessedLetter, int pos) {
    if (word.charAt(pos) == guessedLetter) {
      return true;
    }
    return false;
  }

  public static boolean charInGuess(String word, char gussedLetter) {
    if (word.contains(gussedLetter + "")) {
      return true;
    }
    return false;
  }

  // if letter has been used, replace letter with # in used words list
  public static void addToUsedWords(String guess, String usedLetters[]) {
    for (int i = 0; i < usedLetters.length; i++) {
      if (guess.indexOf(usedLetters[i]) >= 0) {
        usedLetters[i] = "#";
      }
    }
  }

  public static void printScreen(char allGuesses[][], String usedLetters[], int currentRow) {
    for (int i = 0; i < allGuesses.length; i++) {
      System.out.print("|");
      for (int j = 0; j < allGuesses[i].length; j++) {
        if (i < currentRow) {
          System.out.print(allGuesses[i][j]);
        } else {
          System.out.print(" ");
        }
      }
      System.out.println("|");
    }
    for (int i = 0; i < usedLetters.length; i++) {
      System.out.print(usedLetters[i] + " ");
    }
    System.out.println("\n");
  }

  public static void main(String[] args) {
    // array of the alphabet
    String usedLetters[] = new String[26];
    for (int i = 0; i < usedLetters.length; i++) {
      usedLetters[i] = ("" + ((char) (65 + i))).toLowerCase(); // concatenate empty string to convert char to str
    }
    int lettersCorrect = 0;
    int numAttempts = 0;
    char allGuesses[][] = new char[12][5];
    int currentRow = 0;

    // header + word to guess
    System.out.println("***Welcome to Wordle!***");
    String word = getInput("Have someone enter in a five letter word for you to guess: ");
    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

    while (lettersCorrect < 5 && numAttempts < 6) {
      String guess = getInput("Enter a 5 letter word: ");
      lettersCorrect = 0;
      numAttempts++;

      for (int i = 0; i < guess.length(); i++) {
        allGuesses[currentRow][i] = guess.charAt(i);
        if (charInCorrectPosition(word, guess.charAt(i), i)) {
          allGuesses[currentRow + 1][i] = '*';
          lettersCorrect++;
        } else if (charInGuess(word, guess.charAt(i))) {
          allGuesses[currentRow + 1][i] = '@';
        } else {
          allGuesses[currentRow + 1][i] = 'x';
        }
      }
      currentRow += 2;

      addToUsedWords(guess, usedLetters);
      printScreen(allGuesses, usedLetters, currentRow);
    }

    // end screen
    if (lettersCorrect == 5) {
      System.out.println("You won!");
      System.out.println("You used " + numAttempts + " guesses.");
    } else if (numAttempts == 6) {
      System.out.println("You ran out of guesses!");
    }
  }

}
