import math


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

    # NOTE: Current progress here

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
