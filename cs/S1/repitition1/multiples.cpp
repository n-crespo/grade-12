#include <algorithm>
#include <iostream>

using namespace std;

int main() {
  // get input
  int num1 = 0;
  int num2 = 0;
  int threes = 0;
  int fives = 0;
  int witness = 0;

  cout << "Enter two integers: " << endl;
  cin >> num1 >> num2;

  // make witness start at lower input value
  witness = min(num1, num2);

  // check for multiples between and including both input values
  while (witness <= max(num1, num2)) {
    if ((witness % 3) == 0) {
      threes++;
    }
    if ((witness % 5) == 0) {
      fives++;
    }
    witness++;
  }
  cout << "Between those two numbers there are: " << threes
       << " multiples of three, and " << fives << " multiples of five" << endl;
  return 0;
}
