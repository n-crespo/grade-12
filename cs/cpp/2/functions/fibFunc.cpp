#include <cmath>
#include <iostream>

using namespace std;

long long f1, f2, n;

long long fibonacci(long long f1, long long f2, long long n) {

  // get necessary input

  if (n == 1) {
    cout << "The " << n << "th/rd digit is: " << f1 << endl;
  } else if (n == 2) {
    cout << "The " << n << "th/rd digit is: " << f2 << endl;
  } else if (n > 2) {
    // at this point next is n = 3;
    int nTracker = 3;
    int previous1 = f1;
    int previous2 = f2;
    int next;
    while (true) {
      next = previous1 + previous2;
      if (nTracker == n) {
        cout << "The " << n << " th/rd digit is: " << next << endl;
        return next;
        break;
      }
      previous1 = previous2;
      previous2 = next;
      nTracker++;
    }
  }
  return 0;
}

int main(int argc, char *argv[]) {

  cout << "Enter the first two digits of your fibonacci sequence: " << endl;
  cin >> f1 >> f2;

  cout << "Enter which index of the sequence you would like to genereate: "
       << endl;
  cin >> n;
  long long requestedNum = fibonacci(f1, f2, n);
  return 0;
}
