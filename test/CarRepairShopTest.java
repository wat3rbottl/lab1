import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CarRepairShopTest {
    private CarRepairShop<Car> generalRepair;

    @Before
    public void setUp() throws Exception {
        generalRepair = new CarRepairShop<>(2);
    }

    @Test
    public void canLoadAnyCarButNotOverCapacity() {
        generalRepair.load(new Volvo240());
        generalRepair.load(new Saab95());
        generalRepair.load(new Volvo240());

        assertEquals(3, generalRepair.numCars(), 0.0001);
    }
}
