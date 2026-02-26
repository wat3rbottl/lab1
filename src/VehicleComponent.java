public interface VehicleComponent extends Movable {
    void gas(double amount);
    void brake(double amount);
    void startEngine();
    void stopEngine();
    void move();
    void turnLeft();
    void turnRight();
}
