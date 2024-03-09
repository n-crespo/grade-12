lst = []
inp = input()
while inp != "x":
    lst.append(inp)
    inp = input()

words = []
nums = []

for sublist in lst:
    for item in sublist.strip():
        try:
            item = int(item)
            nums.append(item)
        except ValueError:
            if item != " ":
                words.append(item)

    words = set(words)

    nums = set(nums)

    for w in words:
        print(w, end=" ")

    for n in nums:
        print(n, end=" ")

    nums = []
    words = []


# i = len(lst)
# sorted = []
# unique = False

# while i > 0:
#     checking = lst[0]
#     for item in lst:
#         if item == checking:
#             unique = False
#         if unique:
#             try:
#                 item = int(item)
#                 sorted.append(item)
#             except ValueError:
#                 sorted.append(item)

# print()
# for item in sorted:
#     print(item)
