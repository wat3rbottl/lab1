import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel {

    // Images of the cars
    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;

    // To keep track of the cars positions
    Point volvoPoint = new Point(0, 100);
    Point saabPoint = new Point(0, 200);
    Point scaniaPoint = new Point(0, 300);

    // Keeps track if image should be flipped
    protected static boolean flipped = false;
    protected static boolean volvoFlipped = false;
    protected static boolean saabFlipped = false;
    protected static boolean scaniaFlipped = false;

    BufferedImage volvoWorkshopImage;
    Point volvoWorkshopPoint = new Point(300, 300);

    // TODO: Make this general for all cars
    void moveit(Vehicle v, int x, int y, boolean flipped) {
        if (v instanceof Volvo240) {
            volvoPoint.x = x;
            volvoPoint.y = y;
            volvoFlipped = flipped;
        } else if (v instanceof Saab95) {
            saabPoint.x = x;
            saabPoint.y = y;
            saabFlipped = flipped;
        } else { // Scania eller annan Vehicle
            scaniaPoint.x = x;
            scaniaPoint.y = y;
            scaniaFlipped = flipped;
        }
    }

    // CarController obj
    private final CarController controller;
    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, CarController controller) {
        this.controller = controller;
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.pink);
        // Print an error message in case file is not found with a try/catch block
        try {
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("/pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("/pics/Scania.jpg"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        // Makes program accept keyboard commands
        setupKeyBindings();
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // Changed so image is inverted when "flipped" is true

    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
        g.drawImage(saabImage, saabPoint.x, saabPoint.y, null);
        g.drawImage(scaniaImage, scaniaPoint.x, scaniaPoint.y, null);

        if (volvoFlipped) {
            g.drawImage(volvoImage, volvoPoint.x + volvoImage.getWidth(), volvoPoint.y, -volvoImage.getWidth(), volvoImage.getHeight(), null);
        } else {
            g.drawImage(volvoImage, volvoPoint.x, volvoPoint.y, null);
        }// see javadoc for more info on the parameters
        if (saabFlipped) {
            g.drawImage(saabImage, saabPoint.x + saabImage.getWidth(), saabPoint.y, - saabImage.getWidth(), saabImage.getHeight(), null);
        } else {
            g.drawImage(saabImage, saabPoint.x, saabPoint.y, null);
        }
        if (scaniaFlipped)
        { g.drawImage(scaniaImage, scaniaPoint.x + scaniaImage.getWidth(), scaniaPoint.y, - scaniaImage.getWidth(), scaniaImage.getHeight(), null);}
        else {
            g.drawImage(scaniaImage, scaniaPoint.x, scaniaPoint.y, null);
        }
    }
        /// ////Keyboard setup:///////
        // Sets arrow keys to move the car in different directions
        private void setupKeyBindings() {
            InputMap im = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
            ActionMap am = getActionMap();

            im.put(KeyStroke.getKeyStroke("LEFT"), "left");
            im.put(KeyStroke.getKeyStroke("RIGHT"), "right");
            im.put(KeyStroke.getKeyStroke("UP"), "up");
            im.put(KeyStroke.getKeyStroke("DOWN"), "down");

            am.put("left", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    controller.turnLeft();
                    repaint();
                }
            });

            am.put("right", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    controller.turnRight();
                    repaint();
                }
            });

            am.put("up", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    controller.up();
                    repaint();
                }
            });

            am.put("down", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    controller.down();
                    repaint();
                }
            });
        }
}
