/**
 * SuperClass
 */
public class ChildClass extends ParentClass {
  public void method1() {
    System.out.println("Hello from the child class");
  }

  public static void main(String[] args) {
    ParentClass sb = new ChildClass();
    ChildClass sc = new ParentClass();
    sb.method1();
  }

}
