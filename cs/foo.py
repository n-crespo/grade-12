P = 5000
r = 0.05
t = 1 / 12

while t <= 6 / 12:
    interest = P * r * t
    print(f"Month: {t*round(12)}")
    print(f"Interest = ${interest}\nTotal = ${interest + P}")
    print()
    P = interest + P
    t += 1 / 12
