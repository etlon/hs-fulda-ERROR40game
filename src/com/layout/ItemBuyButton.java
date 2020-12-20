package com.layout;

import com.Main;
import com.buyables.ShopItem;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;

public class ItemBuyButton extends JButton {

    ShopItem item;

    public ItemBuyButton(ShopItem item) {
        this.item = item;
        this.setText(item.getName());
        this.setPreferredSize(new Dimension(120,100));
        this.addActionListener(e -> {
            BigDecimal dm = new BigDecimal(Main.amountTotalClicks.getCount());
            if(dm.compareTo(new BigDecimal("" + item.getPrice())) >= 0) {
                item.buy();
                Main.amountTotalClicks.setText(Main.amountTotalClicks.formatCounter(new BigDecimal(String.valueOf(item.getPrice()))));
                System.out.println("gekauft: " + item.getName() + " " + item.getPrice());
            } else {
                System.out.println("izz nicht");
            }
        });
    }



}
