#include <cstring>
#include <iostream>

using namespace std;

int main() {
  char s[10] = "hello";
  char t[100] = "nicolas";
  cout << s << endl;

  // cin.getline(c, 10); // for input
  cout << strlen(s) << endl;
  strcat(s, "!!!");
  cout << (strcmp(t, s) > 0) << endl; // this returns a number, <0, 0, >0
  cout << ((strcmp(t, s) > 0) ? "true" : "false");

  return 0;
}
