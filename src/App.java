import controller.CarController;
import factory.StandardVehicleFactory;
import factory.VehicleFactory;
import factory.VehicleType;
import model.simulation.Simulation;
import model.simulation.WallCollisionHandler;
import model.simulation.WorkShopCollisionHandler;
import model.vehicle.*;
import model.workshop.WorkShop;
import view.CarView;
import view.SpeedView;
import view.ImageHandler;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        int minX = 0, minY = 0, maxX = 700, maxY = 500;

        VehicleFactory factory = new StandardVehicleFactory();

        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(factory.createVehicle(VehicleType.VOLVO240));
        vehicles.add(factory.createVehicle(VehicleType.SAAB95));
        vehicles.add(factory.createVehicle(VehicleType.SCANIA));
        vehicles.add(factory.createVehicle(VehicleType.VOLKSWAGEN_UNICORN));

        vehicles.get(0).setPosition(100, 100);
        vehicles.get(1).setPosition(100, 200);
        vehicles.get(2).setPosition(100, 300);
        vehicles.get(3).setPosition(100, 400);

        List<WorkShop<? extends Car>> workShops = new ArrayList<>();
        workShops.add(new WorkShop<>(3, 300, 300, Car.class));
        workShops.add(new WorkShop<>(1, 500, 300, Volvo240.class));

        Simulation sim = new Simulation(vehicles, workShops,
                new WallCollisionHandler(minX, minY, maxX, maxY),
                new WorkShopCollisionHandler(10));

        CarView view = new CarView("CarSim", new ImageHandler());
        SpeedView speedview = new SpeedView();

        sim.addObserver(view.getDrawPanel());
        sim.addObserver(speedview);
        view.add(speedview, java.awt.BorderLayout.NORTH);

        sim.tick();

        CarController controller = new CarController(sim);
        controller.setView(view);
        controller.initInput();
        controller.startTimer();
    }
}