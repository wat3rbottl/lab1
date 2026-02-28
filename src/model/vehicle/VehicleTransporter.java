package model.vehicle;

import interfaces.Transporter;

import java.awt.*;

public abstract class VehicleTransporter<T extends Car> extends Vehicle implements Transporter<T> {

    public VehicleTransporter(int doors, double EnginePower, Color dye, String name) {
        super(doors, EnginePower, dye, name);
    }

    protected abstract Iterable<T> getLoadedItems();

    @Override
    public boolean canLoad(T item) {
        return isNear(item, 5)
                && getCurrentSpeed()== 0
                && item != null;
    }

    @Override
    public boolean canUnload(){
        return getCurrentSpeed() == 0;
    }

    @Override
    public abstract void load(T item);

    @Override
    public abstract T unload();

    protected final void syncPositions() {
        for (T item : getLoadedItems()) {
            if (item != null) {
                item.setPosition(getX(), getY());
            }
        }
    }

    @Override
    public void move() {
        super.move();
        syncPositions();
    }

}


