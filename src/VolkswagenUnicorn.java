
import java.awt.*;
import java.util.Objects;
import java.util.Stack;


public abstract class VolkswagenUnicorn extends Truck {
    private final Stack<String> cars = new Stack<String>(); //Stores cars loaded in order LIFO
    public VolkswagenUnicorn() {super(2,  500, Color.pink, "Volkswagen Unicorn");}


    @Override
    public void load(Car carname){if (canLoad()&& carname.getX() == getX()){cars.push("carname");
    carname.setPosition(getX(), getY());}
    }

    @Override
    public void unload(Car carname) {
        if (canLoad() && Objects.equals(cars.lastElement(), carname)) {
            cars.pop();
            carname.setPosition(getX() - 5, getY() - 5);
        }
    }

}
