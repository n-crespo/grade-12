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

  // if letter has been used, replace letter with # in used words list
  public static void addToUsedWords(String word, char usedLetters[]) {
    for (int j = 0; j < usedLetters.length; j++) {
      if (word.contains(usedLetters[j] + "")) {
        usedLetters[j] = '#';
      }
    }
  }

  public static boolean charInGuess(String word, String guess) {
    for (int i = 0; i < word.length(); i++) {
      if (word.contains(guess.charAt(i) + "")) {
        return true;
      }
    }
    return false;
  }

  public static void printScreen(char guesses[][], char usedLetters[]) {
    for (int i = 0; i < guesses.length; i += 2) {
      for (int j = 0; j < guesses[i].length; j++) {
        System.out.println("| " + guesses[i][j] + " | ");
      }
    }
    for (int i = 0; i < usedLetters.length; i++) {
      System.out.print(usedLetters[i] + " ");
    }
  }

  public static void main(String[] args) {
    // array of the alphabet
    char usedLetters[] = new char[26];
    for (int i = 0; i < usedLetters.length; i++) {
      usedLetters[i] = (char) (65 + i);
    }
    int lettersCorrect = 0;
    int numAttempts = 0;
    char guesses[][] = new char[12][5];
    int currentRow = 0;
    Scanner scanner = new Scanner(System.in);

    // header + word to guess
    System.out.println("***Welcome to Wordle!***");
    System.out.println("Have someone enter in a five letter word for you to guess, all caps:");
    String word = scanner.nextLine();
    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

    while (lettersCorrect < 5 && numAttempts < 6) {
      System.out.println("Enter a 5 letter word in all caps: ");
      String guess = scanner.nextLine();
      lettersCorrect = 0;
      numAttempts++;

      for (int i = 0; i < guess.length(); i++) {
        guesses[currentRow][i] = guess.charAt(i);
        if (charInCorrectPosition(word, guess)) {
          guesses[currentRow + 1][i] = '*';
          lettersCorrect++;
        } else if (charInGuess(word, guess)) {
          guesses[currentRow + 1][i] = '@';
        } else {
          guesses[currentRow + 1][i] = 'x';
        }
      }
      currentRow += 2;

      addToUsedWords(guess, usedLetters);
      printScreen(guesses, usedLetters);
    }

    // end screen
    if (lettersCorrect == 5) {
      System.out.println("You won!");
      System.out.println("You used " + numAttempts + " guesses.");
    } else if (numAttempts == 6) {
      System.out.println("You ran out of guesses!");

    }
    scanner.close();
  }
}
