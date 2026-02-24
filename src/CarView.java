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
    private final JButton turboOnButton = new JButton("Turbo+");
    private final JButton turboOffButton = new JButton("Turbo-");
    private final JButton liftBedButton = new JButton("Raise Bed");
    private final JButton lowerBedButton = new JButton("Lower Bed");
    private final JButton startButton = new JButton("Start all");
    private final JButton stopButton = new JButton("Stop all");
    private final JButton unloadButton = new JButton("Unload car");

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

    private void initComponents(String title) {
        Font f = gasButton.getFont().deriveFont(10f);
        for (JButton b : List.of(gasButton, brakeButton, turboOnButton, turboOffButton, liftBedButton, lowerBedButton, unloadButton)) {
            b.setFont(f);
        }

        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(X, Y));

        // CENTER: world
        add(drawPanel, BorderLayout.CENTER);

        // SOUTH: controls
        JPanel south = new JPanel(new BorderLayout(10, 10));
        south.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        south.setPreferredSize(new Dimension(X, 170)); // styr höjden på kontrollfältet

        // LEFT: spinners (2 rader, så de aldrig klipps)
        JPanel spinnerPanel = new JPanel(new GridLayout(2, 1, 0, 8));

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.NORTH);
        gasPanel.add(gasSpinner, BorderLayout.SOUTH);

        brakePanel.setLayout(new BorderLayout());
        brakePanel.add(brakeLabel, BorderLayout.NORTH);
        brakePanel.add(brakeSpinner, BorderLayout.SOUTH);

        spinnerPanel.add(gasPanel);
        spinnerPanel.add(brakePanel);
        spinnerPanel.setPreferredSize(new Dimension(220, 150));

        south.add(spinnerPanel, BorderLayout.WEST);

        // CENTER: knappar
        controlPanel.removeAll();
        controlPanel.setLayout(new GridLayout(2, 4, 8, 8));

        controlPanel.add(gasButton);
        controlPanel.add(brakeButton);
        controlPanel.add(turboOnButton);
        controlPanel.add(turboOffButton);
        controlPanel.add(liftBedButton);
        controlPanel.add(lowerBedButton);
        controlPanel.add(unloadButton);
        controlPanel.add(new JLabel("")); // fyll sista rutan

        controlPanel.setBackground(Color.pink);
        south.add(controlPanel, BorderLayout.CENTER);

        // RIGHT: start/stop (ta bort monster-storlekar)
        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.pink);

        stopButton.setBackground(Color.WHITE);
        stopButton.setForeground(Color.pink);

        JPanel startStopPanel = new JPanel(new GridLayout(2, 1, 0, 8));
        startStopPanel.setPreferredSize(new Dimension(170, 150));
        startStopPanel.add(startButton);
        startStopPanel.add(stopButton);

        south.add(startStopPanel, BorderLayout.EAST);

        add(south, BorderLayout.SOUTH);

        pack();
        centerOnScreen();
        setVisible(true);
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

    public JButton getUnloadButton() {
        return unloadButton;
    }
}