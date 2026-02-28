package model.workshop;

import interfaces.HasPosition;
import interfaces.Loader;
import model.vehicle.Car;

import java.util.ArrayList;
import java.util.List;

public class WorkShop<T extends Car> implements HasPosition, Loader<T> {

    private final int capacity;
    private final List<T> cars = new ArrayList<>();
    private final Class<T> acceptedType;

    private double x;
    private double y;

    public WorkShop(int capacity, double x, double y, Class<T> acceptedType) {
        this.x = x;
        this.y = y;
        this.capacity = capacity;
        this.acceptedType = acceptedType;
    }

    @Override // Override from interfaces.HasPosition
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public int getCapacity() {
        return capacity;
    }

    public int numCars() {
        return cars.size();
    }

    public boolean hasSpace() { return cars.size() < capacity; }

    public Class<T> getAcceptedType() { return acceptedType; }

    @Override
    public boolean canLoad(T car) {
        return hasSpace();
    }

    @Override
    public boolean canUnload() {
        return !cars.isEmpty();
    }

    @Override
    public void load(T car) {
        if (canLoad(car)) cars.add(car);
    }

    @Override
    public T unload() {
        if (!canUnload()) return null;
        return cars.remove(0);
    }

    public boolean accepts(Car car) {
        return acceptedType.isInstance(car);
    }

    public boolean tryLoad(Car car) {
        if (!hasSpace()) return false;
        if (!accepts(car)) return false;

        T acceptedCar = acceptedType.cast(car);
        load(acceptedCar);

        System.out.println("Loaded " + car.getClass().getSimpleName() + " into " + getAcceptedType()+"Shop");

        return true;
    }
}




