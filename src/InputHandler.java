import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
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
        view.getTurboOffButton().addActionListener(e -> cc.turboOff());
        view.getTurboOnButton().addActionListener(e -> cc.turboOn());
        view.getUnloadButton().addActionListener(e -> cc.unloadCarFromShopRandom());

    }
}