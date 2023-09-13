#include <iostream>
using namespace std;

int main() {
  /* get input  */
  int feet, inches, heightInCm, heightinIn;
  cout << "Please enter your height in centimeters: " << endl;
  cin >> heightInCm;

  /* convert inches to cm */
  heightinIn = heightInCm * 0.393701;
  /* convert inches value to feet' inches" value by forcing integer division and
   * doing mod 12 to get the remaining inches  */
  feet = heightinIn / 12;
  inches = heightinIn % 12;

  cout << "Your height in inches is: " << heightinIn << endl;
  cout << "Your height in feet and inches is: " << feet << "' " << inches
       << "\"" << endl;
  cout << "Your height in smoots is: " << (double)heightinIn / 67 << endl;
}
