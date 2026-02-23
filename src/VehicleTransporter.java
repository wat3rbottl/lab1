import java.awt.*;

public abstract class VehicleTransporter<T extends Vehicle & Transportable> extends Vehicle implements Transporter<T> {

    public VehicleTransporter(int doors, double EnginePower, Color dye, String name) {
            super(doors, EnginePower, dye, name);
        }

    @Override
    public boolean canLoad(T item){
        return isNear(item, 5);
    }
    @Override
    public abstract void load(T item);

    @Override
    public abstract T unload();

    public void updatePosition(T item){
        item.setPosition(getX(), getY());
    }

}


