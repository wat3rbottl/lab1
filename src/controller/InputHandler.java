package controller;

import view.CarView;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class InputHandler {
    private final CarController cc;

    public InputHandler(CarController cc) {
        this.cc = cc;
    }

    // Keyboard set up
    public void setupKeyBindings(JComponent component) {

        InputMap im = component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = component.getActionMap();

        im.put(KeyStroke.getKeyStroke("LEFT"), "left");
        im.put(KeyStroke.getKeyStroke("RIGHT"), "right");
        im.put(KeyStroke.getKeyStroke("UP"), "up");
        im.put(KeyStroke.getKeyStroke("DOWN"), "down");

        am.put("left", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cc.turnLeft();

            }
        });

        am.put("right", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cc.turnRight();

            }
        });

        am.put("up", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cc.up();

            }
        });

        am.put("down", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cc.down();

            }
        });
    }

    // Binding clickable buttons
    public void bindButtons(CarView view) {

        view.getGasButton().addActionListener(e -> cc.gas(view.getGasAmount()));
        view.getBrakeButton().addActionListener(e -> cc.brake(view.getBrakeAmount()));
        view.getLiftBedButton().addActionListener(e -> cc.raiseBed());
        view.getLowerBedButton().addActionListener(e -> cc.lowerBed());
        view.getStartButton().addActionListener(e -> cc.startEngine());
        view.getStopButton().addActionListener(e -> cc.stopEngine());
       // view.getTurboOffButton().addActionListener(e -> cc.turboOff());
        view.getTurboOnButton().addActionListener(e -> cc.toggleTurbo());
       // view.getToggleTurboButton().addActionListener(e->cc.toggleTurbo());
        view.getUnloadButton().addActionListener(e -> cc.unloadCarFromShopRandom());
        view.getAddCarButton().addActionListener(e-> cc.addCar());
        view.getRemoveCarButton().addActionListener(e->cc.removeCar());

    }
}