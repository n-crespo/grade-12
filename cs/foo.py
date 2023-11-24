def fib(n):
    if n == 0:
        return 0
    elif n == 1:
        return 1
    else:
        return fib(n - 1) + fib(n - 2)


n = int(input("Enter the number of terms: "))
for i in range(n):
    print(fib(i), end=" ")


def factorial(n):
    if n == 0:
        return 1
    else:
        return n * factorial(n - 1)


n = int(input("Enter the number: "))
print(f"Factorial of {n} is {factorial(n)}")
