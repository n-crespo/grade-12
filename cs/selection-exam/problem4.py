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

    print("nums ", nums)
    print("words", words)

    for word in words:
        checking = word
        print("checking: ", checking)
        for thing in words:
            print(
                f"{checking}  == {thing} is {checking == thing}, and words is {words.index(checking)} and thing is {words.index(thing)}"
            )
            if (thing == checking) and (words.index(checking) != temp.index(thing)):
                print(f"removing {thing}")
                words.remove(thing)
                break

    for w in words:
        print(w, end=" ")

    # print("")
    # for num in nums:
    #     checking = num
    #     for thing in nums:
    #         if (thing == checking) and (words.index(checking) != words.index(thing)):
    #             nums.remove(thing)
    #             continue

    # for n in nums:
    #     print(n, end=" ")

    # print("")

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
