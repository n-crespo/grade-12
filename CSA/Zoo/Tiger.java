public class Tiger {

  private double weight;
  private int age;
  private boolean alive;
  private String name;

  public Tiger() {
    weight = 0;
    age = 0;
    name = "unkonwn";
  }

  public Tiger(String n, int a, double w, boolean b) {
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

  public void growl() {
    System.out.println("Grrrrrrr");
  }

  public String toString() {
    return this.weight + " " + this.age + " " + this.name + " " + this.alive;
  }

}
