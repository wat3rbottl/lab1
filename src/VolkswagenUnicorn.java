
import java.awt.*;
import java.util.Objects;
import java.util.Stack;


public class VolkswagenUnicorn extends Truck<Car>  {
    private final Stack<Car> cars = new Stack<Car>(); //Stores cars loaded in order LIFO
    private final int capacity = 20;

    public VolkswagenUnicorn() {
        super(2, 500, Color.pink, "Volkswagen Unicorn");
    }

    public int getCarsSize() {
        return cars.size();
    }

    @Override
    public double speedFactor() {
        return enginePower * 0.05;}

    @Override
    public void load(Car carname) {
        if (canLoad() && isNear(carname) && cars.size() < capacity) {
            cars.push(carname);
            carname.setPosition(getX(), getY());
        }
    }

    public boolean isNear(Car carName){
        return Math.abs(carName.getX() - getX()) <= 5 && Math.abs(carName.getY() - getY()) <= 1;
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
