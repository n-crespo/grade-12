#include <iostream>

using namespace std;

int main() {

  int grade;
  // get input
  cout << "Enter your grade: " << endl;
  cin >> grade;
  //
  /* Score	Grade	Gen-Z Rating */
  /* 90-100	A	Absolute Gigachad */
  /* 80-89	B	Based */
  /* 70-79	C	Mid */
  /* 60-69	D	Cringe*/
  /* 0-59	 F>Press F to pay respects. */

  // display letter grade and correct status (above)
  if (grade >= 90) {
    cout << "Grade: A \nRating: Absolute Gigachad" << endl;
  } else if (grade >= 80) {
    cout << "Grade: B \nRating: Based" << endl;
  } else if (grade >= 70) {
    cout << "Grade: C \nRating: Mid" << endl;
  } else if (grade >= 60) {
    cout << "Grade: D \nRating: Cringe" << endl;
  } else {
    cout << "Grade: F \nRating: Press F to pay respects." << endl;
  }
  return 0;
}
