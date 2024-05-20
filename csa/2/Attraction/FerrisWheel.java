/**
 * FerrisWheel
 */
public class FerrisWheel extends Attraction {
  private double radius;
  private int numberOfSeats;
  private int ridersPerSeat;

  public int getNumberOfSeats() {
    return numberOfSeats;
  }

  public void setNumberOfSeats(int numberOfSeats) {
    this.numberOfSeats = numberOfSeats;
  }

  public int getRidersPerSeat() {
    return ridersPerSeat;
  }

  public void setRidersPerSeat(int ridersPerSeat) {
    this.ridersPerSeat = ridersPerSeat;
  }

  public double getRadius() {
    return radius;
  }

  public void setRadius(double radius) {
    this.radius = radius;
  }

  // override parent methods
  public int getMaxRiders() {
    return numberOfSeats * ridersPerSeat;
  }

  // override parent methods
  public double getHeight() {
    return radius * 2;
  }

  public FerrisWheel(int maxRiders, double ticketPrice, double utilityCost, int rideLength, int ridersPerHour,
      int hoursPerDay, double speed, double height, double radius, int numberOfSeats, int ridersPerSeat) {
    super(maxRiders, ticketPrice, utilityCost, rideLength, ridersPerHour, hoursPerDay, speed, height);
    this.radius = radius;
    this.numberOfSeats = numberOfSeats;
    this.ridersPerSeat = ridersPerSeat;
  }

}
