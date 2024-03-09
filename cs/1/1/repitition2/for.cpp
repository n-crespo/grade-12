#include <iomanip>
#include <iostream>

using namespace std;

int main() {
  int num1, num2;
  cout << "Enter two numbers:" << endl;
  cin >> num1 >> num2;

  // create witness and empty sum varible
  int witness;
  int oddsums = 0;
  int allsums = 0;
  // loop through input
  for (witness = min(num1, num2); witness <= max(num2, num1); witness++) {
    allsums += witness;
    if (witness % 2 == 0) {
      cout << witness << endl;
    } else if (witness % 2 == 1) {
      oddsums += witness;
    }
    cout << witness << " squared = " << witness * witness << endl;
  }

  // print alphabet
  char letter = 'A';
  int i = 0;
  for (i = 0; i < 26; i++) {
    cout << letter;
    letter++;
  }

  return 0;
}
