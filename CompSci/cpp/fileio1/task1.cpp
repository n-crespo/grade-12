
#include <cmath>
#include <fstream>
#include <iomanip>
#include <iostream>
#include <string>

using namespace std;
int main() {

  string firstName, lastName;
  double salary, raise, newSalary;

  ifstream fin;
  ofstream fout;

  fin.open("employeeDataInput.txt");
  fout.open("output.txt");

  fin >> firstName >> lastName >> salary >> raise;
  newSalary = salary * ((raise * 0.01) + 1);
  fout << firstName << " " << lastName << " " << fixed << showpoint
       << setprecision(2) << newSalary << endl;

  fin >> firstName >> lastName >> salary >> raise;
  newSalary = salary * ((raise * 0.01) + 1);
  fout << firstName << " " << lastName << " " << fixed << showpoint
       << setprecision(2) << newSalary << endl;

  fin >> firstName >> lastName >> salary >> raise;
  newSalary = salary * ((raise * 0.01) + 1);
  fout << firstName << " " << lastName << " " << fixed << showpoint
       << setprecision(2) << newSalary << endl;

  fin.close();
  fout.close();

  return 0;
}
