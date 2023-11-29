/**
 * AdvancePrime
 */
public class AdvancePrime {

  private static boolean isPrime(int number) {
    for (int i = 2; i * i <= number; i++) {
      if (number % i == 0) {
        return false;
      }
    }
    return true;

  }

  public static void main(String[] args) {
    int count = 0;
  }

}
