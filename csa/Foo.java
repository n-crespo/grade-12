public class Foo {
  public static void main(String[] args) {
    String s = "It seems impossible until it's not.";
    String target = "o";

    int index = s.indexOf(target);

    while (index >= 0) {
      System.out.println("Location: " + index);
      s = s.substring(0, index) + s.substring(index + 1);
      index = s.indexOf(target);
    }
    System.out.println(s);
  }
}
