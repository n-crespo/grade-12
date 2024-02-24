lst = []
inp = input()
while inp != "x":
    inp = inp.split()
    for x in inp:
        lst.append(x)
    inp = input()

i = len(lst)
sorted = []

# this is so weird
for thing in lst:
    lst[lst.index(thing)] = float(thing)

while i > 0:
    max = lst[0]
    for item in lst:
        if item > max:
            max = item
    sorted.append(max)
    lst.remove(max)
    i -= 1

print()
for item in sorted:
    if item % 1 == 0:
        item = int(item)
    print(item)
