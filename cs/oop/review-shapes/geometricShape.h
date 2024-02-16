#ifndef GEOMETRICSHAPE_H
#define GEOMETRICSHAPE_H
#include <iostream>
#include <string>

using namespace std;
class geometricShape {
private:
  string color;

public:
  void setColor(string newColor) { color = newColor; };
  string getColor() const { return color; }
  geometricShape(string col = "None") { color = col; };
};

#endif
