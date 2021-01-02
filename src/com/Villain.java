package com;

import javax.swing.*;
import java.util.concurrent.ThreadLocalRandom;

public class Villain extends JButton {

    private int x;
    private int y;
    private final int width;
    private final int height;
    private final long startTime;
    private static boolean isClicked;
    private static boolean isSpawned;

    public Villain(int buttonWidth, int buttonHeight) {

        this.width = buttonWidth;
        this.height = buttonHeight;
        this.startTime = System.currentTimeMillis();
        isSpawned = false;
        spawnVillain();
        this.addActionListener(e -> {
            isSpawned = false;
            this.setEnabled(false);
            this.setVisible(false);
        });
    }

    private void spawnVillain() {

        new Thread(() -> {
            try {
                Thread.sleep(0);

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

                        int random = 5 * 1000;//ThreadLocalRandom.current().nextInt(0, 10*60*1000);
                        Thread.sleep(random);
                        this.setBounds(x, y, width, height);
                        //this.setBackground(Color.red);
                        //System.out.println("set");
                        isSpawned = true;
                        this.setEnabled(true);

                        this.show();
                    }
                    Thread.sleep(1000);

                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();
    }
}
