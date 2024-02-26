// Note: due to the exclusion of the given/required methods from the FRQ
// question, this code will not work because certain things like instance
// methods are not defined. Both question have been answered assuming the given
// methods have been defined. 
public class Trail {

  public boolean isLevelTrailSegment(int start, int end) {
    for (int i = start; i < end; i++) {
      for (int j = start + 1; j <= end; j++) {
        if (Math.abs(this.markers[i] - this.markers[j]) > 10) {
          return false;
        }
      }
    }
    return true;
  }

  public boolean isDifficult() {
    int numberOfChanges = 0;
    for (int i = 0; i < this.markers.length - 1; i++) {
      if (Math.abs(this.markers[i] - this.markers[i + 1]) >= 30) {
        numberOfChanges++;
      }
    }
    return (numberOfChanges >= 3);
  }

}
