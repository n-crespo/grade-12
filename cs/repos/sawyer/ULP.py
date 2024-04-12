import math


class ULP:
    def __init__(self, a, b, c):

        # NOTE: these are supposed to be private
        self.pCPin = 0.0  # pin numbers
        self.pTPin = 0.0  # pin numbers
        # temp sensor settings
        self.pHtemp = 40.0
        self.pLtemp = 20.0  # temps for cal of temp sensor
        self.pHvolt = (self.pHtemp + self.pTb) * self.pVsup / self.pTs # # volts for cal of temp sensor
        self.pHvolt = (self.pLtemp + self.pTb) * self.pVsup / self.pTs # # volts for cal of temp sensor

        # float ULP::pVcc = 5.0;
        # float ULP::pVsup = 3.3;

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
        self.pTb = 18.0
        self.pTs = 87.0
        self.pTc = 0.0
        self.pn = 0.0
        self.pTzero = 20.0
        self.pIzero = 0.0
        self.pGain = 0.0

    # convert to fahrenheit or celsius
    def convertT(self, U="C"):
        if U == "F":
            tempF = self.pT * 9 / 5 + 32
            return tempF
        elif U == "C":
            return self.pT
        else:
            return 0

    # output X in ppm or ppb
    def convertX(self, U="B"):
        if U == "P":
            return self.pX
        elif U == "M":
            return self.pX * 1000
        else:
            return 0

    # returns e^(input)
    def expI(self, T):
        return math.exp(T / self.pn)

    ## NOTE: We were here (with sawyer)

    # def getTemp(self, n):

    # etime = 0
    # i = 0
    # anaCounts = 0
    # etime = millis() + n * 1000 # BUG: millis() is an Arduino thing

    # makeshift do while loop

    # anaCounts += analogRead(self._pTPin)  # BUG: analogRead() is an Arduino thing
    # delay(1) # BUG: delay() is an Arduino thing
    # i += 1
    # while millis() < etime:
    #     etime = millis() + n * 1000
    #     anaCounts += analogRead(self._pTPin)
    #     delay(1)
    #     i += 1

    # Cnts = float(anaCounts) / float(i)
    # Volts = Cnts * self.pVcc / 1024.0
    # self.pt = (self.pTs / self.pVsup) * Volts - self.pTb

    def getConc(self, t=20.0):
        nA = self.pInA - self.pIzero * self.expI(t - self.pTzero)
        Sens = self.pSf * (1.0 + self.pTc * (t-20.0))
        self.pX = nA / Sens * 1000.0 # output in ppb

    def setVref(self, b, R2):
        if b >= 0:
            self.pVref = self.pVsup * float(R2 + 1000000) / float(R2 + 2000000) * 1000.0;
        else:
            self.pVref = self.pVsup * float(1000000) / float(R2 + 2000000) * 1000.0;
        self.pVref_set = self.pVref;

    def zero(self):
        self.pIzero = self.pInA
        self.pTzero = self.pT

    def OCzero(self, n=10):
        etime = 0
        i = 0
        anaCounts = 0;

            #  BUG: Serial is an Arduino thing (below)

        # Serial.println("Send any character when sensor is removed.");
        # while (Serial.available() <= 0):
        #     Serial.println("Zeroing");
        #     Serial.flush();
        #     etime = millis() + n * 1000;

        # This is another makeshift do-while loop

        # anaCounts = anaCounts + analogRead(pCPin)
        # delay(1)
        # i+=1
        # while (millis() < etime):
            # anaCounts = anaCounts + analogRead(pCPin)
            # delay(1)
            # i+=1

        Cnts = float(anaCounts) / float(i);
        self.pVref_set = Cnts * self.pVcc * 1000.0 / 1024.0; # in mV
        # Serial.println(abs(pVref - pVref_set));

        if (abs(self.pVref - self.pVref_set) > 50):
            return False;
        else:
            return True;

    def getIgas(self, n):
        etime = 0
        i = 0
        anaCounts = 0
        # etime = millis() + n * 1000

        # do-while loop

        # anaCounts = anaCounts + analogRead(self._pTPin)
        # delay(1)
        # i += 1
        # while (millis() < etime):
        #   anaCounts = anaCounts + analogRead(self._pTPin)
        #   delay(1)
        #   i += 1

        Cnts = float(anaCounts) / float(i)
        self.pVgas = Cnts * self.pVcc * 1000.0 / 1024.0 # in mV
        self.pInA = (self.pVgas - self.pVref_set) / self.pGain * 1000.0 # in nA


    def setXSpan(self):
        # Serial.setTimeout(10000)
        X = 0;
        nA, Sf = 0, 0 # NOTE: nA is never used??? (python)

        # Serial.print("When gas concentration steady, enter Concentration in ppm "
        #             "followed by 'cr' = ")
        # while (Serial.available() <= 0):
        #     X = Serial.parseFloat()
        #     Serial.println(X)
        #     getIgas(10)

        Sf = self.pInA / X;
        if (abs(Sf - self.pSf) * 2 / (Sf + self.pSf) < .1):
            self.pSf = Sf
        else:
            # Serial.println("Error Setting Span");

    def setTSpan(self, t, R):
        # Serial.print("Old temp. span and offset: ");
        # Serial.print(self.pTs);
        # Serial.print(", ");
        # Serial.println(self.pTb);
        etime, i = 0, 0
        n = 10
        anaCounts = 0
        # etime = millis() + n * 1000; # what is millis()

        # this is a do while loop
        # anaCounts = anaCounts + analogRead(self.pTPin);
        # delay(1)
        # i+=1
        # while millis() < etime:
        #     anaCounts = anaCounts + analogRead(self.pTPin)
        #     delay(1)
        #     i+=1

        Cnts = float(anaCounts) / float(i)
        Volts = Cnts * self.pVcc / 1024

        if R == "HIGH":
            self.pHtemp = t
            self.pHvolt = Volts
        elif R == "LOW":
            self.pLtemp = t
            self.pLvolt = Volts

        self.pTs = self.pVsup * (self.pHtemp - self.pLtemp) / (self.pHvolt - self.pLvolt)
        self.pTb = self.pLvolt * (self.pHtemp - self.pLtemp) / (self.pHvolt - self.pLvolt) - self.pLtemp
        # Serial.print("New temp. span and offset: ")
        # Serial.print(self.pTs)
        # Serial.print(", ")
        # Serial.println(self.pTb)

        # NOTE: current progress here

