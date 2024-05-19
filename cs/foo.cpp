#include <cstdlib>
#include <ctime>
#include <fstream>
#include <iomanip>
#include <iostream>

using namespace std;

class ATM {
protected:
  int AccNo;
  double Balance;

public:
  ATM() {}

  ~ATM() { cout << "welgo" << endl; }

  void deposit(double amt) {
    Balance += amt;
    cout << "Deposited: $" << amt << endl;
    cout << "Balance: $" << Balance << endl;
  }

  void withdraw(double amt) {
    if (amt <= Balance) {
      Balance -= amt;
      cout << "Withdrawn: $" << amt << endl;
      cout << "Balance: $" << Balance << endl;
    } else {
      cout << "Insufficient funds." << endl;
    }
  }

  double balance_inquiry() { return Balance; }

  void set_account_num(int a) { AccNo = a; }
  double get_account_num() { return AccNo; }

  void set_balance(double b) { Balance = b; }

  double get_balance() { return Balance; }
};

class CheckingAccount : public ATM {
public:
  CheckingAccount() : ATM() {
    cout << "You have one checking account..." << endl;
  }
  ~CheckingAccount() {
    cout << "Signing out from your checking account..." << endl;
  }
};

class SavingsAccount : public ATM {
public:
  SavingsAccount() : ATM() {
    cout << "You have one Savings account..." << endl;
  }
  ~SavingsAccount() {
    cout << "Signing out from your Savings account..." << endl;
  }

  void GainLoss() {
    int percentage = (rand() % 21) - 10;
    double gainLossAmount = Balance * percentage / 100.0;
    Balance += gainLossAmount;
    cout << "Resulting change to account due to Gain/Loss: $" << gainLossAmount
         << endl;
  }
};

class User {
private:
  int pin;
  int UserID;
  CheckingAccount CheckingAcc;
  SavingsAccount SavingsAcc;

public:
  User() {}

  CheckingAccount &getChecking() { // return a reference
    return CheckingAcc;
  }
  SavingsAccount &getSaving() { return SavingsAcc; }

  int getPin() { return pin; }
  int getUserID() { return UserID; }

  void setPin(int p) { pin = p; }
  void setUserID(int id) { UserID = id; }
  void setChecking(int number, double amount) {
    CheckingAcc.set_account_num(number);
    CheckingAcc.set_balance(amount);
  }

  void setSaving(int number, double amount) {
    SavingsAcc.set_account_num(number);
    SavingsAcc.set_balance(amount);
  }

  void setUser(int id, int p, int checking_number, double checking_balance,
               int saving_number, double saving_balance) {
    setPin(p);
    setUserID(id);
    setChecking(checking_number, checking_balance);
    setSaving(saving_number, saving_balance);
  }
};

void ProcessChecking(User &user) {
  bool continue_transaction = true;
  double amt;
  int choice;

  while (continue_transaction) {
    cout << "\nChecking Account Transactions\n";
    cout
        << "1. Deposit Money\n2. Withdraw Money\n3. Balance Inquiry\n0. Exit\n";
    cout << "Choose an option: ";
    cin >> choice;

    switch (choice) {
    case 1:
      cout << "Enter amount to be deposited: $";
      cin >> amt;
      user.getChecking().deposit(amt);
      break;
    case 2:
      cout << "Enter amount to be withdrawn: $";
      cin >> amt;
      user.getChecking().withdraw(amt);
      break;
    case 3:
      cout << "Current Balance: $" << user.getChecking().get_balance() << endl;
      break;
    case 0:
      cout << "Exiting Checking Account Transactions." << endl;
      continue_transaction = false;
      break;
    default:
      cout << "Invalid choice." << endl;
    }
  }
}

void ProcessSavings(User &user) { // pass by reference
  bool continue_transaction = true;
  double amt;
  int choice;

  while (continue_transaction) {
    cout << "\nSavings Account Transactions\n";
    cout << "1. Deposit Money\n2. Withdraw Money\n3. Balance Inquiry\n4. Apply "
            "Gain/Loss\n0. Exit\n";
    cout << "Choose an option: ";
    cin >> choice;

    switch (choice) {
    case 1:
      cout << "Enter amount to be deposited: $";
      cin >> amt;
      user.getSaving().deposit(amt);
      break;
    case 2:
      cout << "Enter amount to be withdrawn: $";
      cin >> amt;
      user.getSaving().withdraw(amt);
      break;
    case 3:
      cout << "Current Balance: $" << user.getSaving().get_balance() << endl;
      break;
    case 4:
      user.getSaving().GainLoss();
      break;
    case 0:
      cout << "Exiting Savings Account Transactions." << endl;
      continue_transaction = false;
      break;
    default:
      cout << "Invalid choice." << endl;
    }
  }
}

void DoTransactions(User &user) {
  int accountChoice;

  while (true) {
    cout << "Welcome to the Bank!" << endl;
    cout << "Select Account for Transaction:\n1. Checking Account\n2. Savings "
            "Account\n0. Quit\n";
    cout << "Choice: ";
    cin >> accountChoice;
    if (accountChoice == 0)
      break;
    if (accountChoice == 1)
      ProcessChecking(user);
    else if (accountChoice == 2)
      ProcessSavings(user);
    else {
      cout << "Invalid account selection, please enter a valid selection"
           << endl;
    }
  }
}

void ReadUserData(User users[], int size) {
  ifstream inFile("accounts.txt", ios::in);
  if (!inFile) {
    cout << "Error: Unable to open file for reading." << endl;
    return;
  }

  double user_id, pin, checking_number, checking_balance, savings_number,
      savings_balance;
  for (int i = 0;
       i < size && inFile >> user_id >> pin >> checking_number >>
                       checking_balance >> savings_number >> savings_balance;
       ++i) {
    users[i].UserID = user_id;
    users[i].pin = pin;
    users[i].getChecking().set_account_num(checking_number);
    users[i].getChecking().set_balance(checking_balance);
    users[i].getSaving().set_account_num(savings_number);
    users[i].getSaving().set_balance(savings_balance);
  }

  inFile.close();
}

int CheckUser(int user_id, int user_pin, User users[], int size) {
  for (int i = 0; i < size; i++) {
    if (users[i].getUserID() == user_id && users[i].getPin() == user_pin) {
      return i;
    }
  }
  return -1;
}

void WriteUserData(User users[], int size) {
  ofstream outFile("accounts.txt", ios::out);
  if (!outFile) {
    cout << "Error: Unable to open file for writing." << endl;
    return;
  }

  for (int i = 0; i < size; ++i) {
    outFile << users[i].getUserID() << " " << users[i].getPin() << " "
            << users[i].getChecking().get_account_num() << " "
            << users[i].getChecking().get_balance() << " "
            << users[i].getSaving().get_account_num() << " "
            << users[i].getSaving().get_balance() << endl;
  }

  outFile.close();
}

int main() {
  srand(time(0));
  int size = 10;

  User users[size];

  ReadUserData(users, size);

  int currentUserIndex = -1;

  while (currentUserIndex == -1) {
    int user_id, user_pin;
    cout << "Enter Your UserID: ";
    cin >> user_id;
    cout << "Enter Your Pin: ";
    cin >> user_pin;

    currentUserIndex = CheckUser(user_id, user_pin, users, size);

    if (currentUserIndex == -1) {
      cout << "Invalid UserID or PIN. Please try again." << endl;
    }
  }

  DoTransactions(users[currentUserIndex]);

  WriteUserData(users, size);

  return 0;
}
