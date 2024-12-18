import java.util.ArrayList;
import java.util.Scanner;

/**
 * Wordle
 */
public class Wordle {
  public static String getInput(String message) {
    String input = "";
    Scanner scan = new Scanner(System.in);
    System.out.print(message);
    input = scan.next();
    while (input.length() != 5) {
      System.out.print("Please enter a FIVE letter word: ");
      input = scan.next();
    }
    scan.close();
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
    String word = "";

    // header + word to guess
    System.out.println("***Welcome to Wordle!***");
    // randon number from 0 to 20
    int randomNum = (int) (Math.random() * 20);
    // 20 five letter words in ArrayList
    ArrayList<String> wordList = new ArrayList<String>();
    wordList.add("apple");
    wordList.add("hello");
    wordList.add("water");
    wordList.add("pizza");
    wordList.add("hello");
    wordList.add("jazzy");
    wordList.add("quick");
    wordList.add("quack");
    wordList.add("candy");
    wordList.add("sugar");
    wordList.add("happy");
    wordList.add("party");
    wordList.add("crisp");
    wordList.add("scoop");
    wordList.add("scrum");
    wordList.add("piano");
    wordList.add("sloth");
    wordList.add("sweep");
    wordList.add("spicy");
    wordList.add("spark");

    System.out.print("Do you want (1) a random word, or (2) your own? (type 1 or 2): ");
    Scanner scan = new Scanner(System.in);
    int randomOrOwn = scan.nextInt();

    while (randomOrOwn != 1 && randomOrOwn != 2) {
      System.out.print("Enter 1 or 2: ");
      randomOrOwn = scan.nextInt();
    }
    if (randomOrOwn == 1) {
      word = wordList.get(randomNum);
    } else if (randomOrOwn == 2) {
      word = getInput("Have someone enter in a five letter word for you to guess: ");
    }
    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

    System.out.println(
        "How to Play: \n============\n*: letter is in correct position\n@: letter is not in the correct position, but is in the word\nx: letter is not in the word");
    System.out.println("============\n");
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
      System.out.println("The word was " + word);
    }
    scan.close();
  }

}
