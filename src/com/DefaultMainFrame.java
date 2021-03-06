package com;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class DefaultMainFrame extends JFrame {

    /**
     * @param width  width of the whole game
     * @param height height of the whole game
     */

    public DefaultMainFrame(int width, int height) {
        this.setSize(width, height);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        ImageIcon img = new ImageIcon(this.getClass().getResource("/com/assets/windowsicon.png"));
        this.setIconImage(img.getImage());

    }

}