package com;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;

public class Villain extends JButton {

    private int x;
    private int y;
    private  int width;
    private  int height;
    private static boolean isSpawned;

    public Villain(int buttonWidth, int buttonHeight) {

        this.width = buttonWidth;
        this.height = buttonHeight;

        try {
            BufferedImage buttonIcon = ImageIO.read(getClass().getResource("/com/assets/normaldogvillain.png"));
            this.setIcon(new ImageIcon(buttonIcon));
            this.setBorder(BorderFactory.createEmptyBorder());
            this.setContentAreaFilled(false);

        } catch (Exception e) {
            e.printStackTrace();
        }


        isSpawned = false;
        spawnVillain();
        this.addActionListener(e -> {
            isSpawned = false;
            this.setVisible(false);
        });
    }

    private void spawnVillain() {

        new Thread(() -> {
            try {
                Thread.sleep(0); //10 minutes -> initial countdown

                while (true) {
                    while (!isSpawned) {

                        int maxWidth = Main.mainClickerMiddleLayout.getWidth() - width;
                        int maxHeight = Main.mainClickerMiddleLayout.getHeight() - height;
                        int randomX;
                        int randomY;


                        int buttonXleft = Main.mainClickerMiddleButton.getX();
                        int buttonXright = Main.mainClickerMiddleButton.getX() + Main.mainClickerMiddleButton.getWidth();
                        int buttonYtop = Main.mainClickerMiddleButton.getY();
                        int buttonYbottom = Main.mainClickerMiddleButton.getY() + Main.mainClickerMiddleButton.getHeight();

                        int allowedXleft = buttonXleft - width;
                        int allowedXright = buttonXright;
                        int allowedYtop = buttonYtop - height;
                        int allowedYbottom = buttonYbottom;

                        do {
                            randomX = ThreadLocalRandom.current().nextInt(0, maxWidth);
                            randomY = ThreadLocalRandom.current().nextInt(0, maxHeight);
                        } while (!((allowedYtop - randomY) >= 0) && !((allowedXleft - randomX) >= 0) && !(allowedYbottom <= randomY) && !(allowedXright <= randomX));

                        this.x = randomX;
                        this.y = randomY;

                        int random = ThreadLocalRandom.current().nextInt(0, 10*60*1000);
                        Thread.sleep(5*1000);

                        this.setBounds(x, y, width, height);


                        isSpawned = true;
                        //this.setEnabled(true);

                        this.show();
                    }
                    while(isSpawned){
                        BigDecimal currentMoney = new BigDecimal(Main.amountTotalClicks.getCount());
                        currentMoney = currentMoney.multiply(BigDecimal.valueOf(0.0005));
                        //Main.amountTotalClicks.increaseCounter(currentMoney.multiply(new BigDecimal(-1)));
                        Thread.sleep(1000);
                    }
                    Thread.sleep(1000);

                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();
    }
}
