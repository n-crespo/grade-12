public class ConversionTable {
  public static void main(String[] args) {
    System.out.println("feet\tmiles\tkms\t|\tkms\tmiles\tfeet");
    int initialMiles = 1;
    int initialkilometers = 1;
    double tempMiles;
    while (initialMiles <= 15) {

      // feet
      System.out.print(initialMiles * 5280);
      System.out.print("\t");

      // miles
      System.out.print(initialMiles);
      System.out.print("\t");

      // kilometers
      System.out.printf("%.3f", initialMiles * 1.609);
      System.out.print("\t");

      // seperators
      System.out.print("|\t");

      // kilometers
      System.out.print(initialkilometers);
      System.out.print("\t");

      // miles
      System.out.printf("%.3f", initialkilometers / 1.609);
      System.out.print("\t");
      tempMiles = initialkilometers / 1.609;

      // feet
      System.out.printf("%.3f", initialkilometers * 3280.84);
      System.out.println();

      initialkilometers++;
      initialMiles++;
    }
  }
}
