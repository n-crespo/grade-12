class Vehicle:
    def __init__(self, make, model, fuel_capacity):
        self.make = make
        self.model = model
        self.fuel_capacity = fuel_capacity

    def set_make(self, make):
        self.make = make

    def set_model(self, model):
        self.model = model

    def set_fuel_capacity(self, fuel_capacity):
        self.fuel_capacity = fuel_capacity

    def get_make(self):
        return self.make

    def get_model(self):
        return self.model

    def get_fuel_capacity(self):
        return self.fuel_capacity


class Car(Vehicle):
    def __init__(
        self, make, model, fuel_capacity, number_of_seats, has_sunroof, trunk_capacity
    ):
        super().__init__(make, model, fuel_capacity)
        self.number_of_seats = number_of_seats
        self.has_sunroof = has_sunroof
        self.trunk_capacity = trunk_capacity

    def calculate_fuel_efficiency(self):
        return (self.fuel_capacity / self.number_of_seats) * 10


class Motorcycle(Vehicle):
    def __init__(
        self, make, model, fuel_capacity, engine_displacement, has_sidecar, tire_width
    ):
        super().__init__(make, model, fuel_capacity)
        self.engine_displacement = engine_displacement
        self.has_sidecar = has_sidecar
        self.tire_width = tire_width

    def calculate_fuel_efficiency(self):
        return (self.fuel_capacity / self.engine_displacement) * 100


if __name__ == "__main__":
    car = Car("Toyota", "Camry", 60, 5, True, 450)
    motorcycle = Motorcycle("Harley-Davidson", "Street Glide", 22.7, 1745, False, 180)

    print(
        f"Car Make: {car.get_make()}, Model: {car.get_model()}, Fuel Efficiency: {car.calculate_fuel_efficiency()} L/seat*10"
    )
    print(
        f"Motorcycle Make: {motorcycle.get_make()}, Model: {motorcycle.get_model()}, Fuel Efficiency: {motorcycle.calculate_fuel_efficiency()} L/100cc"
    )
