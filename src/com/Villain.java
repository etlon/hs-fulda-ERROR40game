package com;

import com.layout.MainClickerMiddleLayout;
import java.awt.image.BufferedImage;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.concurrent.ThreadLocalRandom;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;


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
    private MainClickerMiddleLayout mainClickerMiddleLayout;
    private MainClickerMiddleButton mainClickerMiddleButton;
    private AmountTotalClicksLabel amountTotalClicks;

    public Villain(int buttonWidth, int buttonHeight, MainClickerMiddleLayout mainClickerMiddleLayout,
                   MainClickerMiddleButton mainClickerMiddleButton, AmountTotalClicksLabel amountTotalClicks) {

        this.width = buttonWidth;
        this.height = buttonHeight;
        this.mainClickerMiddleLayout = mainClickerMiddleLayout;
        this.mainClickerMiddleButton = mainClickerMiddleButton;
        this.amountTotalClicks = amountTotalClicks;

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

                        int maxWidth = mainClickerMiddleLayout.getWidth() - width;
                        int maxHeight = mainClickerMiddleLayout.getHeight() - height;
                        int randomX;
                        int randomY;

                        int buttonXleft = mainClickerMiddleButton.getX();
                        int buttonXright = mainClickerMiddleButton.getX() + mainClickerMiddleButton.getWidth();
                        int buttonYtop = mainClickerMiddleButton.getY();
                        int buttonYbottom = mainClickerMiddleButton.getY() + mainClickerMiddleButton.getHeight();

                        int allowedXleft = buttonXleft - width;
                        int allowedXright = buttonXright;
                        int allowedYtop = buttonYtop - height;
                        int allowedYbottom = buttonYbottom;

                        do {
                            randomX = ThreadLocalRandom.current().nextInt(0, maxWidth);
                            randomY = ThreadLocalRandom.current().nextInt(0, maxHeight);
                        } while (!((allowedYtop - randomY) >= 0) && !((allowedXleft - randomX) >= 0)
                                && !(allowedYbottom <= randomY) && !(allowedXright <= randomX));

                        this.x = randomX;
                        this.y = randomY;

                        int random = ThreadLocalRandom.current().nextInt(minTimeCooldown, maxTimeCooldown);
                        Thread.sleep(random);

                        this.setBounds(x, y, width, height);
                        isSpawned = true;
                        this.show();
                    }
                    while (isSpawned) {
                        BigDecimal currentMoney = new BigDecimal(amountTotalClicks.getCount());
                        if (ToolManager.compareBigDecimal(currentMoney, new BigDecimal(5)) > 1) {
                            currentMoney = currentMoney.multiply(BigDecimal.valueOf(percentageLossVillain / 100));
                            currentMoney = new BigDecimal(df.format(currentMoney.doubleValue()));
                            amountTotalClicks.increaseCounter(currentMoney.multiply(new BigDecimal(-1)));
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
