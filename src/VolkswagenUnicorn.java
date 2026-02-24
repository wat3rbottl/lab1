
import java.awt.*;
import java.util.Stack;


public class VolkswagenUnicorn extends VehicleTransporter<Car> implements Rampable {
    private final Stack<Car> cars = new Stack<Car>(); //Stores cars loaded in order LIFO
    private final int capacity = 20;

    private boolean rampUp = true;

    public VolkswagenUnicorn() {
        super(2, 500, Color.pink, "VolkswagenUnicorn");
    }

    public int getAmountOfCars() {
        return cars.size();
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.04;
    }

    @Override
    protected Iterable<Car> getLoadedItems() {
        return cars;
    }

    @Override
    public boolean bedIsUp() {
        return rampUp;
    }

    @Override
    public boolean bedIsDown() {
        return !rampUp;
    }

    @Override
    public void raiseBed() {
        rampUp = true;
    }

    @Override
    public void lowerBed() {
        if (getCurrentSpeed() == 0) rampUp = false;
    }

    @Override
    public void startEngine() {
        if (rampUp) setCurrentSpeed(0.1);
    }

    @Override
    public void gas(double amount) {
        if (rampUp) super.gas(amount);
    }


    @Override
    public boolean canLoad(Car car) {
        return bedIsDown()
                && super.canLoad(car)
                && cars.size() < capacity;
    }

    @Override
    public void load(Car car) {
        if (!canLoad(car)) return;
        car.setPosition(getX(), getY());
        cars.push(car);
    }

    @Override
    public boolean canUnload() {
        return bedIsDown()
                && super.canUnload()        // speed==0
                && !cars.isEmpty();
    }

    @Override
    public Car unload() {
        if (!canUnload()) return null;
        Car car = cars.pop();
        car.setPosition(getX() - 5, getY() - 5);
        return car;
    }

}


