public class Leopard {

  private double weight;
  private int age;
  private boolean alive;
  private String name;

  public Leopard() {
    weight = 0;
    age = 0;
    name = "unkonwn";
  }

  public Leopard(String n, int a, double w, boolean b) {
    weight = w;
    age = a;
    name = n;
    alive = b;
  }

  public void loseWeight() {
    weight -= 1;
  }

  public void getOlder() {
    age += 1;
  }

  public void hiss() {
    System.out.println("HISSSSSSSSSS");
  }

  public String toString() {
    return this.weight + " " + this.age + " " + this.name + " " + this.alive;
  }

}
