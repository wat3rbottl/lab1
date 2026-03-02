package view;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ImageHandler {
    private final Map<String, BufferedImage> images = new HashMap<>();

    public ImageHandler() {
        add("Volvo240", "/pics/Volvo240.jpg");
        add("Saab95", "/pics/Saab95.jpg");
        add("Scania", "/pics/Scania.jpg");
        add("VolkswagenUnicorn", "/pics/VolkswagenUnicorn.jpg");
        add("Saab95Shop", "/pics/Saab95Shop.jpg");
        add("Volvo240Shop",  "/pics/Volvo240Shop.jpg");
        add("GeneralShop",  "/pics/GeneralShop.jpg");
    }

    private void add(String imageID, String imagePath) {
        try {
            BufferedImage img = ImageIO.read(ImageHandler.class.getResourceAsStream(imagePath));
            images.put(imageID, img);
        } catch (IOException | IllegalArgumentException e) {
            throw new RuntimeException("Could not find image: " + imagePath + " .", e);
        }
    }

    BufferedImage get(String imageID) {
        return images.get(imageID);
    }
}
