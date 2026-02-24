import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        int minX = 0, minY = 0, maxX = 700, maxY = 500;

        ArrayList<Vehicle> vehicles = new ArrayList<>();
        List<WorkShop<? extends Car>> workShops = new ArrayList<>();

        vehicles.add(new Volvo240());
        vehicles.add(new Saab95());
        vehicles.add(new Scania<>());
        vehicles.add(new VolkswagenUnicorn());

        workShops.add(new WorkShop<>(3, 300, 300, Car.class));
        workShops.add(new WorkShop<>(1, 500, 300, Volvo240.class));

        vehicles.get(0).setPosition(100, 100);
        vehicles.get(1).setPosition(100, 200);
        vehicles.get(2).setPosition(100, 300);
        vehicles.get(3).setPosition(100, 400);

        Simulation sim = new Simulation(vehicles, workShops, new WallCollisionHandler(minX, minY, maxX, maxY), new WorkShopCollisionHandler(10));

        CarController controller = new CarController(sim);
        CarView view = new CarView("CarSim", new ImageHandler());

        controller.setView(view);
        controller.initInput();

        view.getDrawPanel().setRenderItems(sim.getRenderItems());

        controller.startTimer();
    }
}