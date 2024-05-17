import java.util.Scanner;

/**
 * Wordle
 */
public class Wordle {
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
  public static void addToUsedWords(String guess, char usedLetters[]) {
    for (int j = 0; j < usedLetters.length; j++) {
      if (guess.contains(usedLetters[j] + "")) {
        usedLetters[j] = '#';
      }
    }
  }

  public static void printScreen(char allGuesses[][], char usedLetters[], int currentRow) {
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
    char usedLetters[] = new char[26];
    for (int i = 0; i < usedLetters.length; i++) {
      usedLetters[i] = (char) (65 + i);
    }
    int lettersCorrect = 0;
    int numAttempts = 0;
    char allGuesses[][] = new char[12][5];
    int currentRow = 0;
    Scanner scanner = new Scanner(System.in);

    // header + word to guess
    System.out.println("***Welcome to Wordle!***");
    System.out.println("Have someone enter in a five letter word for you to guess, all caps:");
    String word = scanner.nextLine();
    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

    while (lettersCorrect < 5 && numAttempts < 6) {
      System.out.print("Enter a 5 letter word in all caps: ");
      String guess = scanner.next();
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
    scanner.close();
  }
}
