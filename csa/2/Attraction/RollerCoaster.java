// roller coaster
public class RollerCoaster extends Attraction {
  private boolean upsideDown;
  private int minRiderHeight;

  public RollerCoaster(int maxRiders, double ticketPrice, double utilityCost, int rideLength, int ridersPerHour,
      int hoursPerDay, double speed, double height, boolean upsideDown, int minRiderHeight) {
    super(maxRiders, ticketPrice, utilityCost, rideLength, ridersPerHour, hoursPerDay, speed, height);
    this.upsideDown = upsideDown;
    this.minRiderHeight = minRiderHeight;
  }

  public boolean isUpsideDown() {
    return upsideDown;
  }

  public void setUpsideDown(boolean upsideDown) {
    this.upsideDown = upsideDown;
  }

  public int getMinRiderHeight() {
    return minRiderHeight;
  }

  public void setMinRiderHeight(int minRiderHeight) {
    this.minRiderHeight = minRiderHeight;
  }

  public static void main(String[] args) {
    RollerCoaster rollerCoaster = new RollerCoaster(10, 10, 10, 10, 10, 10, 10, 10, true, 10);
  }

}
