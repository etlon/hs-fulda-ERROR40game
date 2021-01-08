package com.layout;

import com.AmountTotalClicksLabel;
import com.Main;
import com.buyables.ShopItem;

import java.awt.*;
import java.math.BigDecimal;

public class IsItemBuyableThread extends Thread {
    private ShopItem item;
    private ItemBuyButton button;
    private AmountTotalClicksLabel amountTotalClicks;

    public IsItemBuyableThread(ShopItem item, ItemBuyButton button, AmountTotalClicksLabel amountTotalClicks) {
        this.item = item;
        this.button = button;
        this.amountTotalClicks = amountTotalClicks;
    }


    public void run() {
        while (true) {
            if (new BigDecimal(amountTotalClicks.getCount()).compareTo(new BigDecimal(String.valueOf(item.getPrice()))) >= 0) {
                button.setBackground(Color.GREEN);
            } else {
                button.setBackground(Color.ORANGE);
            }
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
