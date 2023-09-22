
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
  ifstream inFile;
  ifstream inData;

  fin.open("test.txt");

  fin >> firstName >> lastName >> salary >> raise;
  salary *= 2;
  // do stuff

  fin.close();

  ofstream fout;
  ofstream outFile;
  ofstream outData;

  fout.open("output.txt");
  fout << salary;

  return 0;
}
