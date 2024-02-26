// Note: due to the exclusion of the given/required methods from the FRQ
// question, this code will not work because certain things like instance
// methods are not defined. Both question have been answered assuming the given
// methods have been defined. 
public class Cube {

  public static int[] getCubeTosses(NumberCube cube, int numTosses) {
    int[] cubeTosses = new int[numTosses];
    for (int i = 0; i < numTosses; i++) {
      cubeTosses[i] = cube.toss();
    }
    return cubeTosses;
  }

  public static int getLongestRun(int[] values) {
    int currentLength = 0;
    int currentValue = -1;
    int maxLength = 0;
    int index = -1;
    for (int i = values.length - 1; i >= 0; i--) {
      if (values[i] == currentValue)
        currentLength++;
      else {
        if (maxLength < currentLength) {
          maxLength = currentLength;
          index = i + 1;
        }
        currentValue = values[i];
        currentLength = 1;
      }
    }
    if (maxLength < currentLength) {
      maxLength = currentLength;
      index = 0;
    }
    if (maxLength == 1)
      return -1;
    return index;
  }
}
