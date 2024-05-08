#include <assert.h>
#include <iostream>

using namespace std;
int main() {

  int num1, num2;
  string op;

  // get input
  cout << "Enter two numbers: " << endl;
  cin >> num1 >> num2;
  cout << "Enter the operation: " << endl;
  cin >> op;

  // do desired operation
  if (op == "+")
    cout << num1 << "+" << num2 << " = " << num1 + num2 << endl;
  else if (op == "-")
    cout << num1 << "-" << num2 << " = " << num1 - num2 << endl;
  else if (op == "*")
    cout << num1 << "*" << num2 << " = " << num1 * num2 << endl;
  else if (op == "/") {
    // ensure no divion by 0
    assert(num2 != 0);
    cout << num1 << "/" << num2 << " = " << num1 / num2 << endl;
  } else if (op == "%") {
    // ensure no divion by 0
    assert(num2 != 0);
    cout << num1 << "%" << num2 << " = " << num1 % num2 << endl;
  }
  return 0;
  // references: https://www.geeksforgeeks.org/assertions-cc/
}
