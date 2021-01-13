package com.layout;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;

public class ItemBuyPanel extends JPanel {

    public ItemBuyPanel(int x, int y, int width, int height, ItemBuyButton button) {
        this.setBounds(x, y, width, height);
        this.setOpaque(true);
        //this.setBackground(Color.WHITE);
        this.setLayout(new GridBagLayout());
        this.add(button, new GridBagConstraints());

    }

}
