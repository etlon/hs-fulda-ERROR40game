package com;

import com.buyables.ItemBlanket;
import com.buyables.ItemDjKittenz;
import com.buyables.ItemGrandma;
import com.buyables.ItemPremiumFood;
import com.buyables.ItemYarn;
import com.buyables.ShopItem;
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
        itemList = new ShopItem[]{
            new ItemYarn(),
            new ItemBlanket(),
            new ItemPremiumFood(),
            new ItemGrandma(),
            new ItemDjKittenz()
        };
    }

    public ShopItem[] getItemList() {
        return itemList;
    }
}
