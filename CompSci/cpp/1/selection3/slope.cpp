#include <iostream>

using namespace std;

/* Ask the user to type in the x and y coordinates of two points in the x − y */
/* plane. The points are (x1,y1) and (x2,y2). The program should then output the
 */
/* equation of the line that passes through these two points, the slope of the
 */
/* line, and if the line is positive, negative, vertical, or horizontal. This is
 */
/* one of those problems where I urge you to check and make sure you got all the
 */
/* possible cases. */

int main() {
  int x1, x2, y1, y2;
  cout << "Enter coords in this format: x1 y1 x2 y2" << endl;
  cin >> x1 >> y1 >> x2 >> y2;
  // consider edge cases where slope is infinity and 0
  if (x2 == x1) {
    cout << "Your line is vertical. " << endl;
    cout << "The equation for your line is x = " << x1 << endl;
  } else if (y2 == y1) {
    cout << "Your line is horizontal. " << endl;
    cout << "The equation for your line is y = " << y1 << endl;
    // consider normal cases and construct equations
  } else {
    double slope = (y2 - y1) / (static_cast<double>(x2 - x1));
    if (slope > 0) {
      cout << "Your line is positive. " << endl;
    } else if (slope < 0) {
      cout << "Your line is negative. " << endl;
    }
    cout << "Equation: (y-" << y1 << ") = " << slope << "(x-" << x1 << ")";
  }

  return 0;
}
