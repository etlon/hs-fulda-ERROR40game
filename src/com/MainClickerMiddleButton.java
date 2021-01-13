package com;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MainClickerMiddleButton extends JButton {

    int x;
    int y;
    int width;
    int height;
    boolean isRunning;
    AmountTotalClicksLabel amountTotalClicks;

    /**
     * @param x origin of button on x axis
     * @param y origin of button on y axis
     * @param width width of button
     * @param height height of button
     */

    public MainClickerMiddleButton(int x, int y, int width, int height, AmountTotalClicksLabel amountTotalClicks) {

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.isRunning = false;
        this.amountTotalClicks = amountTotalClicks;

        this.setBounds(this.x, this.y, this.width, this.height);

        try {
            BufferedImage buttonIcon = ImageIO.read(getClass().getResource("/com/assets/bongocatresized.png"));
            this.setIcon(new ImageIcon(buttonIcon));
            this.setBorder(BorderFactory.createEmptyBorder());
            this.setContentAreaFilled(false);
            this.addActionListener(e -> {
                amountTotalClicks.increaseCounter();

                try {
                    doButtonAnimation();
                } catch (Exception exc) {
                    exc.printStackTrace();
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doButtonAnimation() {
        if (isRunning) return;

        new Thread(() -> {
            this.isRunning = true;

            try {
                BufferedImage buttonIcon = ImageIO.read(getClass().getResource("/com/assets/bongocatresized.png"));
                ImageIcon gif = new ImageIcon(this.getClass().getResource("/com/assets/bongocat.gif"));
                setIcon(gif);
                Thread.sleep(600);
                setIcon(new ImageIcon(buttonIcon));
            } catch (Exception e) {
                e.printStackTrace();
            }

            this.isRunning = false;
        }).start();
    }
}



