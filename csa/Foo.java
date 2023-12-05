public class Foo {
  public static void main(String[] args) {
    int count = 0;
    for (int x = 0; x < 4; x++) {
      for (int y = x; y < 4; y++) {
        count++;

      }
    }
    System.out.println(count);
  }
}
