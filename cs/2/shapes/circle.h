#ifndef CIRCLE_H
#define CIRCLE_H
#include "geometricShape.h"

class Circle : public geometricShape {
private:
  double radius;

public:
  void setRadius(double r) { radius = r; }
  double getRadius() const { return radius; }

  double circumference() { return 2 * 3.14 * radius; }
  double area() { return 3.14 * radius * radius; }

  Circle(double r = 1, string c = "None") : geometricShape(c) { radius = r; };
};

#endif
