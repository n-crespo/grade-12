#include <iostream>

using namespace std;

int main() {

  int meetings;
  cout << "Enter how many chess club meetings you've attended: " << endl;
  cin >> meetings;
  if (meetings >= 4) {
    cout << "You earned 60 points." << endl;
  } else if (meetings == 3) {
    cout << "You earned 30 points. " << endl;
  } else if (meetings == 2) {
    cout << "You earned 15 points. " << endl;
  } else if (meetings == 1) {
    cout << "You earned 5 points. " << endl;
  } else if (meetings == 0) {
    cout << "You earned 0 points" << endl;
  }
  // dont crash please
  return 0;
}
