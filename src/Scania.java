import java.awt.*;
import java.util.ArrayList;

public class Scania<T extends Transportable> extends Vehicle implements Transporter<T>, Rampable {
    private int bedDegree = 0;
    private ArrayList<T> items = new ArrayList<>();

    public Scania() {
        super(2, 150, Color.pink, "Scania");
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.02;
    }

    @Override
    public void startEngine() {
        if (bedIsUp()&&getCurrentSpeed()==0) {
            setCurrentSpeed(0.1);
        }
    }

    @Override
    public void gas(double amount) {
        if (bedIsUp()) {
            super.gas(amount);
        }
    }

    @Override
    public boolean canLoad(T item) {
        return isNear(item,5) && bedIsUp() && getCurrentSpeed() == 0;
    }

    @Override
    public boolean canUnload(){
        return bedIsDown() && getCurrentSpeed() == 0 && !items.isEmpty();
    }

    @Override
    public void load(T item) {
        if (canLoad(item)) {
            items.add(item);
        }
    }

    @Override
    public T unload() {
        if (canUnload()) {
            return items.remove(items.size()-1);
        } else return null;
    }

    @Override
    public boolean bedIsUp() {
        return bedDegree == 0;
    }

    @Override
    public boolean bedIsDown() {
        return bedDegree >= 30;
    }

    public int getBedDegree() {
        return bedDegree;
    }

    private void setBedDegree(int deg) {
        bedDegree = Math.max(0, Math.min(70, deg));
    }

    @Override
    public void raiseBed() {
        if (getCurrentSpeed() == 0) setBedDegree(bedDegree - 10);
    }

    @Override
    public void lowerBed() {
        if (getCurrentSpeed() == 0) setBedDegree(bedDegree + 10);
    }

}