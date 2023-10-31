public class Sphere {
  private int radius;

  // default constructor
  public Sphere() {
    radius = 9;
  }

  public Sphere(int r) {
    radius = r;
  }

  public double getSurfaceArea() {
    return 4 * 3.14 * Math.pow(radius, 2);
  }
  
  public double getVolume(){
    return (4/3) * 3.14 * Math.pow(radius, 3)
  }

Sphere kaiden1 = new Sphere();
System.out.println(kaiden1.getSurfaceArea()); // radius = 1

Sphere kaiden2 = new Sphere(3);
System.out.println(kaiden2.getSurfaceArea());
