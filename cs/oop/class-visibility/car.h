#ifndef CAR_H
#define CAR_H
#include "vehicle.h"

class car : public vehicle {
private:
  int numOfSeats;
  bool hasSunRoof;
  double trunkCapacity;
  double fuelEfficiency;

public:
  void setNumOfSeats(int n) { numOfSeats = n; };
  int getNumOfSeats() { return numOfSeats; };

  void setHasSunRoof(bool h) { hasSunRoof = h; };
  bool getHasSunRoof() { return hasSunRoof; };

  void setTrunkCapacity(double t) { trunkCapacity = t; };
  double getTrunkCapacity() { return trunkCapacity; };

  void setFuelEfficiency(double f) { fuelEfficiency = f; };
  double getFuelEfficiency() { return fuelEfficiency; };

  car(string mo, string ma, double fc, int n = 0, bool h = false, double t = 0,
      double fe = 0)
      : vehicle(ma, mo, fc) {
    numOfSeats = n;
    hasSunRoof = h;
    trunkCapacity = t;
    fuelEfficiency = fe;
  }
};

#endif
