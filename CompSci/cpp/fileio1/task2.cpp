#include <fstream>
#include <iomanip>
#include <iostream>
#include <string>

using namespace std;
int main() {
  string firstName, lastName;
  double firstScore, secondScore, thirdScore, fourthScore, fifthScore,
      averageScore;
  ofstream fout;

  cout << "Please enter your first and last name : \n";
  cin >> firstName >> lastName;

  cout << "Please enter your first score: \n";
  cin >> firstScore;

  cout << "Please enter your second score: \n";
  cin >> secondScore;

  cout << "Please enter your third score: \n";
  cin >> thirdScore;

  cout << "Please enter your fourth score: \n";
  cin >> fourthScore;

  cout << "Please enter your fifth score: \n";
  cin >> fifthScore;

  fout.open("test.txt");
  cout << fixed << showpoint << setprecision(2);
  fout << fixed << showpoint << setprecision(2);

  averageScore =
      (firstScore + secondScore + thirdScore + fourthScore + fifthScore) / 5;

  cout << "\n"
       << "Name: " << firstName << " " << lastName << "\n"
       << firstScore << "\n"
       << secondScore << "\n"
       << thirdScore << "\n"
       << fourthScore << "\n"
       << fifthScore << "\n"
       << "Average = " << averageScore << endl;
  fout << "Name: " << firstName << " " << lastName << "\n"
       << firstScore << "\n"
       << secondScore << "\n"
       << thirdScore << "\n"
       << fourthScore << "\n"
       << fifthScore << "\n"
       << "Average = " << averageScore << endl;
  fout.close();
  return 0;
}
