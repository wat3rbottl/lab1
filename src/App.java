import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        int minX = 0, minY = 0, maxX = 700, maxY = 500;

        WorkShop workShop = new WorkShop<>(3, 300, 300, "GeneralShop", Car.class);

        ArrayList<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Volvo240());
        vehicles.add(new Saab95());
        vehicles.add(new Scania<>());
        vehicles.add(new VolkswagenUnicorn());

        vehicles.get(0).setPosition(100, 100);
        vehicles.get(1).setPosition(100, 200);
        vehicles.get(2).setPosition(100, 300);
        vehicles.get(3).setPosition(100, 400);

        WorkShop<Car> general = new WorkShop<>(3, 300, 300, "GeneralShop", Car.class);
        WorkShop<Volvo240> volvo = new WorkShop<>(2, 500, 300, "Volvo240Shop", Volvo240.class);

        general.setPosition(200, 250);
        volvo.setPosition(350, 250);

        Simulation sim = new Simulation(vehicles, new WallCollisionHandler(minX, minY, maxX, maxY));

        sim.addWorkShop(general);
        sim.addWorkShop(volvo);

        CarController controller = new CarController(sim);
        CarView view = new CarView("CarSim", new ImageHandler());

        view.getDrawPanel().setWorkShops(sim.getWorkShops());

        controller.setView(view);
        controller.initInput();

        view.setVehicles(sim.getVehicles());

        controller.startTimer(); // start timer
    }
}