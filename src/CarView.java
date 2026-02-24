import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class CarView extends JFrame {
    private static final int X = 800;
    private static final int Y = 800;
    private static final int Y_LIMIT = 800 - 240;

    DrawPanel drawPanel;
    JPanel controlPanel = new JPanel();

    //Gas wiring
    private final JPanel gasPanel = new JPanel();
    private final JSpinner gasSpinner;
    private final JLabel gasLabel = new JLabel("Amount of gas");

    //Brake wiring
    private final JPanel brakePanel = new JPanel();
    private final JLabel brakeLabel = new JLabel("Amount of brake");
    private final JSpinner brakeSpinner;

    // Buttons
    private final JButton gasButton = new JButton("Gas");
    private final JButton brakeButton = new JButton("Brake");
    private final JButton turboOnButton = new JButton("Saab Turbo on");
    private final JButton turboOffButton = new JButton("Saab Turbo off");
    private final JButton liftBedButton = new JButton("Raise Bed");
    private final JButton lowerBedButton = new JButton("Lower Bed");
    private final JButton startButton = new JButton("Start all cars");
    private final JButton stopButton = new JButton("Stop all cars");

    // Constructor
    public CarView(String frameName, ImageHandler imageHandler) {
        this.drawPanel = new DrawPanel(X, Y_LIMIT, imageHandler);

        // Spinners
        SpinnerModel gasModel = new SpinnerNumberModel(0, 0, 100, 1);
        SpinnerModel brakeModel = new SpinnerNumberModel(0, 0, 100, 1);
        this.gasSpinner = new JSpinner(gasModel);
        this.brakeSpinner = new JSpinner(brakeModel);

        initComponents(frameName);
    }

    public void setVehicles(List<Vehicle> vehicles) {
        drawPanel.setVehicles(vehicles);
    }

    private void initComponents(String title) {
        setTitle(title);
        setPreferredSize(new Dimension(X, Y));
        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        add(drawPanel);

        // Gas panel
        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);
        add(gasPanel);

        // Brake panel
        brakePanel.setLayout(new BorderLayout());
        brakePanel.add(brakeLabel, BorderLayout.PAGE_START);
        brakePanel.add(brakeSpinner, BorderLayout.PAGE_END);
        add(brakePanel);

        // Control panel
        controlPanel.setLayout(new GridLayout(2, 4));
        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);

        controlPanel.setPreferredSize(new Dimension((X / 2) + 4, 200));
        controlPanel.setBackground(Color.pink);
        add(controlPanel);

        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.pink);
        startButton.setPreferredSize(new Dimension(X / 5 - 15, 200));
        add(startButton);

        stopButton.setBackground(Color.WHITE);
        stopButton.setForeground(Color.pink);
        stopButton.setPreferredSize(new Dimension(X / 5 - 15, 200));
        add(stopButton);

        pack();
        centerOnScreen();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void centerOnScreen() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - getSize().width / 2,
                dim.height / 2 - getSize().height / 2);
    }

    public DrawPanel getDrawPanel() {
        return drawPanel;
    }

    public int getGasAmount() {
        try {
            gasSpinner.commitEdit();
        } catch (java.text.ParseException ignored) {
        }
        return (int) gasSpinner.getValue();
    }

    public int getBrakeAmount() {
        return (int) brakeSpinner.getValue();
    }

    public JButton getGasButton() {
        return gasButton;
    }

    public JButton getBrakeButton() {
        return brakeButton;
    }

    public JButton getTurboOnButton() {
        return turboOnButton;
    }

    public JButton getTurboOffButton() {
        return turboOffButton;
    }

    public JButton getLiftBedButton() {
        return liftBedButton;
    }

    public JButton getLowerBedButton() {
        return lowerBedButton;
    }

    public JButton getStartButton() {
        return startButton;
    }

    public JButton getStopButton() {
        return stopButton;
    }
}