
import java.awt.*;

public class Vehicle implements movable {
    int nrDoors; // Number of doors on the car
    double enginePower; // Engine power of the car
    Color color; // Color of the car
    String modelName; // The car model name
    static double currentSpeed; // The current speed of the car////
    double x; // The cars initial x coordinate
    double y; // The cars initial y coordinate
    direction Direction; // Direction of the car

    public Vehicle(int doors, double EnginePower, Color dye, String name) {
        stopEngine();
        x = 0;
        y = 0;
        Direction = direction.NORTH;
    } // The cars constructor

    public enum direction {
        SOUTH, WEST, NORTH, EAST
    }

    public int getNrDoors() {
        return nrDoors;
    }
    public double getEnginePower() {
        return enginePower;
    }

    public static double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    protected void setColor(Color clr){
        color = clr;
    }

    protected void startEngine(){
        currentSpeed = 0.1;
    }

    protected void stopEngine(){
        currentSpeed = 0;
    }


    public double speedFactor(){
        return enginePower * 0.01;
    }

    protected void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
        if (currentSpeed > enginePower){currentSpeed = enginePower;}
    }

    protected void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
        if (currentSpeed < 0){currentSpeed = 0;}
    }

    @Override
    public void move() {
        switch (Direction) {
            case NORTH:
                y += currentSpeed;
            case SOUTH:
                y -=  currentSpeed;
            case WEST:
                x -= currentSpeed;
            case EAST:
                x += currentSpeed;
        }
    }
    @Override
    public void turnRight() {
        switch (Direction) {
            case NORTH:
                Direction = direction.EAST;
            case SOUTH:
                Direction = direction.WEST;
            case WEST:
                Direction = direction.NORTH;
            case EAST:
                Direction = direction.SOUTH;
        }
    }
    @Override
    public void turnLeft() {
        switch (Direction) {
            case NORTH:
                Direction = direction.WEST;
            case SOUTH:
                Direction = direction.EAST;
            case WEST:
                Direction = direction.SOUTH;
            case EAST:
                Direction = direction.NORTH;
        }
    }

    public void gas(double amount){
        if (0<=amount && amount<=1){incrementSpeed(amount);}
    }

    public void brake(double amount){
        if (0<=amount && amount<=1){decrementSpeed(amount);}
    }

}
