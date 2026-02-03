import java.awt.*;

public class Scania extends Truck implements Loader {
    private int rampDeg = 0;


    public Scania() {
        super(2,150, Color.pink, "Scania Fire");
    }

    @Override
    public void lower(){

    }

    @Override
    public void raise(){

    }

    @Override
    public void load(){

    }

    @Override
    public void unload(){

    }

    @Override
    public double speedFactor(){
        return enginePower * 0.03;
    }
}