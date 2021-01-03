package com;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.concurrent.ThreadLocalRandom;

public class Villain extends JButton {

    private int x;
    private int y;
    private int width;
    private int height;
    private DecimalFormat df;
    private static boolean isSpawned;
    private static int startCooldown = 10 * 60 * 1000;
    private static int minTimeCooldown = 2 * 60 * 1000;
    private static int maxTimeCooldown = 7 * 60 * 1000;
    private static double percentageLossVillain = 0.5;

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

        df = new DecimalFormat("0");
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
                Thread.sleep(startCooldown); //10 minutes -> initial countdown

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

                        int random = ThreadLocalRandom.current().nextInt(minTimeCooldown, maxTimeCooldown);
                        Thread.sleep(random);

                        this.setBounds(x, y, width, height);
                        isSpawned = true;
                        this.show();
                    }
                    while (isSpawned) {
                        BigDecimal currentMoney = new BigDecimal(Main.amountTotalClicks.getCount());
                        if (ToolManager.compareBigDecimal(currentMoney, new BigDecimal(5)) > 1) {
                            currentMoney = currentMoney.multiply(BigDecimal.valueOf(percentageLossVillain / 100));
                            currentMoney = new BigDecimal(df.format(currentMoney.doubleValue()));
                            Main.amountTotalClicks.increaseCounter(currentMoney.multiply(new BigDecimal(-1)));
                        }
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
