package pplot;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImagePanel extends JPanel {
    public ImagePanel() {
        try {
            BufferedImage image_buffer = ImageIO.read(new File("ilus.png"));
            ImageIcon imageIcon = new ImageIcon(image_buffer);
            Image image = imageIcon.getImage(); // transform it
            Image newimg = image.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            imageIcon = new ImageIcon(newimg);  // transform it back
            JLabel label;
            label = new JLabel(imageIcon);
            add(label);
        }
        catch (Exception e) {
            System.out.println("Img not found");
        }
    }

}