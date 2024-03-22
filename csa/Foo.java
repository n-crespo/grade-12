import java.util.Scanner;

public class Foo {
  public static void main(String[] args) {
    String[][] arr = { { "Hello,", "Hi,", "Hey," },

        { "it's", "it is", "it really is" },

        { "nice", "great", "a pleasure" },

        { "to", "to get to", "to finally" },

        { "meet", "see", "catch up with" },

        { "you", "you again", "you all" } };

    for (int j = 0; j < arr.length; j++)

    {

      for (int k = 0; k < arr[0].length; k++)

      {

        if (k == 1)

        {

          System.out.print(arr[j][k] + " ");

        }

      }

    }
  }
}
