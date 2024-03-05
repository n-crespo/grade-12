import java.util.ArrayList;

public class MultiplesOf3Program {
  public static void main(String[] args) {
    ArrayList<Integer> multiplesOf3 = new ArrayList<>();

    for (int i = 0; i < 100; i++) {
      int multiple = i * 3;
      multiplesOf3.add(multiple);
    }

    System.out.println("Multiples of 3:");
    for (int multiple : multiplesOf3) {
      System.out.println(multiple);
    }
  }
}
