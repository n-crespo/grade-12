#include <iostream>
//This is task2

using namespace std;

int main() {
  double length, width;
  cout << "Please enter length, space, then width of the room: " << endl;
  cin >> length >> width;

  double area = width*length;
  cout << "The area of the room is: " << area << endl;
  cout << "The perimeter of the room is: " <<  length*2 + width*2 << endl;

  double  perimeterInMeters = length * 0.3048;
  double areaInMeters = width * 0.3048;

  cout << "The area in meters of the room is: " << perimeterInMeters << endl;
  cout << "The area in meters of the room is: " << areaInMeters << endl;
}

