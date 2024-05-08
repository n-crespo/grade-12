#ifndef VEHICLE_H
#define VEHICLE_H
#include <iostream>
#include <string>

using namespace std;
class vehicle {
private:
  string make;
  string model;
  double fuelCapacity;

public:
  string getMake() { return make; };
  string getModel() { return model; };
  double getFuelCapacity() { return fuelCapacity; };

  void setMake(string m) { make = m; };
  void setModel(string m) { model = m; };
  void setFuelCapacity(double f) { fuelCapacity = f; };

  vehicle(string ma = "N/A", string mo = "N/A", double fc = 0) {
    make = ma;
    model = mo;
    fuelCapacity = fc;
  };
};

#endif // VEHICLE_H
