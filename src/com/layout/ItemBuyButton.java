package com.layout;

import com.Main;
import com.ToolManager;
import com.buyables.ShopItem;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;

public class ItemBuyButton extends JButton {

    private ShopItem item;
    private ItemBuyButton[] buttons;
    private int index;

    public ItemBuyButton(ItemBuyButton[] buttons, int index, ShopItem item) {
        this.item = item;
        this.buttons=buttons;
        this.index=index;
        if(this.index!=0){
            if(buttons[this.index-1].getItem().getAmount()==0) super.setEnabled(false);
            else this.runBuyableTest();
        }
        else this.runBuyableTest();

        String price = ToolManager.formatCounter(BigDecimal.valueOf(item.getPrice()));
        this.setText("<html>" + item.getName() +"<br />" + price + "<br/>" + item.getAmount() + "</html>");
        this.setPreferredSize(new Dimension(120,100));
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.addActionListener(e -> {
            BigDecimal dm = new BigDecimal(Main.amountTotalClicks.getCount());
            double itemPrice = item.getPrice();
            if(dm.compareTo(new BigDecimal(String.valueOf(itemPrice))) >= 0) {
                Main.amountTotalClicks.increaseCounter(String.valueOf(0 - itemPrice));
                item.buy();
                String name = item.getName();
                String s = ToolManager.formatCounter(new BigDecimal(String.valueOf(item.getPrice())));

                this.setText("<html>" + item.getName() +"<br />" + s + "<br/>" + item.getAmount() + "</html>");
                System.out.println("gekauft: " + item.getName() + " " + itemPrice + " " + item.getAmount());
                Main.passiveIncomeLabel.updatePassiveIncome();

                if(item.getAmount()>0&&index< buttons.length-1)
                {
                    buttons[index+1].setEnabled(true);
                    buttons[index+1].runBuyableTest();
                }
            }
        });
    }
    private ShopItem getItem()
    {
        return item;
    }

    private void runBuyableTest()
    {
        Thread t=new IsItemBuyableThread(item,this);
        t.start();
    }



}
