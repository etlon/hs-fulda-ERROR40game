package com;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MainClickerMiddleButton extends JButton {

    /**
     * @param x origin of button on x axis
     * @param y origin of button on y axis
     * @param width width of button
     * @param height height of button
     */

    int xCord;
    int yCord;
    int width;
    int height;
    boolean isRunning;

    public MainClickerMiddleButton(int x, int y, int width, int height) throws IOException {

        this.xCord = x;
        this.yCord = y;
        this.width = width;
        this.height = height;
        this.isRunning = false;

        this.setBounds(this.xCord, this.yCord, this.width, this.height);

        try {
            BufferedImage buttonIcon = ImageIO.read(getClass().getResource("/com/assets/bongocatresized.png"));
            this.setIcon(new ImageIcon(buttonIcon));
            this.setBorder(BorderFactory.createEmptyBorder());
            this.setContentAreaFilled(false);
            this.addActionListener(e -> {
                Main.amountTotalClicks.increaseCounter();

                try {
                    doButtonAnimation();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            });

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void doButtonAnimation() throws IOException {
        if (isRunning) return;

        BufferedImage buttonIcon = ImageIO.read(getClass().getResource("/com/assets/bongocatresized.png"));
        ImageIcon gif = new ImageIcon(this.getClass().getResource("/com/assets/bongocat.gif"));

        new Thread(() -> {
            this.isRunning = true;

            try {
                setIcon(gif);
                Thread.sleep(600);
                setIcon(new ImageIcon(buttonIcon));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.isRunning = false;
        }).start();
    }
}



