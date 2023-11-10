public class Pig {
  private String color;
  private int penSize;
  private boolean wallowedInMud;
  private double weight;

  public Pig() {
    color = "pink";
    penSize = 11;
    wallowedInMud = true;
    weight = 500.0;
  }

  public Pig(String c, int p, boolean wa, double we) {
    color = c;
    penSize = p;
    wallowedInMud = wa;
    weight = we;
  }

  public void makeNoise() {
    System.out.println("OINK OINK OINK");
  }

  public void upgradePenSize(int amount) {
    penSize += amount;
  }

  public void displayPig() {
    System.out.println(color);
    System.out.println(penSize);
    System.out.println(wallowedInMud);
    System.out.println(weight);
  }

}
