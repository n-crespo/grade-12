class GeometricShape:
    def __init__(self, col="None"):
        self.__color = col

    def set_color(self, col):
        self.__color = col

    def get_color(self):
        return self.__color


class Circle(GeometricShape):
    def __init__(self, radius, color="None"):
        GeometricShape.__init__(radius, color)
        self.__radius = radius

    def set_radius(self, radius):
        self.__radius = radius

    def get_radius(self):
        return self.__radius

    def area(self):
        return 3.14159 * self.__radius**2

    def perimeter(self):
        return 2 * 3.14159 * self.__radius


class Rectangle(GeometricShape):
    def __init__(self, length, width, color="None"):
        super().__init__(color)
        self.__length = length
        self.__width = width

    def set_length(self, length):
        self.__length = length

    def set_width(self, width):
        self.__width = width

    def get_length(self):
        return self.__length

    def get_width(self):
        return self.__width

    def area(self):
        return self.__length * self.__width

    def perimeter(self):
        return 2 * (self.__length + self.__width)


if __name__ == "__main__":
    circle = Circle(5, "Red")
    rectangle = Rectangle(4, 6, "Blue")

    print(
        f"Circle Color: {circle.get_color()}, Area: {circle.area()}, Perimeter: {circle.perimeter()}"
    )
    print(
        f"Rectangle Color: {rectangle.get_color()}, Area: {rectangle.area()}, Perimeter: {rectangle.perimeter()}"
    )
