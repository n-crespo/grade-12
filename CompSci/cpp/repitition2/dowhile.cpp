#include <iomanip>
#include <iostream>

using namespace std;

int main() {
  int num1, num2;
  cout << "Enter two numbers:" << endl;
  cin >> num1 >> num2;

  // create witness and empty sum varible
  int witness = min(num1, num2);
  int oddsums = 0;
  int allsums = 0;
  // loop through input

  do {
    allsums += witness;
    if (witness % 2 == 0) {
      cout << witness << endl;
    } else if (witness % 2 == 1) {
      oddsums += witness;
    }
    cout << witness << " squared = " << witness * witness << endl;
    witness++;
  } while (witness <= max(num2, num1));

  // print alphabet
  int i = 0;
  char letter = 'A';

  do {
    cout << letter;
    i++;
    letter++;
  } while (i < 26);

  return 0;
}
