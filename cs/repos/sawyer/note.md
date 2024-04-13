# Questions

1. What do these lines mean?

```cpp
const int C1 = A0; // <--- that is not an int bruh
const int T1 = A3;
```

2. What is `Serial` and how does it work? (Assuming it is related to the library
   used to interact with the Arduino board)(A good answer to this question would
   be very helpful for recreating the same functionality in python)

Example functions:

```cpp
  Serial.flush();

  Serial.begin(9600); // initialize serial communications at 9600 bps:

  Serial.println("Setting Up.");

  Serial.read();

  Serial.available();
```

3. What do the following functions do? (`millis()`, `delay()`, and `analogRead()`)

```cpp
  etime = millis();

  // probably safe to assume this just waits 1000 milliseconds or something but still
  delay(1000);

  anaCounts = anaCounts + analogRead(pTPin);
```

# Other Notes

In these translated files, all of the instances of the above questions must be
edited and corrected, and all comments must be reviewed.
