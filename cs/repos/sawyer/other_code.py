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
