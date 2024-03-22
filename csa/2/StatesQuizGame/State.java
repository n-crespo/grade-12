import java.util.ArrayList;
import java.util.Scanner;

public class State {
  // constructor
  private String name;
  private String abbreviation;
  private int population;
  private int rank;

  public State(String n, String a, int p, int r) {
    name = n;
    abbreviation = a;
    population = p;
    rank = r;
  }

  public String getName() {
    return name;
  }

  public String getAbbreviation() {
    return abbreviation;
  }

  public int getPopulation() {
    return population;
  }

  public int getRank() {
    return rank;
  }

  public static void main(String[] args) {
    ArrayList<State> states = new ArrayList<State>();
    states.add(new State("Alabama", "AL", 4949697, 30));
    states.add(new State("Alaska", "AK", 720763, 1));
    states.add(new State("Arizona", "AZ", 7640796, 6));
    states.add(new State("Arkansas", "AR", 3042017, 29));
    states.add(new State("California", "CA", 39664128, 3));
    states.add(new State("Colorado", "CO", 5961083, 8));
    states.add(new State("Connecticut", "CT", 3546588, 48));
    states.add(new State("Delaware", "DE", 998619, 49));
    states.add(new State("Florida", "FL", 22177997, 22));
    states.add(new State("Georgia", "GA", 10936299, 24));
    states.add(new State("Hawaii", "HI", 1401709, 43));
    states.add(new State("Idaho", "ID", 1896652, 14));
    states.add(new State("Illinois", "IL", 12518071, 25));
    states.add(new State("Indiana", "IN", 6842385, 38));
    states.add(new State("Iowa", "IA", 3174426, 26));
    states.add(new State("Kansas", "KS", 2919179, 15));
    states.add(new State("Kentucky", "KY", 4487233, 37));
    states.add(new State("Louisiana", "LA", 4616106, 31));
    states.add(new State("Maine", "ME", 1359677, 39));
    states.add(new State("Maryland", "MD", 6075314, 42));
    states.add(new State("Massachusetts", "MA", 6922107, 44));
    states.add(new State("Michigan", "MI", 9995212, 11));
    states.add(new State("Minnesota", "MN", 5739781, 12));
    states.add(new State("Mississippi", "MS", 2961536, 32));
    states.add(new State("Missouri", "MO", 6184843, 21));
    states.add(new State("Montana", "MT", 1093117, 4));
    states.add(new State("Nebraska", "NE", 1960790, 16));
    states.add(new State("Nevada", "NV", 3238601, 7));
    states.add(new State("New Hampshire", "NH", 1378449, 46));
    states.add(new State("New Jersey", "NJ", 8870685, 47));
    states.add(new State("New Mexico", "NM", 2109093, 5));
    states.add(new State("New York", "NY", 19223191, 27));
    states.add(new State("North Carolina", "NC", 10807491, 28));
    states.add(new State("North Dakota", "ND", 774008, 19));
    states.add(new State("Ohio", "OH", 11727377, 34));
    states.add(new State("Oklahoma", "OK", 4007179, 20));
    states.add(new State("Oregon", "OR", 4325290, 9));
    states.add(new State("Pennsylvania", "PA", 12805190, 33));
    states.add(new State("Rhode Island", "RI", 1062583, 50));
    states.add(new State("South Carolina", "SC", 5342388, 40));
    states.add(new State("South Dakota", "SD", 902542, 17));
    states.add(new State("Tennessee", "TN", 7001803, 36));
    states.add(new State("Texas", "TX", 30097526, 2));
    states.add(new State("Utah", "UT", 3363182, 13));
    states.add(new State("Vermont", "VT", 622882, 45));
    states.add(new State("Virginia", "VA", 8638218, 35));
    states.add(new State("Washington", "WA", 7887965, 18));
    states.add(new State("West Virginia", "WV", 1755715, 41));
    states.add(new State("Wisconsin", "WI", 5867518, 23));
    states.add(new State("Wyoming", "WY", 582233, 10));

    ArrayList<String> letters = new ArrayList<String>();
    letters.add("a");
    letters.add("b");
    letters.add("c");
    letters.add("d");

    // get a random number
    System.out.println("Welcome to our states quiz game! ");
    System.out.println("You will be given 5 multiple choice questions about the states. ");
    System.out.println("Choose the correct answer and get a point!");
    System.out.println();

    int numCorrect = 0;

    // Q1 --------------------------------------------------------------------------

    int correctStateIndex = (int) (Math.random() * 50);
    System.out
        .println(
            "\nQ1: Which of the following states has an abbreviation of "
                + states.get(correctStateIndex).getAbbreviation()
                + "? ");

    ArrayList<Integer> usedStateIndices = new ArrayList<Integer>();
    usedStateIndices.add(correctStateIndex);
    int secretIndex = (int) (Math.random() * 4);
    for (int i = 0; i < 4; i++) {
      // if the correct answer is being displayed, show it
      if (i == secretIndex) {
        System.out.println(letters.get(i) + ". " + states.get(correctStateIndex).getName());
      } else { // generate random answer choice otherwise
        int nextAnswerChoice = (int) (Math.random() * 50);
        while (listContainsElement(usedStateIndices, nextAnswerChoice)) {
          nextAnswerChoice = (int) (Math.random() * 50);
        }
        usedStateIndices.add(nextAnswerChoice);
        System.out.println(letters.get(i) + ". " + states.get(nextAnswerChoice).getName());
      }
    }

    Scanner scan = new Scanner(System.in);
    String answer = scan.nextLine();

    System.out.println();
    if (answer.equals(letters.get(secretIndex))) {
      System.out.println("Yes! You got the first question correct! ");
      numCorrect++;
    } else {
      System.out.println("No! Sorry, the correct answer was " + letters.get(secretIndex) + ". ");
    }

    // Q2 ------------------------------------------------------------------------

    System.out.println("\nQ2: Of the following states, which has the largest population?");

    usedStateIndices = new ArrayList<Integer>();
    // generate answer choices first
    for (int i = 0; i < 4; i++) {
      int nextAnswerChoice = (int) (Math.random() * 50);
      while (listContainsElement(usedStateIndices, nextAnswerChoice)) {
        nextAnswerChoice = (int) (Math.random() * 50);
      }
      usedStateIndices.add(nextAnswerChoice);
      System.out.println(letters.get(i) + ". " + states.get(nextAnswerChoice).getName());
    }

    // set max state (correct answer) to first index by default
    int correctIndex = usedStateIndices.get(0);
    int optionIndex = 0;
    for (int i : usedStateIndices) {
      if (states.get(i).population > states.get(correctIndex).population) {
        correctIndex = i;
        optionIndex = usedStateIndices.indexOf(i);
      }
    }

    secretIndex = correctIndex;

    String answer2 = scan.nextLine();
    System.out.println();
    // System.out.println("Correct answer is: " + letters.get(optionIndex));
    if (answer2.equals(letters.get(optionIndex))) {
      System.out.println("Yes! You got the second question correct! ");
      numCorrect++;
    } else {
      System.out.println("No! Sorry, the correct answer was " + letters.get(optionIndex) + ". ");
    }

    // Q3 -----------------------------------------------------------------------

    System.out.println("\nQ3: Of the following 4 states, which has the smallest population?");

    usedStateIndices = new ArrayList<Integer>();
    for (int i = 0; i < 4; i++) {
      int nextAnswerChoice = (int) (Math.random() * 50);
      while (listContainsElement(usedStateIndices, nextAnswerChoice)) {
        nextAnswerChoice = (int) (Math.random() * 50);
      }
      usedStateIndices.add(nextAnswerChoice);
      System.out.println(letters.get(i) + ". " + states.get(nextAnswerChoice).getName());
    }

    correctIndex = usedStateIndices.get(0);
    optionIndex = 0;
    for (int choice : usedStateIndices) {
      if (states.get(choice).population < states.get(correctIndex).population) {
        correctIndex = choice;
        optionIndex = usedStateIndices.indexOf(choice);
      }
    }

    secretIndex = correctIndex;

    String answer3 = scan.nextLine();
    System.out.println();
    if (answer3.equals(letters.get(optionIndex))) {
      System.out.println("Yes! You got the third question correct! ");
      numCorrect++;
    } else {
      System.out.println("No! Sorry, the correct answer was " + letters.get(optionIndex) + ". ");
    }

    // Q4 ------------------------------------------------------------------------

    System.out.println("\nQ4: Of the following states, which is the largest in land size?");

    usedStateIndices = new ArrayList<Integer>();
    for (int i = 0; i < 4; i++) {
      int nextAnswerChoice = (int) (Math.random() * 50);
      while (listContainsElement(usedStateIndices, nextAnswerChoice)) {
        nextAnswerChoice = (int) (Math.random() * 50);
      }
      usedStateIndices.add(nextAnswerChoice);
      System.out.println(letters.get(i) + ". " + states.get(nextAnswerChoice).getName());
    }

    correctIndex = usedStateIndices.get(0);
    optionIndex = 0;
    for (int i : usedStateIndices) {
      if (states.get(i).rank > states.get(correctIndex).rank) {
        correctIndex = i;
        optionIndex = usedStateIndices.indexOf(i);
      }
    }

    secretIndex = correctIndex;

    String answer4 = scan.nextLine();
    System.out.println();
    if (answer4.equals(letters.get(optionIndex))) {
      System.out.println("Yes! You got the second question correct! ");
      numCorrect++;
    } else {
      System.out.println("No! Sorry, the correct answer was " + letters.get(optionIndex) + ". ");
    }

    // Q5 -------------------------------------------------------------------------

    System.out.println("\nQ5: Of the following 4 states, which state is the smallest in land size?");

    usedStateIndices = new ArrayList<Integer>();
    for (int i = 0; i < 4; i++) {
      int nextAnswerChoice = (int) (Math.random() * 50);
      while (listContainsElement(usedStateIndices, nextAnswerChoice)) {
        nextAnswerChoice = (int) (Math.random() * 50);
      }
      usedStateIndices.add(nextAnswerChoice);
      System.out.println(letters.get(i) + ". " + states.get(nextAnswerChoice).getName());
    }

    correctIndex = usedStateIndices.get(0);
    optionIndex = 0;
    for (int i : usedStateIndices) {
      if (states.get(i).rank < states.get(correctIndex).rank) {
        correctIndex = i;
        optionIndex = usedStateIndices.indexOf(i);
      }
    }

    secretIndex = correctIndex;

    String answer5 = scan.nextLine();
    System.out.println();
    if (answer5.equals(letters.get(optionIndex))) {
      System.out.println("Yes! You got the fifth question correct! ");
      numCorrect++;
    } else {
      System.out.println("No! Sorry, the correct answer was " + letters.get(optionIndex) + ". ");
    }

    // END SCORE ---------------------------------------------------------------

    System.out.println("\nThank you for playing!\nYour score is: " + numCorrect + "/5");
    scan.close();
  }

  public static boolean listContainsElement(ArrayList<Integer> list, int element) {
    for (int e : list) {
      if (element == e) {
        return true;
      }
    }
    return false;
  }
}
