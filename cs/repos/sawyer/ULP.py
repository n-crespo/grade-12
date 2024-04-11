class ULP:
    def __init__(self, a, b, c):
        self._pCPin = 0.0  # pin numbers
        self._pTPin = 0.0  # pin numbers

        # temp sensor settings
        self._pHtemp = 0.0
        self._pLtemp = 0.0  # temps for cal of temp sensor
        self._pHvolt = 0.0  # volts for cal of temp sensor
        self._pLvolt = 0.0  # volts for cal of temp sensor

        # // gas sensor settings
        # float pSf;         // initializers for sensor
        # float pVcc = 5.0;  // analog read reference voltage, usually 5 V for Uno
        # float pVsup = 3.3; // voltage supplied to ULP, !!!! max 3.3 V !!!!
        # float pVref_set;   // initially set to pVref, then reset to include V of open
        #                    // circuit voltage during OCzero()
        # float pVref; // vref is voltage divider, this is set ideally voltage with no
        #              // current through circuit (electronic zero)
        # float pInA;  // the last calculated value of current for the sensor
        # float pVgas; // the last measured value of voltage for the sensor
        # float pT;    // the last calculated value of temperature in degrees C
        # float pX;    // the last calculated value of concentration in ppb
        #
        # // temperature sensor settings
        # float pTb; // temperature sensor coef
        # float pTs; // temperature sensor coef
        #
        # // temperature correction coefficient
        # float pTc;    // sensitivity coeficient
        # float pn;     // exponential correction to baseline
        # float pIzero; // exponential coeficeient to correction to baseline reset
        #               // during zero()
        # float pTzero; // exponential zero temperature factor
        #
        # float pGain; // gain of trans impedance amplifier (TIA)

        # gas sensor settings
        self.pSf = 0.0  # initializers for sensor
        self.pVcc = 5.0  # analog read reference voltage, usually 5.0 V for Uno
        self.pVsup = 3.3  # voltage supplied to ULP, !!! max 3.3 V !!!
        self.pVref_set = 0.0
        self.pVref = 0.0
        self.pInA = 0.0
        self.pVgas = 0.0
        self.pT = 0.0
        self.pX = 0.0
        self.pTb = 0.0
        self.pTs = 0.0
        self.pTc = 0.0
        self.pn = 0.0
        self.pIzero = 0.0
        self.pTzero = 0.0
        self.pGain = 0.0

    def convertT(self, U="C"):
        pass

    def convertX(self, U="B"):
        pass

    def expI(self, T):
        pass

    def getTemp(self, n):
        pass

    def getConc(self, t=20.0):
        pass

    def setVref(self, b, R2):
        pass

    def zero(self):
        pass

    def OCzero(self, n=10):
        pass

    def getIgas(self, n):
        pass

    def setXSpan(self):
        pass

    def setTSpan(self, t, R):
        pass


class SPEC(ULP):
    def __init__(self, a, b, c=1.0):
        super().__init__(a, b, c)


class SO2(ULP):
    def __init__(self, a, b, c=14.6):
        super().__init__(a, b, c)


"""##program"""

from math import exp
import time
from ULP import ULP, SPEC, SO2


def current_milli_time():
    return round(time.time() * 1000)


