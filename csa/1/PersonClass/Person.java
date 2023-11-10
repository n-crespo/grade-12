public class Person {

  private String name;
  private int age;

  public Person(String n, int a) {
    name = n;
    age = a;
  }

  public Person() {
    name = "unknown";
    age = 1;
  }

  public void printPerson() {
    System.out.println("My name is " + name + " and I am " + age + " years old.");
  }

  public void growOlder() {
    age += 1;
  }

  public static void main(String[] args) {
    Person nicolas = new Person();
    nicolas.growOlder();
    nicolas.printPerson();
  }

}
