import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        int minX = 0, minY = 0, maxX = 700, maxY = 500;

        RepairShop repairShop = new RepairShop<>(3,300, 300);

        ArrayList<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Volvo240());
        vehicles.add(new Saab95());
        vehicles.add(new Scania<>());

        vehicles.get(0).setPosition(100, 100);
        vehicles.get(1).setPosition(100, 200);
        vehicles.get(2).setPosition(100, 300);

        Simulation sim = new Simulation(vehicles, new WallCollisionHandler(minX, minY, maxX, maxY));

        CarController controller = new CarController(sim);
        CarView view = new CarView("CarSim", new ImageHandler());

        controller.setView(view);
        controller.initInput();

        view.setVehicles(sim.getVehicles());

        controller.startTimer(); // start timer
    }
}