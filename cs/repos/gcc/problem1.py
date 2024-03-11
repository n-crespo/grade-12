# test case 1
difficulties = [
    1,
    2,
    2,
    3,
    5,
    4,
    6,
    7,
    9,
    8,
    10,
    15,
    11,
    11,
    12,
    13,
    15,
    14,
    16,
    17,
    19,
    18,
    20,
    21,
    23,
    22,
    24,
    25,
    27,
    26,
]

# test case 2
difficulties = list(range(27, 0, -1))

# output variables
max = 0
index = 0

# iterate over loop of input
for i in range(len(difficulties) - 1):
    # check change in terrain is greater than current max
    if difficulties[i + 1] - difficulties[i] > max:
        max = difficulties[i + 1] - difficulties[i]
        index = i

# print output
print(tuple([max, index + 1]))
