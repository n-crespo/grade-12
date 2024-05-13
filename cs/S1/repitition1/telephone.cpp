#include <cctype>
#include <iostream>
#include <sys/types.h>

using namespace std;
int main() {

  string input, output;
  // get input
  cout << "Enter a phone number in letters: " << endl;
  cin >> input;
  int index = 0;

  // remove all dashes, will be replaced later
  while (index <= (input.length() - 1)) {
    if (input[index] == '-') {
      input.erase(index, 1);
    }
    index++;
  }
  index = 0;
  while (index <= (input.length() - 1) && (index < 10)) {
    // switch case to translate letters to phone number
    switch (tolower(input[index])) {
    case 'a':
    case 'b':
    case 'c':
      output.append("2");
      break;
    case 'd':
    case 'e':
    case 'f':
      output.append("3");
      break;
    case 'g':
    case 'h':
    case 'i':
      output.append("4");
      break;
    case 'j':
    case 'k':
    case 'l':
      output.append("5");
      break;
    case 'm':
    case 'n':
    case 'o':
      output.append("6");
      break;
    case 'p':
    case 'q':
    case 'r':
    case 's':
      output.append("7");
      break;
    case 't':
    case 'u':
    case 'v':
      output.append("8");
      break;
    case 'w':
    case 'x':
    case 'y':
    case 'z':
      output.append("9");
      break;
    // if not letter in input, don't change it in output
    default:
      output += (input[index]);
    }

    // add dashes in correct spot
    if (index == 2 || index == 5) {
      output.append("-");
    }

    index++;
  }
  // output correct number
  cout << output << endl;
}
