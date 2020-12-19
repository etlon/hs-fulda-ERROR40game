import buyables.ItemGrandma;
import buyables.ItemYarn;
import buyables.ShopItem;

import javax.swing.*;
import java.math.BigDecimal;

public class Shop
{
    private ShopItem[] itemList;

    public Shop()
    {
        this.fillItemList();
    }

    public double getIncome()
    {
        double income = 0;
        for (ShopItem item : itemList) {
            income += item.getIncome();
        }
        return income;
    }

    public void fillItemList(){
        //create every buyable item once and put it into "itemList"
        itemList=new ShopItem[2];
        //Created just for testing purposes need further updates
        itemList[0]=new ItemGrandma();
        itemList[1]=new ItemYarn();
    }

    public void saveItems(){
        for (ShopItem item : itemList) {
            Main.fm.addValueByKey(item.getName(), "" + item.getAmount());
        }
    }

    public int getAmountItems(){
        return itemList.length;
    }

    public ShopItem[] getItemList()
    {
        return itemList;
    }

    public ShopItem getClickedItem(JLabel label, JLabel[] labelArray)
    {
        for (int i = 0; i < labelArray.length; i++)
        {
            if(labelArray[i].equals(label))
            {
                return itemList[i];
            }
        }
        return null;
    }

    public void buyItem(ShopItem item)
    {
        if(0<=Main.amountTotalClicks.getDecimalCount().compareTo(new BigDecimal(item.getPrice())))
        {
            item.buy();
            Main.amountTotalClicks.increaseCounter(0-item.getPrice());

        }
    }
}
