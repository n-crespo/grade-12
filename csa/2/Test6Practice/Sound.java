// Note: due to the exclusion of the given/required methods from the FRQ
// question, this code will not work because certain things like instance
// methods are not defined. Both question have been answered assuming the given
// methods have been defined. 
public class Sound {
  public int limitAmplitude(int limit) {
    int changedCount = 0;
    for (int i = 0; i < this.samples.length; i++) {
      if (this.samples[i] < -limit) {
        this.samples[i] = -limit;
        changedCount++;
      }
      if (this.samples[i] > limit) {
        this.samples[i] = limit;
        changedCount++;
      }
    }
    return changedCount;
  }

  public void trimSilenceFromBeginning() {
    int i = 0;
    while (this.samples[i] == 0) {
      i++;
    }
    int[] new = new int[this.samples.length - i];
    for (int j = 0; j < new.length; j++) {
      new[j] = this.samples[j + i];
    }
    this.samples = new;
  }

}
