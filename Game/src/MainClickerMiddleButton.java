import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainClickerMiddleButton extends JButton {

    /**
     *
     * @param x origin of button on x axis
     * @param y origin of button on y axis
     * @param width width of button
     * @param height height of button
     */

    int xCord;
    int yCord;
    int width;
    int height;

    public MainClickerMiddleButton(int x, int y, int width, int height) {

        this.xCord = x;
        this.yCord = y;
        this.width = width;
        this.height = height;


        this.setBounds(this.xCord, this.yCord, this.width, this.height);

        try {
            BufferedImage buttonIcon = ImageIO.read(new File("Game/assets/bongocatresized.png"));
            this.setIcon(new ImageIcon(buttonIcon));
            this.setBorder(BorderFactory.createEmptyBorder());
            this.setContentAreaFilled(false);
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    public void anim()
    {
        try
        {
            Thread.sleep(100);
            this.setBounds(this.xCord+37, this.yCord+37, this.width-75, this.height-75);
            BufferedImage buttonIcon = ImageIO.read(new File("Game/assets/bongocatresized75.png"));
            this.setIcon(new ImageIcon(buttonIcon));
            this.setBorder(BorderFactory.createEmptyBorder());
            this.setContentAreaFilled(false);

            Thread.sleep(150);



            this.setBounds(this.xCord, this.yCord, this.width, this.height);
            buttonIcon = ImageIO.read(new File("Game/assets/bongocatresized.png"));
            this.setIcon(new ImageIcon(buttonIcon));
            this.setBorder(BorderFactory.createEmptyBorder());
            this.setContentAreaFilled(false);



        } catch (IOException | InterruptedException e)
        {
            e.printStackTrace();
        }


    }




}
