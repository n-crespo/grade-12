import numpy as np

# Define the matrix of coefficients for X coordinates
coeff_matrix_x = np.array([
    [1, 1, 1],
    [4, 1, 1],
    [1, 3, 1]
])

# Define the vector of known values for X coordinates
known_values_x = np.array([2, 5, 2])

# Solve the system of equations for X coordinates
transformation_params_x = np.linalg.solve(coeff_matrix_x, known_values_x)
a, b, t_x = transformation_params_x

# Define the matrix of coefficients for Y coordinates
coeff_matrix_y = np.array([
    [1, 1, 1],
    [4, 1, 1],
    [1, 3, 1]
])

# Define the vector of known values for Y coordinates
known_values_y = np.array([3, 3, 6])

# Solve the system of equations for Y coordinates
transformation_params_y = np.linalg.solve(coeff_matrix_y, known_values_y)
c, d, t_y = transformation_params_y

print(transformation_params_x, transformation_params_y)
