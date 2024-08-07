public class Attraction {
  private int maxRiders;
  private double ticketPrice;
  private double utilityCost;
  private double rideLength;
  private int ridersPerHour;
  private int hoursPerDay;
  private double speed;
  private double height;

  public int getMaxRiders() {
    return maxRiders;
  }

  public void setMaxRiders(int maxRiders) {
    this.maxRiders = maxRiders;
  }

  public double getTicketPrice() {
    return ticketPrice;
  }

  public void setTicketPrice(double ticketPrice) {
    this.ticketPrice = ticketPrice;
  }

  public double getUtilityCost() {
    return utilityCost;
  }

  public void setUtilityCost(double utilityCost) {
    this.utilityCost = utilityCost;
  }

  public double getRideLength() {
    return rideLength;
  }

  public void setRideLength(int rideLength) {
    this.rideLength = rideLength;
  }

  public int getRidersPerHour() {
    return ridersPerHour;
  }

  public void setRidersPerHour(int ridersPerHour) {
    this.ridersPerHour = ridersPerHour;
  }

  public int getHoursPerDay() {
    return hoursPerDay;
  }

  public void setHoursPerDay(int hoursPerDay) {
    this.hoursPerDay = hoursPerDay;
  }

  public double getSpeed() {
    return speed;
  }

  public void setSpeed(double speed) {
    this.speed = speed;
  }

  public double getHeight() {
    return height;
  }

  public void setHeight(double height) {
    this.height = height;
  }

  public Attraction(int maxRiders, double ticketPrice, double utilityCost, double rideLength, int ridersPerHour,
      int hoursPerDay, double speed, double height) {
    this.maxRiders = maxRiders;
    this.ticketPrice = ticketPrice;
    this.utilityCost = utilityCost;
    this.rideLength = rideLength;
    this.ridersPerHour = ridersPerHour;
    this.hoursPerDay = hoursPerDay;
    this.speed = speed;
    this.height = height;
  }

  public static void main(String[] args) {
    System.out.println("hello from attraction");
  }
}
