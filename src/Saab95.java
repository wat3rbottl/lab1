import java.awt.*;  // awt ett bibliotek för rendering(rita saker), color kommer där iftån

public class Saab95 extends Vehicle {  // top level class
    private boolean turboOn;

    public Saab95() {
        super(2, 125, Color.red, "Saab95");
        turboOn = false;
    }

    public void setTurboOff() {
        turboOn = false;
    }

    public void setTurboOn() {
        turboOn = true;
    }

    public boolean getTurboOn() {
        return turboOn;
    }

    public void setTurboOff(){
        turboOn = false;
    }

    public void setTurboOn(){
        turboOn = true;

    @Override
    public double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

}