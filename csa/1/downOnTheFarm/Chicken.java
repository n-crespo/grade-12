public class Chicken {
  String breed;
  int numberLayInDay;
  boolean isMean;
  double weight;

  public Chicken() {
    breed = "Rhode Island Red";
    numberLayInDay = 1;
    isMean = false;
    weight = 5.7;
  }

  public Chicken(String b, int n, boolean i, double w) {
    breed = b;
    numberLayInDay = n;
    isMean = i;
    weight = w;
  }

  public void makeNoise() {
    System.out.println("CLUCK CLUCK CLUCK");
  }

  public void displayChicken() {
    System.out.println(breed);
    System.out.println(numberLayInDay);
    System.out.println(isMean);
    System.out.println(weight);
  }
}
