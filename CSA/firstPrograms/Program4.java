import java.util.Scanner;

public class Program4 {
  public static void main(String[] args) {
    System.out.println("Enter numnber of seconds: ");
    Scanner scan = new Scanner(System.in);
    int input = scan.nextInt();
    int hours = (input/3600);
    System.out.println("Hours: " + hours);
    int minutes = (input - (3600*hours))/60;
    System.out.println("Minutes: " + minutes);
    int seconds = (input-(3600*hours))%60;
    System.out.println("Seconds: " + seconds);
  }
}
