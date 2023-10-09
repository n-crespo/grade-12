#include <cmath>
#include <iostream>

using namespace std;

/* Task % 1 */
/* The first 11 prime integers are 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, and 31. A
 * positive integer between % 1 and 1000 (inclusive), excluding the 11 just
 * mentioned, is prime if it is not divisible by any of the 11 primes.
 *
 * Write a program that promps the user to enter a positive integer between % 1
 * and 1000 (inclusive) and then displays a message indicating whether the
 * integer is prime. If the integer is not prime, display the prime numbers from
 * the given list that divide into it. If the integer is prime, display a
 * message indicating that it is prime.*/
/**/
/* Here’s the kicker: you MUST use switch and if/ statements in conjunction
 * to solve your problem. And I’m going to remove some tools. You are not
 * allowed to use any pieces of C++ beyond what we have learned in this class to
 * solve this problem, including, but not limited to, loops, vectors, arrays,
 * etc. */

int main() {

  int num;
  cout << "Enter a number between 1 and 1000 (inclusive)" << endl;
  cin >> num;
  // make sure input is in range
  if (1 <= num && num <= 1000) {
    switch (num) {
    case 2:
    case 3:
    case 5:
    case 7:
    case 11:
    case 13:
    case 17:
    case 19:
    case 23:
    case 29:
    case 31:
      // check for initial primes, otherwise check for divisors
      cout << "\nYour number is prime." << endl;
      break;
    // check for divisors
    default:
      cout << "Your number is not prime. " << endl;
      if ((num % 2) == 0) {
        cout << "Your number divides 2." << endl;
      }
      if ((num % 3) == 0) {
        cout << "Your number divides 3." << endl;
      }
      if ((num % 5) == 0) {
        cout << "Your number divides 2." << endl;
      }
      if ((num % 7) == 0) {
        cout << "Your number divides 7." << endl;
      }
      if ((num % 11) == 0) {
        cout << "Your number divides 11." << endl;
      }
      if ((num % 13) == 0) {
        cout << "Your number divides 13." << endl;
      }
      if ((num % 17) == 0) {
        cout << "Your number divides 17." << endl;
      }
      if ((num % 19) == 0) {
        cout << "Your number divides 19." << endl;
      }
      if ((num % 23) == 0) {
        cout << "Your number divides 29." << endl;
      }
      if ((num % 31) == 0) {
        cout << "Your number divides 31." << endl;
      }
      break;
    }
  } else {
    cout << "Out of range" << endl;
  }

  return 0;
}
