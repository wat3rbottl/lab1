package view;

import interfaces.SimulationObserver;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.util.List;

public class DrawPanel extends JPanel implements SimulationObserver {

    private final ImageHandler imageHandler;
    private List<RenderItem> items = List.of();

    //Initializes the panel
    public DrawPanel(int width, int height, ImageHandler imageHandler) {
        this.imageHandler = imageHandler;

        setDoubleBuffered(true);
        setPreferredSize(new Dimension(width, height));
        setBackground(new Color(255, 130, 180));
    }

    @Override
    public void onTick(List<RenderItem> items) {
        this.items = items;
        repaint();
    }

    public void setRenderItems(List<RenderItem> items) {
        this.items = items;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (RenderItem item : items) {
            BufferedImage img = imageHandler.get(item.imageId());
            if (img == null) {
                continue;
            } // Fixa nån nödlösning, typ rita leksaksbil eller nåt.

            int x = item.x();
            int y = item.y();

            if (item.flipX()) {
                g.drawImage(img, x + img.getWidth(), y, -img.getWidth(), img.getHeight(), null);
            } else {
                g.drawImage(img, x, y, null);
            }
        }
    }
}