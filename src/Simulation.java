import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;

public class Simulation {

    private final List<Vehicle> vehicles;
    private final WallCollisionHandler wall;
    private final WorkShopCollisionHandler workshopCollisionHandler = new WorkShopCollisionHandler(10);
    private final List<WorkShop<? extends Car>> workShops = new ArrayList<>();

    public Simulation(List<Vehicle> vehicles, WallCollisionHandler wall/*, WorkshopCollisionHandler workshop*/) {
        this.vehicles = vehicles;
        this.wall = wall;
//      this.workshop = workshop;
    }

    public void addWorkShop(WorkShop<? extends Car> shop) { workShops.add(shop); }

    public List<WorkShop<? extends Car>> getWorkShops() { return workShops; }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void tick() {
        for (Vehicle v : vehicles) {
            wall.handle(v);
            v.move();
        }
        List<Vehicle> toRemove = workshopCollisionHandler.handle(vehicles, workShops);
        vehicles.removeAll(toRemove);
    }

    // “All cars”-actions:
    public void gasAll(double amount) {
        for (Vehicle v : vehicles) v.gas(amount);
    }

    public void brakeAll(double amount) {
        for (Vehicle v : vehicles) v.brake(amount);
    }

    public void startAll() {
        for (Vehicle v : vehicles) v.startEngine();
    }

    public void stopAll() {
        for (Vehicle v : vehicles) v.stopEngine();
    }

    public void turnLeftAll() {
        for (Vehicle v : vehicles) v.turnLeft();
    }

    public void turnRightAll() {
        for (Vehicle v : vehicles) v.turnRight();
    }

    public void upAll() {
        for (Vehicle v : vehicles) v.up();
    }

    public void downAll() {
        for (Vehicle v : vehicles) v.down();
    }

    public void turboOn() {
        for (Vehicle v : vehicles) {
            if (v instanceof Saab95) {
                ((Saab95) v).turboOn();
            }
        }
    }

    public void turboOff() {
        for (Vehicle v : vehicles) {
            if (v instanceof Saab95) {
                ((Saab95) v).turboOff();
            }
        }
    }

    public void lowerBed() {
        for (Vehicle v : vehicles) {
            if (v instanceof Rampable r) r.lowerBed();
        }
    }

    public void raiseBed() {
        for (Vehicle v : vehicles) {
            if (v instanceof Rampable r) r.raiseBed();
        }
    }

}

