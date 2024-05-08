#include <fstream>
#include <iomanip>
#include <ios>
#include <iostream>
#include <math.h>

using namespace std;

int main() {
  // this is the gravitational constant
  const double k = 6.67 * pow(10, -11);
  double mass1, mass2;
  double distance;
  ofstream fout;

  cout << "Enter the masses of the two bodies: " << endl;
  cin >> mass1 >> mass2;

  cout << "Enter the distance between the two bodies:" << endl;
  cin >> distance;

  // calulate the gravitational force between two bodies of a given mass and
  // distance
  double force = k * (mass1 * mass2) / pow(distance, 2);
  cout << "The gravitational force between the objects is " << scientific
       << setprecision(4) << force << endl;

  // put output in output file
  fout.open("output.txt");
  fout << "Masses: " << mass1 << ", " << mass2 << endl;
  fout << "Distance: " << distance << endl;
  fout << "Force: " << scientific << setprecision(4) << force << endl;

  return 0;
}
