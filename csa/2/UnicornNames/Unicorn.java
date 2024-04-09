import java.util.Scanner;

public class Unicorn {
  public static void main(String[] args) {
    System.out.println("Enter a word: ");
    Scanner scan = new Scanner(System.in);
    String word = scan.nextLine();
    scan.close();

    for (int i = 0; i < word.length(); i++) {
      if (word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o'
          || word.charAt(i) == 'u') {
        System.out.print("inkle");
      } else {
        System.out.print(word.charAt(i));
      }
    }
  }
}
