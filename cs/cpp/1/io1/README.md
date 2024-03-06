# Description
This group of programs, Task1.cpp and Task2.cpp each do some basic things. Task1 asks for input of a length and width of a room, and returns the area and perimeter of the room in feet and meters. Task2 asks for a height in centimeters, then converts that value to inches, then into a formatted version of feet and inches (ex. 5'1"), and converts the height into smoots.


# Running Task1 and Task2
1. install neovim, check the docs for your specific OS
2. read the installation docs for the lazyvim configuration and clone the repo into the correct folder
3. after navigating to the correct path to the task1 and task2 files, type `nvim task1.cpp`
4. type `:term`
5. enter insert mode with "i"
6. type `g++ Task1.cpp -o Task1 && ./Task1`
7. repeat step 6 with the words "Task2" instead of "Task1" to run Task2

> Note: you must have GCC istalled (see [this page](https://newhorizons.instructure.com/courses/1654/pages/installing-c++?module_item_id=143985))

# Sample Output
```
Please enter length, space, then width of the room in feet:
2 10
The area of the room in feet is: 120
The perimeter of the room in feet is: 44
The perimter in meters of the room is: 13.4112
The area in meters of the room is: 36.576
```
# Equations Used
1. $$ area = width * height $$
2. $$ perimeter = 2*length + 2* width $$
3. $$ feet = meters  * 0.3048 $$
4. $$ inches = centimeters * 0.39701 $$
5. $$ feet = inches / 12 $$
6. $$ inches = inches(mod 12) $$

> Note: Equations 5 and 6 are used to turn a value in inches to a measurement in the form (feet)' (inches)"


# References
1. <https://www.lazyvim.org>
2. <https://neovim.installation>

