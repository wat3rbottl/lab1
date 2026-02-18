import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.lang.Math.abs;

/*
 * This class represents the Controller part in the MVC pattern.
 * Its responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());


    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    static ArrayList<Vehicle> vehicles = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        Volvo240 volvo = new Volvo240();
        volvo.setPosition(0, 100);
        vehicles.add(volvo);
        Saab95 saab = new Saab95();
        saab.setPosition(0, 200);
        vehicles.add(saab);
        vehicles.add(new Scania<>());

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle vehicle : vehicles) {

                int x = (int) Math.round(vehicle.getX());
                int y = (int) Math.round(vehicle.getY());

                if (x >= 700 || x < 1) {
                    if (vehicle.getDirection() == Vehicle.Direction.EAST) {
                        vehicle.setDirection(Vehicle.Direction.WEST);
                    } else {
                        vehicle.setDirection(Vehicle.Direction.EAST);
                    }
                } else if (y >= 460 || y < 1) {
                    if (vehicle.getDirection() == Vehicle.Direction.NORTH) {
                        vehicle.setDirection(Vehicle.Direction.SOUTH);
                    } else {
                        vehicle.setDirection(Vehicle.Direction.NORTH);
                    }
                }

                vehicle.move();

                int newX = (int) Math.round(vehicle.getX());
                int newY = (int) Math.round(vehicle.getY());

                boolean flipped = (vehicle.getDirection() == Vehicle.Direction.WEST);

                frame.drawPanel.moveit(vehicle, newX, newY, flipped);
            }
            frame.drawPanel.repaint();
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles
        ) {
            vehicle.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles) {
            vehicle.brake(brake);

        }
    }

    void startEngine() {
        for (Vehicle vehicle : vehicles) {
            vehicle.startEngine();
        }
    }

    void stopEngine() {
        for (Vehicle vehicle : vehicles) {
            vehicle.stopEngine();
        }
    }

    void turnRight() {
        for (Vehicle vehicle : vehicles) {
            vehicle.turnRight();
        }
    }

    static void turnLeft() {
        for (Vehicle vehicle : vehicles) {
            vehicle.turnLeft();
        }
    }

    static void up() {
        for (Vehicle vehicle : vehicles) {
            vehicle.up();
        }
    }

    static void down() {
        for (Vehicle vehicle : vehicles) {
            vehicle.down();
        }
    }

    void turboOn() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Saab95 saab) {
                saab.setTurboOn();
            }
        }
    }

    void turboOff(){
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Saab95 saab) {
                saab.setTurboOff();
            }
        }
    }
}

