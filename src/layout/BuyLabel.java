package layout;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;

public class BuyLabel extends JLabel {

    BufferedImage image;


    public BuyLabel(int x, int y, int width, int height, String fileName) {
        this.setBounds(x, y, width, height);
        this.setImage(fileName);
    }

    public boolean setImage(String fileName) {
        try {
            image = ImageIO.read(getClass().getResource("/assets/" + fileName));
            return true;
        } catch(Exception e) {
            return false;
        }
    }


}