class EtOH(ULP):
    def __init__(self, a, b, c=194.0):
        super().__init__(a, b, c)
        self.setVref(+100, 69800)
        self.pGain = 249.0
        self.pn = 1
        self.pTc = 0.01

class H2S(ULP):
    def __init__(self, a, b, c=194.0):
        super().__init__(a, b, c)
        self.setVref(+3, 2000)
        self.pGain = 49.9
        self.pn = -300.0
        self.pTc = 0.007


class CO(ULP):
    def __init__(self, a, b, c=2.44):
        super().__init__(a, b, c)
        self.setVref(+3, 2000)
        self.pGain = 100.0
        self.pn = 13.6
        self.pTc = 0.007


class IAQ(ULP):
    def __init__(self, a, b, c = 150.0):
        super().__init__(a, b, c)
        self.setVref(+150, 105000)
        self.pGain = 100.0
        self.pn = 1
        self.pTc = 0.01


class SO2(ULP):
    def __init__(self, a, b, c=14.6):
        super().__init__(a, b, c)
        self.setVref(+200, 143000)
        self.pGain = 100.0
        self.pn = 10.26
        self.pTc = -0.026

class NO2(ULP):
    def __init__(self, a, b, c=-25.0):
        super().__init__(a, b, c)
        self.setVref(-25, 16200)
        self.pGain = 499.0
        self.pn = 109.6
        self.pTc = 0.005

class RESP(ULP):
    def __init__(self, a, b, c=-21.5):
        super().__init__(a, b, c)
        self.setVref(-200, 143000)
        self.pGain = 499.0
        self.pn = 1
        self.pTc = 0.00

class O3(ULP):
    def __init__(self, a, b, c=-20.0):
        super().__init__(a, b, c)
        self.setVref(-25, 16200)
        self.pGain = 499.0
        self.pn = 109.6
        self.pTc = -0.005

class SPEC(ULP):
    def __init__(self, a, b, c=1.0):
        super().__init__(a, b, c)

