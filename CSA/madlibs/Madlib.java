import java.util.Scanner;

public class Madlib {

  public static void main(String[] args) {
    String adverby;
    String adjective;
    String studentName;
    String teacherName;
    String objectName;
    String jobTitle;
    String newInput;

    // getting the input
    System.out.println("Welcome to Mad Libs!");
    System.out.println("Enter the following, seperated by a comma and a space:");
    System.out.println();
    System.out.println(
        "{an adverb ending with -ly}, {an adjective}, {a student name}, {a teacher name}, {an object name}, {a job title}");
    System.out.println();
    // scanner
    Scanner scan = new Scanner(System.in);
    String originalInput = scan.nextLine();

    // get first word
    adverby = originalInput.substring(0, originalInput.indexOf(','));
    // remove first word from 6-word input
    newInput = originalInput.substring(originalInput.indexOf(',') + 2);

    // get second word
    adjective = newInput.substring(0, newInput.indexOf(','));
    // remove second word from 5-word input
    newInput = newInput.substring(newInput.indexOf(',') + 2);

    // get second word
    studentName = newInput.substring(0, newInput.indexOf(','));
    // remove second word from 5-word input
    newInput = newInput.substring(newInput.indexOf(',') + 2);

    // get second word
    teacherName = newInput.substring(0, newInput.indexOf(','));
    // remove second word from 5-word input
    newInput = newInput.substring(newInput.indexOf(',') + 2);

    // get second word
    objectName = newInput.substring(0, newInput.indexOf(','));
    // remove second word from 5-word input
    newInput = newInput.substring(newInput.indexOf(',') + 2);

    // get second word
    jobTitle = newInput.substring(0);

    scan.close();

    // STORY
    System.out.println("");
    System.out.println("~~~~~~~ THE STORY ~~~~~~~");
    System.out.print("It was a " + adjective + " morning and " + studentName + " walked " + adverby
        + " into AP Computer Science A LATE, as usual. ");
    System.out.println("He walked up to " + teacherName
        + " and DEMANDEDED to take the test next week, rather than today. " + teacherName + " refused, and "
        + studentName + " exploded into a fit of rage. " + "Thankfully, " + teacherName + " pulled out a " + objectName
        +
        " and neutralized the threat. Then " + teacherName + " got promoted to " +
        jobTitle + " and never had to deal with " + studentName + " again!.");
    System.out.println();
    System.out.println("~~~~~~~ THE END ~~~~~~~");

  }
}
