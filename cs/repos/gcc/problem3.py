import numpy as np

import sounddevice as sd


sd.default.samplerate = 44100


# list of notes in C major scale
# contains a list of tones to play
notes = []


# step through the C major scale
steps = [0, 2, 4, 5, 7, 9, 11, 12]


# list of times to play each note
rate = 60 / 44100
time = np.arange(22050 * 0.5) / 22050.0


amplitude = 10000
for n in steps:
    frequency = 261.63 * (2 ** (1 / 12)) ** (n)

    note = amplitude * np.sin(2 * np.pi * frequency * time)

    notes.append(note)


for note in notes:
    sd.play(np.array(note), blocking=True)
time = np.arange(22050 * 0.5) / 22050.0

amplitude = 10000

for n in steps:
    frequency = 261.63 * (2 ** (1 / 12)) ** (n)

    note = amplitude * np.sin(2 * np.pi * frequency * time)

    notes.append(note)

for note in notes:
    sd.play(np.array(note), blocking=True)
