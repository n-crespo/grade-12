/**
 * Animal
 */
public class Animal {
  public void eat() {
    System.out.println("Eating");
  }

  public Animal() {
    System.out.println("Animal constructor");
  }

  public Animal(int n) {
    System.out.println("Animal constructor with a number");
  }

  public static void main(String[] args) {
    Lion lion = new Lion(5);
  }
}
