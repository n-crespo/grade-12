public class Foo {
  public static String reverse(String str) {
    String temp = "";
    for (int i = str.length() - 1; i > 0; i--) {
      temp += str.substring(i - 1, i);
    }
    return temp;
  }

  public static void main(String[] args) {
    System.out.println(reverse("apple"));

  }
}
