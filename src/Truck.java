import java.awt.*;

public abstract class Truck extends Vehicle implements Loadable{
    private boolean rampUp;

    public Truck(int doors, double EnginePower, Color dye, String name) {
        super(doors, EnginePower, dye, name);
        rampUp = true;
    }

    public void raise(){
        rampUp = true;} // Raises the ramp, not loadable

    public void lower(){if(getCurrentSpeed() == 0)
    {rampUp = false;}
    } // Lowers the ramp, loadable


    public boolean canLoad() {
        return !rampUp;} // Can't load if ramp is up, can if lowered

    @Override
    public void startEngine(){
                if (rampUp) {setCurrentSpeed(0.1);}
        }

    @Override
    public  void unload(Car carname);

    
}
