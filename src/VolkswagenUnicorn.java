
import java.awt.*;
import java.util.Stack;


public class VolkswagenUnicorn extends RampVehicle<Car> {
    private final Stack<Car> cars = new Stack<Car>(); //Stores cars loaded in order LIFO
    private final int capacity = 20;

    public VolkswagenUnicorn() {
        super(2, 500, Color.pink, "Volkswagen Unicorn");
    }

    public int getAmountOfCars() {
        return cars.size();
    }

    @Override
    public double speedFactor() {
        return enginePower * 0.05;}

    @Override
    public void load(Car carName) {
        if (canLoad() && isNear(carName) && cars.size() < capacity) {
            carName.setPosition(getX(), getY());
            cars.push(carName);
        }
    }

    private boolean isNear(Car carName){
        return Math.abs(carName.getX() - getX()) <= 5 && Math.abs(carName.getY() - getY()) <= 5;
    }

    @Override
    public Car unload() {
        if (canLoad() && !cars.isEmpty()) {
            Car car = cars.pop();
            car.setPosition(getX() - 5, getY() - 5);
            return car;
        }
        else return null;
    }
    @Override
    public void move() {
        super.move();
        for (Car car : cars){
            car.setPosition(getX(), getY());
        }
    }

}
