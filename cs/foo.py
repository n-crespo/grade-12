import numpy as np

# Define the matrix of coefficients
coeff_matrix = np.array([
    [1, 1, 1, 0, 0, 0],
    [4, 1, 1, 0, 0, 0],
    [1, 3, 1, 0, 0, 0],
    [0, 0, 0, 1, 1, 1],
    [0, 0, 0, 4, 1, 1],
    [0, 0, 0, 1, 3, 1]
])

# Define the vector of known values
known_values = np.array([2, 5, 2, 3, 3, 6])

# Solve the system of equations
transformation_params = np.linalg.solve(coeff_matrix, known_values)
a, b, t_x, c, d, t_y = transformation_params
print(transformation_params)
