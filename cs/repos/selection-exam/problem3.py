lst = []
inp = input()
while inp != "0":
    inp = inp.split()
    for x in inp:
        lst.append(x)
    inp = input()

i = len(lst)
sorted = []

while i > 0:
    max_len = len(lst[0])
    to_remove = lst[0]
    for item in lst:
        if len(item) < max_len:
            max_len = len(item)
            to_remove = item
    sorted.append(to_remove)
    lst.remove(to_remove)
    i -= 1

print()
for item in sorted:
    print(item)
