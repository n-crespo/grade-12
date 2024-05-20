
/**
 * Teacups
 */
public class Teacups extends Attraction {

  private int numberOfTeacups;
  private int ridersPerTeacup;
  private int seatsPerTeacup;
  private int numberOfRotations;
  private double timePerRotation;

  public int getNumberOfTeacups() {
    return numberOfTeacups;
  }

  public void setNumberOfTeacups(int numberOfTeacups) {
    this.numberOfTeacups = numberOfTeacups;
  }

  public int getRidersPerTeacup() {
    return ridersPerTeacup;
  }

  public void setRidersPerTeacup(int ridersPerTeacup) {
    this.ridersPerTeacup = ridersPerTeacup;
  }

  public int getSeatsPerTeacup() {
    return seatsPerTeacup;
  }

  public void setSeatsPerTeacup(int seatsPerTeacup) {
    this.seatsPerTeacup = seatsPerTeacup;
  }

  public int getNumberOfRotations() {
    return numberOfRotations;
  }

  public void setNumberOfRotations(int numberOfRotations) {
    this.numberOfRotations = numberOfRotations;
  }

  public int getMaxRiders() {
    return numberOfTeacups * ridersPerTeacup;
  }

  public double getHeight() {
    return 5;
  }

  public int getRideLength() {
    return (int) (numberOfRotations * timePerRotation);
  }

  public Teacups(int maxRiders, double ticketPrice, double utilityCost, double rideLength, int ridersPerHour,
      int hoursPerDay, double speed, double height, int numberOfTeacups, int ridersPerTeacup, int seatsPerTeacup,
      int numberOfRotations, double timePerRotation) {
    super(maxRiders, ticketPrice, utilityCost, rideLength, ridersPerHour, hoursPerDay, speed, height);
    this.numberOfTeacups = numberOfTeacups;
    this.ridersPerTeacup = ridersPerTeacup;
    this.seatsPerTeacup = seatsPerTeacup;
    this.numberOfRotations = numberOfRotations;
    this.timePerRotation = timePerRotation;
  }

}
