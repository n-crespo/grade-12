/**
 * Foo
 */
public class Foo {
  public static void main(String[] args) {

    char usedLetters[] = new char[26];
    for (int i = 0; i < usedLetters.length; i++) {
      usedLetters[i] = (char) (65 + i);
    }

    for (int i = 0; i < usedLetters.length; i++) {
      System.out.println(usedLetters[i]);
    }
  }
}
