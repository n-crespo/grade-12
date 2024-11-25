// this is so brute force its disgusting
// physically painful to look at
#include <fstream>
#include <iomanip>
#include <iostream>
#include <ostream>
using namespace std;
int main() {

  // initialize variable
  double paper, marker, dryErase, tape, pencil, eraser, highlighter, paperClip;
  double orderPaper, orderMarker, orderDryErase, orderTape, orderPencil,
      orderEraser, orderHighlighter, orderPaperClip;

  // get prices
  ifstream fin;
  fin.open("items.txt");
  fin >> paper >> marker >> dryErase >> tape >> pencil >> eraser >>
      highlighter >> paperClip;

  // print prices
  cout << "\nPrices\n"
       << "------------------" << endl;
  cout << "Paper costs $" << fixed << setprecision(2) << paper << endl;
  cout << "Marker costs $" << fixed << setprecision(2) << marker << endl;
  cout << "Dry Erase Marker costs $" << fixed << setprecision(2) << dryErase
       << endl;
  cout << "Tape costs $" << fixed << setprecision(2) << tape << endl;
  cout << "Pencil costs $" << fixed << setprecision(2) << pencil << endl;
  cout << "Eraser costs $" << fixed << setprecision(2) << eraser << endl;
  cout << "Highlighter costs $" << fixed << setprecision(2) << highlighter
       << endl;
  cout << "Paper Clip costs $" << fixed << setprecision(2) << paperClip << endl;

  // get input for how many of each item to order
  cout << "\n Enter how many papers you want: " << endl;
  cin >> orderPaper;
  cout << "Enter how many markers you want: " << endl;
  cin >> orderMarker;
  cout << "Enter how many dry erase markers you want: " << endl;
  cin >> orderDryErase;
  cout << "Enter how many tapes you want: " << endl;
  cin >> orderTape;
  cout << "Enter how many pencils you want: " << endl;
  cin >> orderPencil;
  cout << "Enter how many erasers you want: " << endl;
  cin >> orderEraser;
  cout << "Enter how many highlighters you want: " << endl;
  cin >> orderHighlighter;
  cout << "Enter how many paper clips you want: " << endl;
  cin >> orderPaperClip;

  // print receipt
  ofstream fout;
  fout.open("cost.txt");
  fout << "Here is the summary of office supply order: \n"
          "------------------------------------------- "
       << endl;
  fout << "Paper" << setfill('-') << setw(10) << orderPaper << endl;
  fout << "Marker" << setfill('-') << setw(10) << orderMarker << endl;
  fout << "Dry Erase Marker" << setfill('-') << setw(10) << orderDryErase
       << endl;
  fout << "Tape" << setfill('-') << setw(10) << orderTape << endl;
  fout << "Pencil" << setfill('-') << setw(10) << orderPencil << endl;
  fout << "Eraser" << setfill('-') << setw(10) << orderEraser << endl;
  fout << "Highlighter" << setfill('-') << setw(10) << orderHighlighter << endl;
  fout << "Paper Clip" << setfill('-') << setw(10) << orderPaper << endl;

  // calculate total cost by multiplying cost times order number
  fout << "The office supply order total cost is: $"
       << orderPaper * paper + orderMarker * marker + orderDryErase * dryErase +
              orderTape * tape + orderEraser * eraser +
              orderHighlighter * highlighter + orderPaper * paper
       << endl;

  // get amazon prime
  fout << "Shipping time: 5 days." << endl;

  // dont crash
  return 0;

  // References below
  // ----------------
  // https://www.geeksforgeeks.org/setw-function-in-cpp-with-examples/
  // https://www.geeksforgeeks.org/iomanip-setfill-function-in-c-with-examples/
  // https://stackoverflow.com/questions/35107801/invalid-operands-to-binary-expression-stdostream-aka-basic-ostreamchar
}
