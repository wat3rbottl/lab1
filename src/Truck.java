import java.awt.*;

public abstract class Truck extends Vehicle implements loadable, Movable {

    public Truck() {super(2,  500, Color.pink, "Volkswagen Unicorn");}

    @Override
    public  void loader();{

    }

    @Override
    public void loadables();{

    }
}
