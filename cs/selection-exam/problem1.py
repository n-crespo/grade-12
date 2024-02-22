lst = []
inp = input()
while inp != "x":
    lst.append(inp)
    inp = input()

outs = []
done = False

for item in lst:
    item = int(item)
    i = int(item / 2)
    done = False
    if item < 2:
        outs.append("No")
        done = True
    else:
        while not done:
            if i <= 1:
                outs.append("Yes")
                done = True
            elif item % i == 0:
                outs.append("No")
                done = True
            else:
                i -= 1

print()
for out in outs:
    print(out)
