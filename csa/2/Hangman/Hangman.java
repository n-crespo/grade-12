public class Hangman {

  public static void main(String[] args) {

    System.out.println("Welcome to Hangman! You have to guess the mystery word");
    System.out.println("in 5 guesses or less. ");
    System.out.println("Here's what you have so far: ");

    int randomNumber = (int) (Math.random() * 10) + 1;

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

    String hiddenWord = "*****";

    while (true) {
      System.out.println("Here's what you have so far: " + hiddenWord);

    }

  }
}
