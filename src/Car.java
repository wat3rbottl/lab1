import java.awt.*;

public abstract class Car extends Vehicle implements Transportable{

    public Car(int doors, double EnginePower, Color dye, String name) {
        super(doors, EnginePower, dye, name);
    }
}