#include <iostream>
using namespace std;

struct FruitStand {
  int numPlums;
  int numPeaches;
};

FruitStand AddFruits(FruitStand stand1, FruitStand stand2) {
  FruitStand newStand;

  newStand.numPlums = stand1.numPlums + stand2.numPlums;
  newStand.numPeaches = stand1.numPeaches + stand2.numPeaches;

  return newStand;
}

int main() {
  FruitStand stand1;
  FruitStand stand2;
  FruitStand standTotals;

  stand1.numPlums = 7;
  stand1.numPeaches = 12;

  stand2.numPlums = 2;
  stand2.numPeaches = 5;

  standTotals = AddFruits(stand1, stand2);

  cout << standTotals.numPlums << " Plums" << endl;
  cout << standTotals.numPeaches << " Peaches" << endl;

  return 0;
}
