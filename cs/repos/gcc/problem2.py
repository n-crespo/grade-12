# test case 1
# grid = [[0, 0, 0], [0, 1, 0], [0, 0, 0]]

# test case 2
# grid = [[0, 1], [0, 0]]

# test case 3
grid = [[0, 0, 1], [1, 0, 0], [0, 0, 0]]


paths = 0


def findpath(x=0, y=0):
    global paths

    if x == len(grid[0]) - 1 and y == len(grid) - 1:
        paths += 1
        return

    try:
        if grid[x + 1][y] == 0:
            findpath(x + 1, y)
    except:
        pass

    try:
        if grid[x][y + 1] == 0:
            findpath(x, y + 1)
    except:
        pass


findpath()
print(paths)
