import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class MainClickerMiddleButton extends JButton {

    /**
     *
     * @param x origin of button on x axis
     * @param y origin of button on y axis
     * @param width width of button
     * @param height height of button
     */

    public MainClickerMiddleButton(int x, int y, int width, int height) {

        this.setBounds(x, y, width, height);
        this.setBackground(Color.CYAN);

        try {
            BufferedImage buttonIcon = ImageIO.read(new File("Game/assets/bongocatresized.png"));
            this.setIcon(new ImageIcon(buttonIcon));
            //this.setBorder(BorderFactory.createEmptyBorder());
            //this.setContentAreaFilled(false);
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
