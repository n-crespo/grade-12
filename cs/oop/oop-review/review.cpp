#include <iostream>
#include <string>
using namespace std;

class geometricShape {
private:
  string color;

public:
  void setColor(string newColor);
  string getColor() const { return color; }
  geometricShape(string col = "None") { color = col; };
};

class Circle : public geometricShape {
private:
  double radius;

public:
  void setRadius(double r) { radius = r; }
  double getRadius() { return radius; }

  double circumference() { return 2 * 3.14 * radius; }
  double area() { return 3.14 * radius * radius; }

  Circle(double r = 1, string c = "None") : geometricShape(c) { radius = r; };
};

class Rectangle : public geometricShape {
private:
  double length, width;

public:
  void setWidth(double w) { width = w; }
  double getWidth() { return width; }

  void setLength(double l) { length = l; }
  double getLength() { return length; }

  double perimeter() { return 2 * (length * width); }
  double area() { return length * width; }

  Rectangle(double l = 1, double w = 1, string c = "None") : geometricShape(c) {
    length = l;
    width = w;
  }
};

int main() {
  Rectangle r(3, 4, "red");
  Circle c(5, "blue");

  cout << r.area() << endl;
  cout << "R color: " << r.getColor() << endl;
  cout << "Setting R color to yellow..." << endl;
  r.setColor("yellow");
  cout << "R perimeter: " << r.perimeter() << endl;

  cout << "Setting C color to blue..." << endl;
  c.setColor("blue");
  cout << "C new color: " << c.getColor() << endl;
  cout << "C area: " << c.area() << endl;
  cout << "C circumference: " << c.circumference() << endl;
  return 0;
}
