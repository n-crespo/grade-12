#include <iostream>
#include <string>

using namespace std;

int main() {

  // $80 an hour
  // $20 per liter of oil
  // filter = $50
  // + 20% Mercedes tax
  int hoursWorked, oilUsed;
  cout << "Enter hours worked: " << endl;
  cin >> hoursWorked;
  cout << "Enter oil used: (in liters): " << endl;
  cin >> oilUsed;

  double total = hoursWorked * 80 + oilUsed * 20 + 50;
  double mercedesTotal = total * (1.2);
  cout << "Your grand total is: " << total << endl;
  cout << "Just kidding your real (Mercedes) total is: " << mercedesTotal
       << endl;

  string ans;
  cout << "Would you buy a Mercedes again? " << endl;
  cin >> ans;
  if (ans == "yes") {
    cout << "What is wrong with you. You should've bought a Japanese car (not "
            "a Nissan though) instead. "
         << endl;
  } else if (ans == "no") {
    cout << "You're a fool. Should've gotten a BRABUS or AMG model instead of "
            "a base model. "
         << endl;
  } else {
    cout << "Why are you so difficult just answer yes or no " << endl;
  }

  return 0;
}
