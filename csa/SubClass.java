public class SubClass extends SuperClass {
  public void A() {
    System.out.println("sub A");
  }

  public void C() {
    super.A();
  }

  // -----------------------------------------------------------------------
  public static void main(String[] args) {
    SuperClass thing = new SubClass();
    thing.C();
  }
}
