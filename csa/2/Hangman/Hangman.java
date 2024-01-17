import java.util.Scanner;

public class Hangman {

  public static void main(String[] args) {
    // welcome message
    System.out.println("Welcome to Hangman! You have to guess the mystery word in 5 guesses or less.\n ");

    // get mystery word
    String mysteryWord;
    int randomNumber = (int) (Math.random() * 10) + 1;
    // get random number
    if (randomNumber == 0) {
      mysteryWord = "elephant";
    } else if (randomNumber == 2) {
      mysteryWord = "symphony";
    } else if (randomNumber == 3) {
      mysteryWord = "computer";
    } else if (randomNumber == 4) {
      mysteryWord = "adventure";
    } else if (randomNumber == 5) {
      mysteryWord = "butterfly";
    } else if (randomNumber == 6) {
      mysteryWord = "umbrella";
    } else if (randomNumber == 7) {
      mysteryWord = "chocolate";
    } else if (randomNumber == 8) {
      mysteryWord = "sunshine";
    } else if (randomNumber == 9) {
      mysteryWord = "plantain";
    } else {
      mysteryWord = "universe";
    }

    int guesses = 5;
    String tempInput;
    char guess;
    String guessedLetters = "";
    String tempWord;
    boolean guessInWord = false;
    Scanner scan = new Scanner(System.in);
    boolean wordGuessed = false;
    int starCount;

    // make hidden word string same length as mystery Word
    String hiddenWord = "";
    for (int i = 0; i < mysteryWord.length(); i++) {
      hiddenWord += "*";
    }

    // continue until all guesses are done or word is guessed
    while (guesses > 0 && wordGuessed == false) {
      // print current progress
      System.out.println("==========================================");
      System.out.println(guesses + " guesses remain.");
      System.out.println("Here's what you have so far: " + hiddenWord);
      if (guesses <= 4) {
        System.out.print("You've guessed: ");
        for (int i = 0; i < guessedLetters.length(); i++) {
          System.out.print(guessedLetters.charAt(i) + " ");
        }
        System.out.println();
      }

      // give me a char of input
      System.out.print("\nWhat letter would you like to guess? ");
      tempInput = scan.next();
      tempInput = tempInput.toLowerCase();
      guess = tempInput.charAt(0);
      guessedLetters += guess;

      guessInWord = false;
      // check if guess is in word
      for (int i = 0; i < mysteryWord.length(); i++) {

        // guess IS in word...
        if (guess == mysteryWord.charAt(i)) {
          guessInWord = true;

          // update hidden word
          tempWord = hiddenWord;
          hiddenWord = "";
          starCount = 0;
          for (int j = 0; j < tempWord.length(); j++) {
            if (j == i) {
              hiddenWord += mysteryWord.charAt(i);
            } else if (tempWord.charAt(j) != '*') {
              hiddenWord += tempWord.charAt(j);
            } else {
              // un-guessed letters still in word
              starCount += 1;
              hiddenWord += "*";
            }
          }
          if (starCount == 0) {
            wordGuessed = true;
          }
        }
      }
      if (!guessInWord) {
        System.out.print("                                      That isn't in the word.\n");
        guesses--;
      } else if (guessInWord) {
        System.out.print("                                      CORRECT!!!\n");
      }
    }
    if (wordGuessed == true) {
      System.out.println("==================YOU WON!!===============");
    } else {
      System.out.println("==================GAME OVER===============");
      System.out.println("The word was: " + mysteryWord);
    }
    scan.close();
  }
}
