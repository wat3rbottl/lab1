//import java.awt.*;
//
//public abstract class RampVehicle<T extends Transportable>
//        extends Vehicle implements Transporter<T>, Rampable {
//
//    private boolean rampUp = true;
//
//    public RampVehicle(int doors, double EnginePower, Color dye, String name) {
//        super(doors, EnginePower, dye, name);
//    }
//
//    @Override
//    public void gas(double amount) {
//        if (bedIsUp()) super.gas(amount);
//    }
//
//     Rampable
//    @Override
//    public boolean bedIsUp() {
//        return rampUp;
//    }
//
//    @Override
//    public boolean bedIsDown() {
//        return !rampUp;
//    }
//
//    @Override
//    public void raiseBed() {
//        rampUp = true;
//    }
//
//    @Override
//    public void lowerBed() {
//        // Ramp can only be down when standing still
//        if (getCurrentSpeed() == 0) {
//            rampUp = false;
//        }
//    }
//
//    @Override
//    public void startEngine() {
//        // Can't start if ramp is down
//        if (rampUp) {
//            setCurrentSpeed(0.1);
//        }
//    }
//
//    protected boolean isRampDown() {
//        return !rampUp;
//    }
//
//    @Override
//    public abstract void load(T item);
//
//    @Override
//    public abstract T unload();
//}