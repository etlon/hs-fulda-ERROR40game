package com;
import com.buyables.ItemGrandma;
import com.buyables.ItemYarn;
import com.buyables.ShopItem;

import java.math.BigDecimal;

public class Shop {
    private ShopItem[] itemList;

    public Shop() {
        this.fillItemList();
    }

    public double getIncome() {
        double income = 0;
        for (ShopItem item : itemList) {
            income += item.getIncome();
        }
        return income;
    }

    public void fillItemList() {
        //create every buyable item once and put it into "itemList"
        itemList = new ShopItem[2];
        //Created just for testing purposes need further updates
        itemList[0] = new ItemGrandma();
        itemList[1] = new ItemYarn();
    }

    public void saveItems() {
        for (ShopItem item : itemList) {
            Main.fm.addValueByKey(item.getName(), "" + item.getAmount());
        }
    }

    public int getAmountItems() {
        return itemList.length;
    }

    public ShopItem[] getItemList() {
        return itemList;
    }


    public void buyItem(ShopItem item) {
        if (Main.amountTotalClicks.getDecimalCount().compareTo(new BigDecimal(item.getPrice())) >= 0) {

            Main.amountTotalClicks.increaseCounter(0 - item.getPrice());
            item.buy();

        }
    }
}
