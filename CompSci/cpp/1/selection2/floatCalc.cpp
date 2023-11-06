#include <assert.h>
#include <iostream>

using namespace std;
int main() {

  double num1, num2;
  char op;

  // get input
  cout << "Enter two numbers: " << endl;
  cin >> num1 >> num2;
  cout << "Enter the operation: " << endl;
  cin >> op;

  // do desired operation with switch case
  switch (op) {
  case '+':
    cout << num1 << "+" << num2 << " = " << num1 + num2 << endl;
    break;
  case '-':
    cout << num1 << "-" << num2 << " = " << num1 - num2 << endl;
    break;
  case '/':
    assert(num2 != 0);
    cout << num1 << "/" << num2 << " = " << num1 / num2 << endl;
    break;
  case '*':
    cout << num1 << "*" << num2 << " = " << num1 * num2 << endl;
    break;
  }
  return 0;
}
// references : https://www.geeksforgeeks.org/switch-statement-in-cpp/
