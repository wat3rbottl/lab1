import java.awt.*;
import java.util.ArrayList;

public class Scania<T extends Transportable> extends RampVehicle<T> {
    private int rampDeg = 0;
    private ArrayList<T> items = new ArrayList<>();

    public Scania() {
        super(2,150, Color.pink, "Scania Fire");
    }

    @Override
    public void lower(){
        if(rampDeg > 10){
            rampDeg -= 10;
        }
    }

    @Override
    public void raise(){
        if(rampDeg < 70 && getCurrentSpeed() == 0){
            rampDeg += 10;
        }
    }

    @Override
    public double speedFactor(){
        return enginePower * 0.03;
    }

    @Override
    public void startEngine(){
        if (rampDeg == 0) {setCurrentSpeed(0.1);}
    }

    @Override
    public void load(T item){
        if(rampDeg == 0 && getCurrentSpeed() == 0) {
            items.add(item);
        }
    }

    @Override
    public T unload() {
        if (rampDeg > 50 && getCurrentSpeed() == 0 && !items.isEmpty()){
            return items.removeLast();
        }
        else return null;
    }

    public int getRampDeg() {return rampDeg;}
}