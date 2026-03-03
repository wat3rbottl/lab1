package controller;

import factory.*;
import model.simulation.*;
import model.vehicle.Vehicle;
import view.CarView;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarController {
    private final int delay = 50;
    private Timer timer;
    private Simulation simulation;
    private InputHandler input;
    private CarView carView;
    private final VehicleFactory factory = new StandardVehicleFactory();

    public CarController(Simulation simulation) {
        this.simulation = simulation;
        this.timer = new Timer(delay, new TimerListener());
    }

    public void setView(CarView view) {
        this.carView = view;
    }

    public void initInput() {
        this.input = new InputHandler(this);
        input.setupKeyBindings(carView.getRootPane());
        input.bindButtons(carView);
    }

    public void startTimer() {
        timer.start();
    }

    public void stopTimer() {
        timer.stop();
    }

    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            simulation.tick();
            }
    }

    void gas(double amount) {
        simulation.gasAll((double) amount / 100);
    }

    void brake(double amount) {
        simulation.brakeAll((double) amount / 100);
    }

    void startEngine() {
        simulation.startAll();
    }

    void stopEngine() {
        simulation.stopAll();
    }

    void turnRight() {
        simulation.turnRightAll();
    }

    void turnLeft() {
        simulation.turnLeftAll();
    }

    void up() {
        simulation.upAll();
    }

    void down() {
        simulation.downAll();
    }

    void toggleTurbo(){simulation.toggleTurbo();}

    void lowerBed() {
        simulation.lowerBed();
    }

    void raiseBed() {
        simulation.raiseBed();
    }

    public void unloadCarFromShopRandom() {
        simulation.unloadCarFromShopRandom();
    }

    void addCar() {
        if (simulation.getVehicleCount() < 10) {
            Vehicle v = factory.createVehicle(randomVehicleType());
            v.setPosition(100, 100);
            simulation.addVehicle(v);
        }
    }

    void removeCar() {
        simulation.removeVehicle();
    }

    private VehicleType randomVehicleType() {
        VehicleType[] types = VehicleType.values();
        return types[(int) (Math.random() * types.length)];
    }

}