class ULP:
    def __init__(self, a, b, c):
        self.pCPin = a
        self.pTPin = b
        self.pSf = c
        self.pTzero = 20.0
        self.pIzero = 0.0
        self.pHtemp = 40.0
        self.pLtemp = 20.0
        self.pTb = 18.0
        self.pTs = 87.0
        self.pHvolt = (self.pHtemp + self.pTb) * self.pVsup / self.pTs
        self.pLvolt = (self.pLtemp + self.pTb) * self.pVsup / self.pTs

    def getTemp(self, n):
        etime, i = 0, 0
        anaCounts = 0
        etime = current_milli_time() + n * 1000
        while current_milli_time() < etime:
            anaCounts += analogRead(self.pTPin)
            time.sleep(1)
            i += 1
        Cnts = float(anaCounts) / float(i)
        Volts = Cnts * self.pVcc / 1024.0
        self.pT = (self.pTs / self.pVsup) * Volts - self.pTb

    def convertT(self, U):
        if U == "F":
            TempF = self.pT * 9 / 5 + 32
            return TempF
        elif U == "C":
            return self.pT
        else:
            return 0

    def convertX(self, U):
        if U == "B":
            return self.pX
        elif U == "M":
            return self.pX / 1000.0
        else:
            return 0

    def setTSpan(self, t, R):
        print("Old temp. span and offset: ", self.pTs, ", ", self.pTb)
        etime, i, n = 0, 0, 10
        anaCounts = 0
        etime = current_milli_time() + n * 1000
        while current_milli_time() < etime:
            anaCounts += analogRead(self.pTPin)
            time.sleep(1)
            i += 1
        Cnts = float(anaCounts) / float(i)
        Volts = Cnts * self.pVcc / 1024
        if R == "HIGH":
            self.pHtemp = t
            self.pHvolt = Volts
        elif R == "LOW":
            self.pLtemp = t
            self.pLvolt = Volts
        self.pTs = (
            self.pVsup * (self.pHtemp - self.pLtemp) / (self.pHvolt - self.pLvolt)
        )
        self.pTb = (
            self.pLvolt * (self.pHtemp - self.pLtemp) / (self.pHvolt - self.pLvolt)
            - self.pLtemp
        )
        print("New temp. span and offset: ", self.pTs, ", ", self.pTb)

    def setVref(self, b, R2):
        if b >= 0:
            self.pVref = self.pVsup * float(R2 + 1000000) / float(R2 + 2000000) * 1000.0
        else:
            self.pVref = self.pVsup * float(1000000) / float(R2 + 2000000) * 1000.0
        self.pVref_set = self.pVref

    def OCzero(self, n):
        etime, i = 0, 0
        anaCounts = 0
        print("Send any character when sensor is removed.")
        while Serial.available() <= 0:
            pass
        print("Zeroing")
        Serial.flush()
        etime = current_milli_time() + n * 1000
        while current_milli_time() < etime:
            anaCounts += analogRead(self.pCPin)
            time.sleep(1)
            i += 1
        Cnts = float(anaCounts) / float(i)
        self.pVref_set = Cnts * self.pVcc * 1000.0 / 1024.0
        print(abs(self.pVref - self.pVref_set))
        if abs(self.pVref - self.pVref_set) > 50:
            return False
        else:
            return True

    def zero(self):
        self.pIzero = self.pInA
        self.pTzero = self.pT

    def getIgas(self, n):
        etime, i = 0, 0
        anaCounts = 0
        etime = current_milli_time() + n * 1000
        while current_milli_time() < etime:
            anaCounts += analogRead(self.pCPin)
            time.sleep(1)
            i += 1
        Cnts = float(anaCounts) / float(i)
        self.pVgas = Cnts * self.pVcc * 1000.0 / 1024.0
        self.pInA = (self.pVgas - self.pVref_set) / self.pGain * 1000.0

    def expI(self, T):
        return exp(T / self.pn)

    def getConc(self, t):
        nA = self.pInA - self.pIzero * expI(t - self.pTzero)
        Sens = self.pSf * (1.0 + self.pTc * (t - 20.0))
        self.pX = nA / Sens * 1000.0


def setXSpan(self):
    Serial.setTimeout(10000)
    X = 0.0
    nA = 0.0
    Sf = 0.0
    print(
        "When gas concentration steady, enter Concentration in ppm followed by 'cr' = ",
        end="",
    )
    print(X)
    getIgas(10)
    Sf = pInA() / X
    if abs(Sf - pSf) * 2 / (Sf + pSf) < 0.1:
        pSf = Sf
    else:
        print("Error Setting Span")


class SO2(ULP):
    def __init__(self, a, b, c):
        super().__init__(a, b, c=14.6)
        self.setVref(+200, 143000)
        self.pGain = 100.0
        self.pn = 10.26
        self.pTc = -0.026


class SPEC(ULP):
    def __init__(self, a, b, c):
        super().__init__(a, b, c=1.0)


"""#Final Code

No class def - in python can be included in original program

##.py file
"""


"""##python translation of ino file"""


"""#full pi code

##Sensor lib
"""


"""##Full file"""
