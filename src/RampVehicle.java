import java.awt.*;

public abstract class RampVehicle<T extends Transportable> extends Vehicle implements Transporter<T> {
    private boolean rampUp;

    public RampVehicle(int doors, double EnginePower, Color dye, String name) {
        super(doors, EnginePower, dye, name);
        rampUp = true;
    }

    public void raise(){
        rampUp = true;} // Raises the ramp, not loadable

    public void lower(){
        if(getCurrentSpeed() == 0)
        {rampUp = false;}
    } // Lowers the ramp, loadable

    public boolean canLoad() {
        return !rampUp;} // Can't load if ramp is up, can if lowered


    @Override
    public void startEngine(){
                if (rampUp) {setCurrentSpeed(0.1);}
        }

    @Override
    public abstract void load(T item);

    @Override
    public abstract T unload();








}
