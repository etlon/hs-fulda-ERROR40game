package com.layout;


import com.AmountTotalClicksLabel;
import com.buyables.ShopItem;

import javax.swing.*;
import java.awt.*;

public class BuyMenu extends JLabel {
    private AmountTotalClicksLabel amountTotalClicks;
    private PassiveIncomeLabel passiveIncomeLabel;

    public BuyMenu(int x, int y, int width, int height, AmountTotalClicksLabel amountTotalClicks, PassiveIncomeLabel passiveIncomeLabel) {
        this.setBounds(x, y, width, height);
        //this.setBorder(new EmptyBorder(0,10,0,0));
        this.setFont(new Font("Arial Black", Font.PLAIN, 30));
        this.setVerticalAlignment(JLabel.BOTTOM);
        this.amountTotalClicks = amountTotalClicks;
        this.passiveIncomeLabel = passiveIncomeLabel;
    }

    public void addPanels(ShopItem[] list) {

        ItemBuyButton[] buttons = new ItemBuyButton[list.length];
        for (int i = 0; i < list.length; i++) {

            buttons[i] = new ItemBuyButton(buttons, i, list[i], amountTotalClicks, passiveIncomeLabel);
            ItemBuyPanel panel = new ItemBuyPanel(0, i * (630 / list.length), 182, (630 / list.length), buttons[i]);
            panel.setOpaque(false);
            //panel.setBackground(new Color(0xD51515));
            this.add(panel);
        }
    }
}