import java.util.Scanner;

import javax.swing.text.DefaultStyledDocument.ElementSpec;

public class Hangman {

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    int randomNumber = (int) (Math.random() * 10) + 1;

    System.out.println("Welcome to Hangman! You have to guess the mystery word in 5 guesses or less.\n ");

    String mysteryWord;
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

    // make hidden word string same length as mystery Word
    String hiddenWord = "";
    for (int i = 0; i < mysteryWord.length(); i++) {
      hiddenWord += "*";
    }

    while (guesses > 0) {
      System.out.println("Here's what you have so far: " + hiddenWord);
      System.out.println("You have " + guesses + " guesses left. ");

      // print guessed letters
      if (guesses <= 4) {
        System.out.println("You have guessed: ");
        for (int i = 0; i < guessedLetters.length(); i++) {
          System.out.print(guessedLetters.charAt(i) + " ");
        }
      }

      // give me a char of input
      System.out.print("What letter would you like to guess? ");
      tempInput = scan.next();
      guess = tempInput.charAt(0);

      boolean guessInWord = false;
      while (guesses > 0) {
        while (guessInWord == false) {

          // loop over mystery word
          for (int i = 0; i < mysteryWord.length(); i++) {

            // if guess is the same as letter in mystery word...
            if (guess == mysteryWord.charAt(i)) {
              // update hidden word
              tempWord = hiddenWord;
              hiddenWord = "";
              // loop over hidden word
              for (int j = 0; j < tempWord.length(); j++) {
                if (j == i) {
                  hiddenWord += mysteryWord.charAt(i);
                } else if (tempWord.charAt(j) != '*') {
                  hiddenWord += tempWord.charAt(j);
                } else {
                  hiddenWord += "*";
                }

              }
              System.out.println("CORRECT!!!");
              guessInWord = true;
            }
          }
          guesses--;
          System.out.println("I'm sorry...");
        }
      }
    }
  }
}
