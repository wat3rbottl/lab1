import java.awt.*;

public abstract class Vehicle implements VehicleComponent {
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car, protected because subclasses need to access it
    private Color color; // Color of the car
    private String modelName; // The car model name
    private double currentSpeed; // The current speed of the car////
    private double x; // The cars initial x coordinate
    private double y; // The cars initial y coordinate
    private Direction direction; // Direction of the car

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

    public String getImageId() {
        return modelName;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
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

    public void setCurrentSpeed(double x) {
        currentSpeed = x;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    public void startEngine() {
        if (currentSpeed == 0) {
            currentSpeed = 0.1;
        }
    }

    @Override
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
            case NORTH -> y -= currentSpeed; // Up on screen
            case SOUTH -> y += currentSpeed; // Down on screen
            case WEST -> x -= currentSpeed;
            case EAST -> x += currentSpeed;
        }
    }

    @Override
    public void turnRight() {
        direction = Direction.EAST;
    }

    @Override
    public void turnLeft() {
        direction = Direction.WEST;
    }

    public void up() {
        direction = Direction.NORTH;
    }

    public void down() {
        direction = Direction.SOUTH;
    }

    @Override
    public void gas(double amount) {
        if (0 <= amount && amount <= 1 && getCurrentSpeed() > 0) {
            incrementSpeed(amount);
        }
    }

    @Override
    public void brake(double amount) {
        if (0 <= amount && amount <= 1) {
            decrementSpeed(amount);
        }
    }

}
