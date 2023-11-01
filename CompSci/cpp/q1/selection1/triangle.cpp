#include <cmath>
#include <iostream>

using namespace std;

int main() {
  int side1, side2, side3;

  cout << "Enter the three lengths of the triangle: " << endl;
  cin >> side1 >> side2 >> side3;
  if ((pow(side1, 2) == pow(side2, 2) + pow(side3, 2)) ||
      (pow(side2, 2) == pow(side3, 2) + pow(side1, 2)) ||
      (pow(side3, 2) == pow(side2, 2) + pow(side1, 2))) {
    cout << "That is a right triangle. " << endl;
  } else {
    cout << "That is not a right triangle. " << endl;
  }
}
