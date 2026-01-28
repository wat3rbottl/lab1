import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class Volvo240Test {
    private Volvo240 volvo;   // open closed principle, om den kan vara private och allt funkar, make it private girl!

    @Before
    public void setUp() {
        volvo = new Volvo240();
        volvo.startEngine();
    }

    @Test
    public void volvoStopEngine() {  // testar om get current speed == 0
        volvo.stopEngine();
        assertEquals(0.0, volvo.getCurrentSpeed(), 0.0001);
    }

    @Test
    public void volvoHasFourDoors() {
        assertEquals(4, volvo.getNrDoors());
    }

    @Test
    public void gasIncreasesSpeed() {
        volvo.startEngine();
        double before = volvo.getCurrentSpeed();

        volvo.gas(0.5);

        assertTrue(volvo.getCurrentSpeed() > before);
    }

    @Test
    public void brakeDecreasesSpeed() {
        volvo.startEngine();
        volvo.gas(1.0);
        double before = volvo.getCurrentSpeed();

        volvo.brake(0.5);

        assertTrue(volvo.getCurrentSpeed() < before);
    }

    @Test
    public void testEnginePower() {
        assertEquals(100, volvo.getEnginePower(), 0.000001);
    }

    @Test
    public void testGetSetColor() {
        volvo.setColor(Color.magenta);
        assertEquals(Color.magenta, volvo.getColor());
    }


    @Test
    public void testGasWithWrongValue() {
        volvo.gas(2);
        assertEquals(0.1, volvo.getCurrentSpeed(), 0.0001);
    }

    @Test
    public void testGasWithRightValue() {
        double speed = volvo.getCurrentSpeed();
        volvo.gas(1);
        assertTrue(speed < volvo.getCurrentSpeed());
    }

    @Test
    public void testCurrentSpeed() {
        for (int i = 0; i < 1000; i++) {
            volvo.gas(1);
        }
       assertEquals(100, volvo.getCurrentSpeed(), 0.0001);
    }

    @Test
    public void testBrakeWithWrongValue() {
        volvo.brake(2);
       assertEquals(0.1, volvo.getCurrentSpeed(), 0.0001);

    }

    @Test
    public void testBrakeWithRightValue() {
        double speed = volvo.getCurrentSpeed();
        volvo.brake(1);
        assertTrue(speed > volvo.getCurrentSpeed());
    }
}
