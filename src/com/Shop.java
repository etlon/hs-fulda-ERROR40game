package com;

import com.buyables.*;

import java.math.BigDecimal;

public class Shop {

    private ShopItem[] itemList;

    public Shop() {
        this.fillItemList();
    }

    public BigDecimal getIncome() {
        BigDecimal income = new BigDecimal(0);
        for (ShopItem item : itemList) {
            income = income.add(item.getIncome());
        }
        return income;
    }

    public void fillItemList() {
        //create every buyable item once and put it into "itemList"
        itemList = new ShopItem[7];
        //Created just for testing purposes need further updates
        itemList[0] = new ItemYarn();
        itemList[1] = new ItemBlanket();
        itemList[2] = new ItemPremiumFood();
        itemList[3] = new ItemGrandma();
        itemList[4] = new ItemDJKittenz();
        itemList[5] = new ItemLaserpointer();
        itemList[6] = new ItemMagicalTree();
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
