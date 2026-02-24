import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.util.List;

public class DrawPanel extends JPanel {

    private final ImageHandler imageHandler;
    private List<Vehicle> vehicles = List.of();
    private List<WorkShop<? extends Car>> WorkShops = List.of();

    //Initializes the panel
    public DrawPanel(int width, int height, ImageHandler imageHandler) {
        this.imageHandler = imageHandler;

        setDoubleBuffered(true);
        setPreferredSize(new Dimension(width, height));
        setBackground(new Color(255, 130, 180));
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public void setWorkShops(List<WorkShop<? extends Car>> WorkShops) {
        this.WorkShops = WorkShops;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Vehicle v : vehicles) {
            BufferedImage img = imageHandler.get(v.getImageId());
            if (img == null) {
                continue;
            } // Fixa nån nödlösning, typ rita leksaksbil eller nåt.

            int x = (int) Math.round(v.getX());
            int y = (int) Math.round(v.getY());

            if (flipHorisontal(v)) {
                g.drawImage(img, x + img.getWidth(), y, -img.getWidth(), img.getHeight(), null);
            } else {
                g.drawImage(img, x, y, null);
            }
        }

        for (WorkShop ws : WorkShops) {
            BufferedImage img = imageHandler.get(ws.getImageId());
            if (img == null) {
            } // Fixa nån nödlösning, typ rita leksaksbil eller nåt.
            int x = (int) Math.round(ws.getX());
            int y = (int) Math.round(ws.getY());
            g.drawImage(img, x, y, null);

        }
    }

    // Handles if image should flip
    private boolean flipHorisontal(Vehicle v) {
        return v.getDirection() == Vehicle.Direction.WEST;
    }
}