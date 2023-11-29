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
    int num = 2;
    while (count < 50) {
      if (isPrime(num)) {
        System.out.print(num + " ");
        if ((count + 1) % 10 == 0) {
          System.out.println("");
        }
        count++;
      }
      num++;
    }
  }

}
