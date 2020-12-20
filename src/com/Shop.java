package com;

import com.buyables.*;

public class Shop
{

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
        itemList = new ShopItem[5];
        //Created just for testing purposes need further updates
        itemList[0] = new ItemYarn();
        itemList[1] = new ItemBlanket();
        itemList[2] = new ItemPremiumCatFood();
        itemList[3] = new ItemGrandma();
        itemList[4] = new ItemDJKittenz();
    }

    public void saveItems() {
        for (ShopItem item : itemList) {
            Main.fileManager.addValueByKey(item.getName(), "" + item.getAmount());
        }
    }

    public int getAmountItems() {
        return itemList.length;
    }

    public ShopItem[] getItemList() {
        return itemList;
    }
}
