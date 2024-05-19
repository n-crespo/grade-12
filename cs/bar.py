import numpy as np

# Transformation parameters
a, b, t_x = 1.00000000e+00, 0.00000000e+00, 1.00000000e+00
c, d, t_y = -1.11022302e-16, 1.50000000e+00, 1.50000000e+00

# Define the control points (photo coordinates)
control_points_photo = np.array([
    [1, 1],
    [4, 1],
    [1, 3]
])

# Define the expected map coordinates
control_points_map = np.array([
    [2, 3],
    [5, 3],
    [2, 6]
])

# Apply the transformation to each control point
transformed_points = []
for point in control_points_photo:
    x, y = point
    X = a * x + b * y + t_x
    Y = c * x + d * y + t_y
    transformed_points.append([X, Y])

transformed_points = np.array(transformed_points)

# Print the results
print("Transformed Points:")
print(transformed_points)

# Check if the transformed points match the expected map coordinates
print("Expected Map Coordinates:")
print(control_points_map)

# Compare the results
comparison = np.allclose(transformed_points, control_points_map)
print("Transformation Correct:", comparison)
