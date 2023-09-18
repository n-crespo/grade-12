#include <cmath>
#include <iostream>

using namespace std;

int main() {

  const double carton = 3.78;
  const double price = 0.38;
  const double profit = 0.27;
  double produced;

  cout << "Enter how much milk was produced this morning: " << endl;
  cin >> produced;

  // makes sure to round to next highest integer by adding 0.5
  double useCartons = round((produced / carton) + 0.5);
  cout << "You need this many cartons: " << useCartons << endl;
  cout << "This yields this much profit: $" << profit * useCartons << endl;
  cout << "This costs this much: $" << price * produced << endl;
}
