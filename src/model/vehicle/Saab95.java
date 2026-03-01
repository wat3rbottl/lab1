package model.vehicle;

import interfaces.Turboable;

import java.awt.*;

public class Saab95 extends Car implements Turboable {
    private boolean turboOn;

    public Saab95() {
        super(2, 125, Color.red, "model.vehicle.Saab95");
        turboOn = false;
    }

    @Override
    public void turboOff() {
        turboOn = false;
    }
    @Override
    public void turboOn() {
        turboOn = true;
    }

    public boolean getTurboOn() {
        return turboOn;
    }

    @Override
    public void toggleTurbo(){
        turboOn = !turboOn;
    }

    @Override
    public double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

}