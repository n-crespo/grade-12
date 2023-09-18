#include <cmath>
#include <iostream>

using namespace std;

int main() {
  int change;

  cout << "Enter how much change you have in cents: " << endl;
  cin >> change;

  // use floor division for each coin to caclulate max number of coins that can
  // fit within the inputted amount, then subtract that number of coins times
  // the coin value from the change, and repeat for all coins.
  int halfDollar = floor(change / 50);
  cout << "Half Dollars: " << halfDollar << endl;
  change -= halfDollar * 50;

  int quarter = floor(change / 25);
  cout << "Quarters: " << quarter << endl;
  change -= quarter * 25;

  int dime = floor(change / 10);
  cout << "Dimes: " << dime << endl;
  change -= dime * 10;

  int nickel = floor(change / 5);
  cout << "Nickels: " << nickel << endl;
  change -= nickel * 5;

  int penny = floor(change / 1);
  cout << "Pennies: " << penny << endl;
}
