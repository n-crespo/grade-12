#include <cstdlib>
#include <ctime>
// #include <fstream>
// #include <iomanip>
#include <iostream>

using namespace std;

class AccATM {
protected:
  int AccountNo;
  double Balance;

public:
  AccATM() {}

  ~AccATM() { cout << "welgo" << endl; }

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

  double balanceInq() { return Balance; }
  void setAccNum(int a) { AccountNo = a; }
  int getAccNum() { return AccountNo; }
  void setBal(double b) { Balance = b; }
  double getBal() { return Balance; }
};

class CheckingAccount : public AccATM {
public:
  CheckingAccount() : AccATM() {
    cout << "Creating a checking account..." << endl;
  }
  ~CheckingAccount() { cout << "Signing out from checking account..." << endl; }
};

class SavingsAccount : public AccATM {
public:
  SavingsAccount() : AccATM() {
    cout << "Creating a Savings account..." << endl;
  }
  ~SavingsAccount() { cout << "Signing out from Savings account..." << endl; }
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
  CheckingAccount &getChecking() { return CheckingAcc; }
  SavingsAccount &getSaving() { return SavingsAcc; }

  int getPin() const { return pin; }
  int getUserID() const { return UserID; }

  void setPin(int p) { pin = p; }
  void setUserID(int id) { UserID = id; }
  void setChecking(int number, double amount) {
    CheckingAcc.setAccNum(number);
    CheckingAcc.setBal(amount);
  }

  void setSaving(int number, double amount) {
    SavingsAcc.setAccNum(number);
    SavingsAcc.setBal(amount);
  }

  void setUser(int id, int p, int checkingNumber, double checkingBalance,
               int savingsNumber, double savingsBalance) {
    setPin(p);
    setUserID(id);
    setChecking(checkingNumber, checkingBalance);
    setSaving(savingsNumber, savingsBalance);
  }
};

void ProcessChecking(User &user) {
  bool contTransaction = true;
  double amt;
  int choice;

  while (contTransaction) {
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
      cout << "Current Balance: $" << user.getChecking().getBal() << endl;
      users[i].setUserID(user_id);
      users[i].setPin(pin);
      users[i].getChecking().setAccNum(checkingNumber);
      users[i].getChecking().setBal(checkingBalance);
      users[i].getSaving().setAccNum(savings_number);
      users[i].getSaving().setBal(savings_balance);
    }

    inFile.close();
  }

  int CheckUser(int user_id, int user_pin, User users[]) {
    for (int i = 0; i < 10; i++) {
      if (users[i].getUserID() == user_id && users[i].getPin() == user_pin) {
        return i;
      }
    }
    return -1;
  }

  void WriteData(User users[]) {
    ofstream outFile("accounts.txt", ios::out);
    if (!outFile) {
      cout << "Error: Unable to open file for writing." << endl;
      return;
    }
    for (int i = 0; i < 10; ++i) {
      outFile << users[i].getUserID() << " " << users[i].getPin() << " "
              << users[i].getChecking().getAccNum() << " "
              << users[i].getChecking().getBal() << " "
              << users[i].getSaving().getAccNum() << " "
              << users[i].getSaving().getBal() << endl;
    }
    outFile.close();
  }

  int main() {
    srand(time(0));
    User users[10];
    ReadData(users);

    int currentUserIndex = -1;
    while (currentUserIndex == -1) {
      int user_id, user_pin;
      cout << "Enter Your UserID: ";
      cin >> user_id;
      cout << "Enter Your Pin: ";
      cin >> user_pin;

      currentUserIndex = CheckUser(user_id, user_pin, users);

      if (currentUserIndex == -1) {
        cout << "Invalid UserID or PIN. Please try again." << endl;
      }
    }
    DoTrans(users[currentUserIndex]);
    WriteData(users);

    return 0;
  }
