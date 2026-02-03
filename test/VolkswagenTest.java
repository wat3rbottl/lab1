import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.Assert.*;


public class VolkswagenTest {

    private VolkswagenUnicorn volkswagenunicorn;
    private Volvo240 car1;
    private Saab95 car2;


    @Before
    public void setUp(){
        volkswagenunicorn = new VolkswagenUnicorn();
        car1 = new Volvo240();
        car2 = new Saab95();
        volkswagenunicorn.setPosition(0,0);
        car1.setPosition(20,20);
        car2.setPosition(2,2);
    }


    @Test
    public void testLoad() {
    volkswagenunicorn.load(car2);
    assertEquals(0, car2.getX(), 0.00001);
    assertEquals(0, car2.getY(), 0.00001);
    assertEquals(1, volkswagenunicorn.getCarsSize());
    }

    public void testUnload(){
        volkswagenunicorn.load(car2);
        volkswagenunicorn.unload();
        assertEquals(volkswagenunicorn.getX()-5, car2.getX(), 0.0001);
        assertEquals( volkswagenunicorn.getY()-5,car2.getY(), 0.0001);
        assertEquals(0, volkswagenunicorn.getCarsSize());
    }


    public void testMove(){
        volkswagenunicorn.load(car2);
        volkswagenunicorn.startEngine();
        volkswagenunicorn.move();
        

    }
}
