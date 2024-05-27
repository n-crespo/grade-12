
class Level_03(Level):
    """Definition for level 3."""

    def __init__(self, player):
        """Create level 3."""

        # Call the parent constructor
        Level.__init__(self, player)

        self.level_limit = -1000

        # width, height, x, y
        platforms = [
            # player can jump about 150 (starts at 580ish at ground level)
            [210, 30, 1000, 430],
            [210, 30, 1300, 280],
            [210, 30, 1600, 130], # 430 is the max that the player can jump
            [150, 30, 1900, 250], # down a lil
            [150, 30, 2100, 100], # higher smaller one
            [150, 30, 2400, 300], # down a lil more
            [150, 30, 2550, 450], # down a lil more
            [500, 30, 2700, 300], # long one (put a wall on top) TODO
            [500, 30, 2900, 200], # duplicate platform above
        ]

        walls = [
            # width, height, x, y
            # w, h,   x,    y
            [30, 125, 1100, 460],
            [30, 275, 1390, 310],
            [205, 435, 1600, 150], # fat one
            [30, 305, 1960, 280],
            [30, 455, 2160, 130], # for higher smaller one
            [30, 100, 2400, 200], # L shape
            [30, 285, 3500, 300], # steps begin
            [30, 235, 3600, 350],
            [30, 185, 3700, 400],
            [30, 135, 3800, 450],
        ]

        # Go through the array above and add platforms
        for platform in platforms:
            block = Platform(platform[0], platform[1])
            block.rect.x = platform[2]
            block.rect.y = platform[3]
            block.player = self.player
            self.platform_list.add(block)

        for wall in walls:
            block = Wall(wall[0], wall[1])
            block.rect.x = wall[2]
            block.rect.y = wall[3]
            block.player = self.player
            self.wall_list.add(block)
