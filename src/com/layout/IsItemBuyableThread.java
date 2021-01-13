package com.layout;

import com.AmountTotalClicksLabel;
import com.buyables.ShopItem;
import java.awt.Color;
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
            String price = String.valueOf(item.getPrice());
            String count = amountTotalClicks.getCount();
            if (new BigDecimal(count).compareTo(new BigDecimal(price)) >= 0) {
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
