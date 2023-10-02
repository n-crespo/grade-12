#include <cmath>
#include <iostream>

using namespace std;

int main() {

  double minutes;
  cout << "Enter how many long your car has been parked: " << endl;
  cin >> minutes;

  if (minutes > 24 * 60) {
    cout << "You have exceeded the maximum parking limit. You will pay at "
            "least $70. "
         << endl;
  } else if (minutes == 24 * 60) {
    cout << "You owe $70. " << endl;
  } else if (minutes > 60 * 3) {
    cout << "You owe $"
         << (ceil(minutes / 30) - (floor(minutes / 30)) * 8 +
             (floor(minutes / 30) * 4))
         << endl;
  } else if (minutes <= 60 * 3) {
    cout << "You owe $" << ceil(minutes / 30) * 4 << endl;
  } else if (minutes == 30) {
    cout << "You owe $4. " << endl;

    return 0;
  }
}
