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
        this.setText("<html>" + item.getName() +"<br />" + item.getPrice() + "<br/>" + item.getAmount() + "</html>");
        this.setPreferredSize(new Dimension(120,100));
        this.addActionListener(e -> {
            BigDecimal dm = new BigDecimal(Main.amountTotalClicks.getCount());
            double itemPrice = item.getPrice();
            if(dm.compareTo(new BigDecimal(String.valueOf(itemPrice))) >= 0) {
                Main.amountTotalClicks.increaseCounter(String.valueOf(0 - itemPrice));
                item.buy();
                this.setText("<html>" + item.getName() +"<br />" + item.getPrice() + "<br/>" + item.getAmount() + "</html>");
                System.out.println("gekauft: " + item.getName() + " " + itemPrice + " " + item.getAmount());
            }
        });
    }



}
