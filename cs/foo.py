import itertools

m = int(input())
out = []

n = itertools.combinations_with_replacement([i for i in range(1, 7)], r=2)

for i in n:
    if sum(i) == m and sorted(i) not in out:
        out.append(sorted(i))

for i in out:
    print(i)
