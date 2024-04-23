import java.util.ArrayList;
import java.util.Scanner;

public class Program1 {

  public static void main(String[] args) {
    int k;
    int A[];
    A = new int[7];
    for (k = 0; k < A.length; k++) {
      A[k] = A.length - k;
    }
    for (k = 0; k < A.length - 1; k++) {
      A[k + 1] = A[k];
    }

    for (int i : A) {
      System.out.println(i);
    }
  }
}
