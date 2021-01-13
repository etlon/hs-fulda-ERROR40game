package com.layout;

import javax.swing.JPanel;

public class SimpleLayout extends JPanel {

    public SimpleLayout(int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);
        this.setLayout(null);
    }
}
