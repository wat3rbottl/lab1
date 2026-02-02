
import java.awt.*;

public abstract class Vehicle implements Movable {
    private int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car, protected because subclasses need to access it
    private Color color; // Color of the car
    private String modelName; // The car model name
    private double currentSpeed; // The current speed of the car////
    private double x; // The cars initial x coordinate
    private double y; // The cars initial y coordinate
    private Direction direction; // Direction of the car
    private double weight; //The cars i

    public Vehicle(int doors, double EnginePower, Color dye, String name) {
        stopEngine();
        x = 0;
        y = 0;
        nrDoors = doors;
        enginePower = EnginePower;
        color = dye;
        modelName = name;
        direction = Direction.NORTH;
    } // The cars constructor

    public enum Direction {
        SOUTH, WEST, NORTH, EAST
    }

    public Direction getDirection() {
        return direction;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    public abstract double speedFactor();

    private void incrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
        if (currentSpeed > enginePower) {
            currentSpeed = enginePower;
        }
    }

    private void decrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
        if (currentSpeed < 0) {
            currentSpeed = 0;
        }
    }

    @Override
    public void move() {
        switch (direction) {
            case NORTH -> y += currentSpeed;
            case SOUTH -> y -= currentSpeed;
            case WEST -> x -= currentSpeed;
            case EAST -> x += currentSpeed;
        }
    }

    @Override
    public void turnRight() {
        switch (direction) {
            case NORTH -> direction = Direction.EAST;
            case SOUTH -> direction = Direction.WEST;
            case WEST -> direction = Direction.NORTH;
            case EAST -> direction = Direction.SOUTH;
        }
    }

    @Override
    public void turnLeft() {
        switch (direction) {
            case NORTH -> direction = Direction.WEST;
            case SOUTH -> direction = Direction.EAST;
            case WEST -> direction = Direction.SOUTH;
            case EAST -> direction = Direction.NORTH;
        }
    }

    public void gas(double amount) {
        if (0 <= amount && amount <= 1) {
            incrementSpeed(amount);
        }
    }

    public void brake(double amount) {
        if (0 <= amount && amount <= 1) {
            decrementSpeed(amount);
        }
    }

}
