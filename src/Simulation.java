import java.util.List;

public class Simulation {

    private final List<Vehicle> vehicles;
    private final WallCollisionHandler wall;
    // private final WorkshopCollisionHandler workshop;

    public Simulation(List<Vehicle> vehicles, WallCollisionHandler wall/*, WorkshopCollisionHandler workshop*/) {
        this.vehicles = vehicles;
        this.wall = wall;
//      this.workshop = workshop;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void tick() {
        for (Vehicle v : vehicles) {
            wall.handle(v);
            v.move();
        }
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

    public void upAllInvertedY() {
        for (Vehicle v : vehicles) v.down(); // inverted axis
    }

    public void downAllInvertedY() {
        for (Vehicle v : vehicles) v.up();   // inverted axis
    }
}

