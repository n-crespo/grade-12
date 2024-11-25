#include <fstream>
#include <iomanip>
#include <iostream>
#include <math.h>

using namespace std;
int main() {
  ifstream fin;
  fin.open("data.txt");

  ofstream fout;
  fout.open("output.txt");

  string fname, lname, dept;
  double salary, bonus, tax, distance, time, comicsCost;
  int comicsSold;

  // get info from file
  fin >> fname >> lname >> dept >> salary >> bonus >> tax >> distance >> time >>
      comicsSold >> comicsCost;

  // store name and dept, added line before so it looks better in the terminal
  string intro =
      "\nName: " + fname + " " + lname + ", Department: " + dept + "\n";

  // print salary
  cout << intro;
  cout << fixed << showpoint << setprecision(2);
  cout << "Monthly Gross Salary: $" << salary << ", Bonus: " << bonus
       << "%, Taxes: " << tax << "%\n";

  // calc paycheck and print
  // calculate bonus with salary = salary*(1.{bonus}), salary -= salary*{tax}
  cout << "Paycheck: $"
       << (salary * (1 + (bonus / 100))) -
              (salary * (1 + (bonus / 100)) * (tax / 100))
       << endl;

  cout << "\nDistance Traveled: " << distance
       << " miles, Traveling Time: " << time
       << " hours \nAverage Speed: " << distance / time << " miles per hour\n";

  cout << "\nNumber of Webcomics Sold: " << comicsSold
       << ", Cost of Each Webcomic: $" << comicsCost << "\nSales Amount: $"
       << comicsCost * comicsSold << endl;

  // now do the same thing but in output file
  fout << intro;
  fout << fixed << showpoint << setprecision(2);
  fout << "Monthly Gross Salary: $" << salary << ", Bonus: " << bonus
       << "%, Taxes: " << tax << "%\n";

  fout << "Paycheck: $"
       << (salary * (1 + (bonus / 100))) -
              (salary * (1 + (bonus / 100)) * (tax / 100))
       << endl;
  fout << "\nDistance Traveled: " << distance
       << " miles, Traveling Time: " << time
       << " hours \nAverage Speed: " << distance / time << " miles per hour\n";

  fout << "\nNumber of Webcomics Sold: " << comicsSold
       << ", Cost of Each Webcomic: $" << comicsCost << "\nSales Amount: $"
       << comicsCost * comicsSold << endl;

  // close input and output files
  fin.close();
  fout.close();
  // dont crash pls
  return 0;
}
