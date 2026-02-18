import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.lang.Math.abs;


/*
 * This class represents the Controller part in the MVC pattern.
 * Its responsibilities are to listen to the View and respond in an appropriate manner by
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
    static ArrayList<Car> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        Volvo240 bettan = new Volvo240();
        cc.cars.add(bettan);

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
            for (Car car : cars) {
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());

                if(abs(x) < 700 && abs(y) < 460) {
                    car.move();
                    frame.drawPanel.moveit(x, y);
                    // repaint() calls the paintComponent method of the panel
                    frame.drawPanel.repaint();
                }

                else if(abs(x) >= 700 && abs(y) < 460) {
                    if(car.getDirection() == Vehicle.Direction.EAST){
                        car.setDirection(Vehicle.Direction.WEST);
                    }
                    else{
                        car.setDirection(Vehicle.Direction.EAST);
                    }
                    car.move();
                    frame.drawPanel.moveit(x, y);
                    DrawPanel.flipped = true;
                    frame.drawPanel.repaint();
                }

                else if(abs(x) < 700 && abs(y) >= 460) {
                    if(car.getDirection() == Vehicle.Direction.NORTH) {
                        car.setDirection(Vehicle.Direction.SOUTH);
                    } else {
                        car.setDirection(Vehicle.Direction.NORTH);
                    }
                    car.move();
                    frame.drawPanel.moveit(x, y);
                    DrawPanel.flipped = true;
                    frame.drawPanel.repaint();
                }
            }
        }

    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars
        ) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars){
            car.brake(brake);

        }
    }

    void startEngine(){
        for (Car car : cars){
            car.startEngine();
        }
    }

    void stopEngine(){
        for (Car car : cars){
            car.stopEngine();
        }
    }

     static void turnRight(){
        for (Car car : cars){
            car.turnRight();
        }
    }
    static void turnLeft(){
        for (Car car: cars){
            car.turnLeft();
        }
    }

    static void up(){
        for (Car car: cars){
            car.up();
        }
    }
    static void down(){
        for(Car car: cars){
            car.down();
        }
    }


}
