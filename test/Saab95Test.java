import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class Saab95Test {
    private Saab95 saab;  

    @Before
    public void setUp() {
        saab = new Saab95();
        saab.startEngine();
    }

    @Test
    public void saabStopEngine() {  // testar om get current speed == 0
        saab.stopEngine();
        assertEquals(0.0, saab.getCurrentSpeed(), 0.0001);
    }

    @Test
    public void saabHasTwoDoors() {
        assertEquals(2, saab.getNrDoors());
    }

    @Test
    public void turboIsOffByDefault() {
        assertFalse(saab.getTurboOn());
    }

    @Test
    public void turboCanBeTurnedOn() {
        saab.setTurboOn();
        assertTrue(saab.getTurboOn());
    }

    @Test
    public void turboCanBeTurnedOff() {
        saab.setTurboOn();
        saab.setTurboOff();
        assertFalse(saab.getTurboOn());
    }

    @Test
    public void turboIncreasesSpeedMoreThanNoTurbo() {
        saab.startEngine();
        saab.gas(1.0);
        double speedWithoutTurbo = saab.getCurrentSpeed();

        saab.stopEngine();
        saab.startEngine();
        saab.setTurboOn();
        saab.gas(1.0);
        double speedWithTurbo = saab.getCurrentSpeed();

        assertTrue(speedWithTurbo > speedWithoutTurbo);
    }

    @Test
    public void gasIncreasesSpeed() {
        saab.startEngine();
        double before = saab.getCurrentSpeed();

        saab.gas(0.5);

        assertTrue(saab.getCurrentSpeed() > before);
    }

    @Test
    public void brakeDecreasesSpeed() {
        saab.startEngine();
        saab.gas(1.0);
        double before = saab.getCurrentSpeed();

        saab.brake(0.5);

        assertTrue(saab.getCurrentSpeed() < before);
    }

    @Test
    public void testEnginePower() {
        assertEquals(125, saab.getEnginePower(), 0.000001);
    }

    @Test
    public void testGetSetColor() {
        saab.setColor(Color.magenta);
        assertEquals(Color.magenta, saab.getColor());
    }

    @Test
    public void testMove() {
        saab.move();
        assertEquals(0.1, saab.getY(), 0.0001);
        assertEquals(0, saab.getX(), 0.0001);
    }

    @Test
    public void testTurnRight() {
        saab.turnRight();
        assertEquals(Vehicle.Direction.EAST, saab.getDirection());
    }

    @Test
    public void testTurnLeft() {
        saab.turnLeft();
        assertEquals(Vehicle.Direction.WEST, saab.getDirection());
    }
}
