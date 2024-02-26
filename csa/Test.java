public class Test {

  public static int mystery(int[] arr) {
    int count = 0;

    // Start with the last element as the current value
    int curr = arr[arr.length - 1];

    // Iterate through the array
    for (int value : arr) {
      // Compare the current value with the previous one
      if (value > curr) {
        // If the current value is greater, increment count
        count++;
      } else {
        // If the current value is not greater, decrement count
        count--;
      }

      // Update the current value for the next iteration
      curr = value;
    }

    // Return the final count
    return count;
  }

  public static void main(String[] args) {
    int[] arr = { 4, 14, 15, 3, 14, 18, 19 };

    // Call the mystery method and print the result
    System.out.println("Mystery count: " + mystery(arr));
  }
}
