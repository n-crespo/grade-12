#include <iostream>

using namespace std;

int main() {
  double length, width;

  /* get input (width and length), use equations to calculate area and perimeter
   */
  cout << "Please enter length, space, then width of the room in feet: "
       << endl;
  cin >> length >> width;
  double area = width * length;
  double perimeter = length * 2 + width * 2;
  cout << "The area of the room in feet is: " << area << endl;
  cout << "The perimeter of the room in feet is: " << perimeter << endl;

  /* convert from feet to meters */
  double perimeterInMeters = perimeter * 0.3048;
  double areaInMeters = area * 0.3048;

  cout << "The perimter in meters of the room is: " << perimeterInMeters
       << endl;
  cout << "The area in meters of the room is: " << areaInMeters << endl;
}
