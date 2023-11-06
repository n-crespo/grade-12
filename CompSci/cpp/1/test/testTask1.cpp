#include <iomanip>
#include <iostream>
#include <math.h>

using namespace std;
int main() {

  // initialize variables
  int timeInSeconds;
  const int acc = 32;

  // get input
  cout << "enter a time in seconds: ";
  cin >> timeInSeconds;

  // calcluate distance traveled in freefalll if falling for {input} number of
  // seconds
  // use equation (d = 0.5 * a * t^2)

  cout << "You will fall for " << scientific << setprecision(4)
       << 0.5 * acc * pow(timeInSeconds, 2) << " feet. " << endl;
  return 0;
}
