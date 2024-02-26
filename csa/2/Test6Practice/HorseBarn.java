// Note: due to the exclusion of the given/required methods from the FRQ
// question, this code will not work because certain things like instance
// methods are not defined. Both question have been answered assuming the given
// methods have been defined. 
class HorseBarn {
  // a
  public int findHorseSpace(String name) {
    for (int i = 0; i < this.spaces.length; i++) {
      if (this.spaces[i] != null && name.equals(this.spaces[i].getName())) {
        return i;
      }
    }
    return -1;
  }

  // b
  public void consolidate() {
    Horse[] newSpaces = new Horse[this.spaces.length];
    int nextSpot = 0;
    for (Horse nextHorse : this.spaces) {
      if (nextHorse != null) {
        newSpaces[nextSpot] = nextHorse;
        nextSpot++;
      }
    }
    this.spaces = newSpaces;
  }
}
