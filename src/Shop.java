import buyables.ShopItem;

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
    }

    public void saveItems(){
        for (ShopItem item : itemList) {
            Main.fm.addValueByKey(item.getName(), "" + item.getAmount());
        }
    }

    public int getAmountItems(){
        return itemList.length;
    }
}
