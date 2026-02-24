import java.awt.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.List;

public abstract class Ferry extends VehicleTransporter<Car> {
    private final int capacityPerLane;
    private final List<Queue<Car>> lanes;

    public Ferry(int doors, double EnginePower, Color dye, String name, int capacityPerLane, int numLanes) {
        super(doors, EnginePower, dye, name);
        this.capacityPerLane = capacityPerLane;
        this.lanes = new ArrayList<>();

        for (int i = 0; i < numLanes; i++) {
            lanes.add(new ArrayDeque<>());
        }
    }

    @Override
    protected Iterable<Car> getLoadedItems() {
        List<Car> allCars = new ArrayList<>();
        for (Queue<Car> lane : lanes) {
            allCars.addAll(lane);
            return allCars;
        }
        return null;
    }

    @Override
    public void load(Car car) {
        if (!canLoad(car)) return;

        for (Queue<Car> lane : lanes) {
            if (lane.size() < capacityPerLane) {
                lane.add(car);
                car.setPosition(getX(), getY());
                break;
            }
        }
    }

    @Override
    public Car unload() {
        return unload(0);
    }

    public Car unload(int laneIndex) {
        if (laneIndex < 0 || laneIndex >= lanes.size()) return null;

        Car car = lanes.get(laneIndex).poll();
        if (car == null) return null;

        car.setPosition(this.getX() + 5, this.getY() + 5);
        return car;
    }
}
