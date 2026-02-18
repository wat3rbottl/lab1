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

        cc.vehicles.add(new Volvo240());
        cc.vehicles.add(new Saab95());
        cc.vehicles.add(new Scania<>());

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

                if(abs(x) < 700 && abs(y) < 460) {
                    vehicle.move();
                    frame.drawPanel.moveit(x, y);
                    // repaint() calls the paintComponent method of the panel
                    frame.drawPanel.repaint();
                }

                else if(abs(x) >= 700 && abs(y) < 460) {
                    if(vehicle.getDirection() == Vehicle.Direction.EAST){
                        vehicle.setDirection(Vehicle.Direction.WEST);
                        vehicle.move();
                        frame.drawPanel.moveit(x, y, vehicle);
                        DrawPanel.flipped = true;
                        frame.drawPanel.repaint();
                    }
                    else{
                        vehicle.setDirection(Vehicle.Direction.EAST);
                        vehicle.move();
                        frame.drawPanel.moveit(x, y);
                        frame.drawPanel.repaint();
                    }
                }

                else if(abs(x) < 700 && abs(y) >= 460) {
                    if(vehicle.getDirection() == Vehicle.Direction.NORTH) {
                        vehicle.setDirection(Vehicle.Direction.SOUTH);
                        vehicle.move();
                        frame.drawPanel.moveit(x, y);
                        DrawPanel.flipped = true;
                        frame.drawPanel.repaint();
                    } else {
                        vehicle.setDirection(Vehicle.Direction.NORTH);
                        vehicle.move();
                        frame.drawPanel.moveit(x, y);
                        frame.drawPanel.repaint();
                    }
                }
            }
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
        for (Vehicle vehicle : vehicles){
            vehicle.brake(brake);

        }
    }

    void startEngine(){
        for (Vehicle vehicle : vehicles){
            vehicle.startEngine();
        }
    }

    void stopEngine(){
        for (Vehicle vehicle : vehicles){
            vehicle.stopEngine();
        }
    }

     static void turnRight(){
        for (Vehicle vehicle : vehicles){
            vehicle.turnRight();
        }
    }
    static void turnLeft(){
        for (Vehicle vehicle : vehicles){
            vehicle.turnLeft();
        }
    }

    static void up(){
        for (Vehicle vehicle : vehicles){
            vehicle.up();
        }
    }
    static void down(){
        for(Vehicle vehicle : vehicles){
            vehicle.down();
        }
    }


}
