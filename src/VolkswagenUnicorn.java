
import java.awt.*;
import java.util.Objects;
import java.util.Stack;


public abstract class VolkswagenUnicorn extends Truck implements Loader<Car> {
    private final Stack<String> cars = new Stack<String>(); //Stores cars loaded in order LIFO
    public VolkswagenUnicorn() {super(2,  500, Color.pink, "Volkswagen Unicorn");}

    @Override
    public void load(Car carname){if (canLoad()&& carname.getX() == getX()){cars.push("carname");
        carname.setPosition(getX(), getY());}
    }

    public boolean isNear(Car carName){
        return Math.abs(carName.getX() - getX()) <= 5 && Math.abs(carName.getY() - getY()) <= 1;
    }

    @Override
    public Car unload() {
        if (canLoad() && Objects.equals(cars.lastElement(), carname)) {
            cars.pop();
            carname.setPosition(getX() - 5, getY() - 5);
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
