# C++ File I/O 1

## Description
These two C++ files, named task1.cpp and task2.cpp can do the following things (respectively):

1) Task 1 parses employeeDataInput.txt which contains the below information. Each line contains a first name, last name, salary, and raise percentage separated by a space. The program will take each line and copy them into a new file called output.txt which updates each salary to account for the raise. 

  ``` 
  Tyler Asmussen 65789.87 5
  Connor Carpenter 75892.56 6
  Sladjana Suzic 74900.50 6.1
```
2) This program accepts the input of a first and last name, and five test scores. It then will print to the terminal and to a new text file called text.txt the first and last name and the average of all five test scores. 

## Usage
> This assumes the user knows how to execute and run c++ files. 

To run task1 and task2, simply compile them and run the compiled files. 

## Sample output

### Task 1 
```
Tyler Asmussen 69079.36
Connor Carpenter 80446.11
Sladjana Suzic 79469.43
```
Note: Used below formula

$$ newSalary = salary * ((raise * 0.01) + 1) $$
### Task 2
```
Name: a s
1.00
2.00
3.00
4.00
5.00
Average = 3.00
```
Note: Used below formula

$$ 
  averageScore =
      (firstScore + secondScore + thirdScore + fourthScore + fifthScore) / 5 $$
