package com;

import javax.swing.*;
import java.awt.*;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Timer;

public class Villain extends JButton {

    private int x;
    private int y;
    private int width;
    private int height;
    private long startTime;
    private boolean isClicked;
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

                while(true) {
                    while(!isSpawned) {

                        int maxWidth = Main.mainClickerMiddleLayout.getWidth() - width;
                        int maxHeight = Main.mainClickerMiddleLayout.getHeight() - height;
                        int randomX = ThreadLocalRandom.current().nextInt(0, maxWidth);
                        int randomY = ThreadLocalRandom.current().nextInt(0, maxHeight);

                        int buttonXleft = Main.mainClickerMiddleButton.getX();
                        int buttonXright = Main.mainClickerMiddleButton.getX() + Main.mainClickerMiddleButton.getWidth();
                        int buttonYtop = Main.mainClickerMiddleButton.getY();
                        int buttonYbottom = Main.mainClickerMiddleButton.getY() + Main.mainClickerMiddleButton.getHeight();

                        int allowedXleft = buttonXleft - width;
                        int allowedXright = buttonXright;
                        int allowedYtop = buttonYtop - height;
                        int allowedYbottom = buttonYbottom;

                        if(((allowedYtop - randomY) >= 0)) System.out.println("ytop");
                        if(((allowedXleft - randomX) >= 0)) System.out.println("xleft");
                        if((allowedYbottom <= randomY)) System.out.println("ybot");
                        if((allowedXright <= randomX)) System.out.println("xright");
                        System.out.println();



                        this.x = randomX;
                        this.y = randomY;

                        int random = 5*1000;//ThreadLocalRandom.current().nextInt(0, 10*60*1000);
                        Thread.sleep(random);
                        this.setBounds(x, y, width, height);
                        //this.setBackground(Color.red);
                        //System.out.println("set");
                        isSpawned = true;
                        this.setEnabled(true);

                        this.show();
                    }
                    Thread.sleep(1000);
                    //System.out.println(isSpawned);

                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }



        }).start();


    }



}
