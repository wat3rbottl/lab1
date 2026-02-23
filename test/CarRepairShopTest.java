import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CarRepairShopTest {
    private RepairShop<Car> generalRepair;
    private RepairShop<Volvo240> VolvoRepair;

    @Before
    public void setUp() throws Exception {
        generalRepair = new RepairShop<>(2);
        VolvoRepair = new RepairShop<>(2);
    }

    @Test
    public void canLoadAnyCarButNotOverCapacity() {
        generalRepair.load(new Volvo240());
        generalRepair.load(new Saab95());
        generalRepair.load(new Volvo240());

        assertEquals(2, generalRepair.numCars(), 0.0001);
    }
}
