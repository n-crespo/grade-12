#include <iomanip>
#include <iostream>

using namespace std;

int main() {

  int num1, num2;
  cout << "Enter two numbers:" << endl;
  cin >> num1 >> num2;

  // create witness variables and empty sum values
  int witness = min(num1, num2);
  int oddsums = 0;
  int allsums = 0;
  // loop through input
  while (witness <= max(num2, num1)) {
    allsums += witness;
    if (witness % 2 == 0) {
      cout << witness << endl;
    } else if (witness % 2 == 1) {
      oddsums += witness;
    }
    cout << witness << " squared = " << witness * witness << endl;
    witness++;
  }
  // print alphabet
  int i = 0;
  char letter = 'A';
  while (i < 26) {
    cout << letter;
    i++;
    letter++;
  }

  return 0;
}
