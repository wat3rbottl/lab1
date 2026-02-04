import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScaniaTest {

    private Scania<Transportable> scania;

    @Before
    public void setUp() {
        scania = new Scania<>();
    }

    @Test
    public void scaniaStandsStillWhenRampUp() {
        scania.raise();
        scania.startEngine();
        assertEquals(0.0, scania.getCurrentSpeed(), 0.0001);
    }

    @Test
    public void scaniaRampDegInCorrectRangeHigh(){
        for(int i = 0; i < 10; i++){
        scania.raise();
        }
        assertEquals(70, scania.getRampDeg(), 0.0001);
    }

    @Test
    public void scaniaRampDegInCorrectRangeLow(){
        for(int i = 0; i < 10; i++){
            scania.lower();
        }
        assertEquals(0, scania.getRampDeg(), 0.0001);
    }

    @Test
    public void scaniaCantRaiseRampWhenMoving(){
        scania.startEngine();
        scania.gas(2);
        scania.raise();
        assertEquals(0, scania.getRampDeg(), 0.0001);
    }
}
