import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;

public class Simulation {

    private final List<Vehicle> vehicles;
    private final WallCollisionHandler wall;
    private final WorkShopCollisionHandler workshopCollision;
    private final List<WorkShop<? extends Car>> workShops;

    public Simulation(List<Vehicle> vehicles, List<WorkShop<? extends Car>> workShops, WallCollisionHandler wall, WorkShopCollisionHandler workshopCollision) {
        this.vehicles = vehicles;
        this.wall = wall;
        this.workshopCollision = workshopCollision;
        this.workShops = workShops;
    }

    public List<WorkShop<? extends Car>> getWorkShops() {
        return workShops;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public boolean tick() {
        for (Vehicle v : vehicles) {
            wall.handle(v);
            v.move();
        }
        List<Vehicle> toRemove = workshopCollision.handle(vehicles, workShops);
        vehicles.removeAll(toRemove);

        return true;
    }

    public List<RenderItem> getRenderItems() {
        List<RenderItem> items = new ArrayList<>();

        for (Vehicle v : vehicles) {
            int x = (int) Math.round(v.getX());
            int y = (int) Math.round(v.getY());
            boolean flipX = (v.getDirection() == Vehicle.Direction.WEST);
            String imageId = v.getClass().getSimpleName();

            items.add(new RenderItem(imageId, x, y, flipX));
        }

        for (WorkShop<? extends Car> ws : workShops) {
            int x = (int) Math.round(ws.getX());
            int y = (int) Math.round(ws.getY());
            Class<?> type = ws.getAcceptedType();
            String imageId = (type == Car.class)
                    ? "GeneralShop"
                    : type.getSimpleName() + "Shop";

            //String imageId;
            //if (type == Car.class) {
            //    imageId = "GeneralShop";
            //} else {
            //    imageId = type.getSimpleName() + "Shop";
            //}

            items.add(new RenderItem(imageId, x, y, false));
        }

        return items;
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

    // instance of ...
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

    // Unload methods
    public boolean unloadCarFromShopRandom() {
        for (WorkShop<? extends Car> ws : workShops) {
            if (ws.canUnload()) {
                Car car = ws.unload();

                double spawnPoint = 80;
                car.setPosition(car.getX(), car.getY() - spawnPoint);
                car.stopEngine();
                vehicles.add(car);
                return true;
            }
        }
        return false;
    }
}

