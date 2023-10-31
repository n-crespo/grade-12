public class Song {
  public Song() {
  }

  public void printChorus(String instruction) {
    System.out.println("If you're happy and you know it " + instruction);
  }

  public void printChorus() {
    System.out.println("If you're happy and you know it, then your face will surely show it, ");
  }

  public static void main(String[] args) {
    Song song = new Song();
    song.printChorus("wave your arms,");
    song.printChorus("wiggle your fingers,");
    song.printChorus();
    song.printChorus("jump up and down!");

  }

}
