#include "circle.h"
#include "rectangle.h"
#include <iostream>

int main() {
  Rectangle r(3, 4, "red");
  Circle c(5, "blue");

  cout << r.area() << endl;
  cout << "R color: " << r.getColor() << endl;
  cout << "Setting R color to yellow..." << endl;
  r.setColor("yellow");
  cout << r.getColor() << endl;
  cout << "R perimeter: " << r.perimeter() << endl;

  cout << "Setting C color to blue..." << endl;
  c.setColor("blue");
  cout << "C new color: " << c.getColor() << endl;
  cout << "C area: " << c.area() << endl;
  cout << "C circumference: " << c.circumference() << endl;
  return 0;
}
