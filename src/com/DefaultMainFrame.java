package com;

import javax.swing.*;

public class DefaultMainFrame extends JFrame {

    /**
     *
     * @param width width of the whole game
     * @param height height of the whole game
     */

    public DefaultMainFrame(int width, int height) {
        this.setSize(width, height);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
    }

}