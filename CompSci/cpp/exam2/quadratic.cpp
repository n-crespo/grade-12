#include <cmath>
#include <iostream>

using namespace std;
int main() {

  // get inputs
  double a, b, c;
  cout << "Enter values for a, b, and c:" << endl;
  cin >> a >> b >> c;

  // preemptively calculate discriminants
  double disc = (pow(b, 2)) - (4 * a * c);

  // print roots accordingly
  if (disc > 0) {
    double root1 = (-b + pow(disc, 0.5)) / (2 * a);
    double root2 = (-b - pow(disc, 0.5)) / (2 * a);
    cout << "There are two real roots " << endl;
    cout << "Root 1: " << root1 << endl;
    cout << "Root 2: " << root2 << endl;

  } else if (disc < 0) {
    double aTerm = -b / (2 * a);
    double bTerm = pow(abs(disc), 0.5);
    cout << "There are two complex roots. There are 0 real roots. " << endl;
    cout << "Complex Root 1: " << aTerm << " + " << bTerm << "i" << endl;
    cout << "Complex Root 2: " << aTerm << " - " << bTerm << "i" << endl;

  } else if (disc == 0) {
    double root1 = (-b / (2 * a));
    cout << "There is one real repeated root. " << endl;
    cout << "Root: " << root1 << endl;
  }

  // dont crash
  return 0;
}
