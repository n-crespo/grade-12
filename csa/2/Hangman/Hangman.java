import java.util.Scanner;

import javax.swing.text.DefaultStyledDocument.ElementSpec;

public class Hangman {

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    int randomNumber = (int) (Math.random() * 10) + 1;

    System.out.println("Welcome to Hangman! You have to guess the mystery word");
    System.out.println("in 5 guesses or less. ");

    String mysteryWord;
    if (randomNumber == 1) {
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

    String guessString;
    char guessChar;

    String guessedLetters = "";
    String tempWord;

    // make hidden word string
    String hiddenWord = "";
    for (int i = 0; i < mysteryWord.length(); i++) {
      hiddenWord += "*";
    }

    while (guesses > 0) {
      System.out.println("Here's what you have so far: " + hiddenWord);
      System.out.println("You have " + guesses + " guesses left. ");
      System.out.println("Here are the letters you have guessed so far: ");

      // print guessed letters
      for (int i = 0; i < guessedLetters.length(); i++) {
        System.out.print(guessedLetters.charAt(i) + " ");
      }
      System.out.print("What letter would you like to guess next? ");
      guessString = scan.next();

      // give me a char
      guessChar = guessString.charAt(0);

      boolean guessedCorrect = false;
      while (guessedCorrect == false) {
        {
          for (int i = 0; i < mysteryWord.length(); i++) {
            // if guess is correct
            if (guessChar == mysteryWord.charAt(i)) {
              // update hidden word
              tempWord = hiddenWord;
              hiddenWord = "";
              for (int j = 0; j < hiddenWord.length(); j++) {
                if (j == i) {
                  hiddenWord += mysteryWord.charAt(i);
                } else if (tempWord.charAt(j) != '*') {
                  hiddenWord += tempWord.charAt(j);
                } else {
                  hiddenWord += "*";
                }

                System.out.println("CORRECT!!!");
                guessedCorrect = true;
              }
            }
          }
        }
        guesses -= 1;
        System.out.println("I'm sorry...");
      }
    }
  }
}
