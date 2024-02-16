#include "geometricShape.h"
#ifndef RECTANGLE_H
#define RECTANGLE_H

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
#endif
