package com.layout;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class MainClickerBackgroundLabel extends JLabel {

    public MainClickerBackgroundLabel(int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);
        try {
            BufferedImage buttonIcon = ImageIO.read(getClass().getResource("/com/assets/mainBackground.png"));
            this.setIcon(new ImageIcon(buttonIcon));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
