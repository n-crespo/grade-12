def sieve_of_eratosthenes(limit):
    # Create a boolean list "is_prime[0..n]" and initialize all elements as True
    is_prime = [True] * (limit + 1)
    is_prime[0] = is_prime[1] = False  # 0 and 1 are not prime numbers

    for num in range(2, int(limit**0.5) + 1):
        if is_prime[num]:
            # Mark all multiples of num as non-prime
            for multiple in range(num * num, limit + 1, num):
                is_prime[multiple] = False

    # Return the list of prime numbers
    return [num for num in range(2, limit + 1) if is_prime[num]]


# Example: Finding primes up to 50
primes_up_to_50 = sieve_of_eratosthenes(50)
print(primes_up_to_50)
