package buyables;

public abstract class ShopItem
{
    private double basePrice;
    private int amount;
    private double price;
    private double baseIncome;


    public ShopItem()
    {
        this.amount = 0;
    }

    public void setAmount(int amount)
    {
        this.amount = amount;
    }

    public void buy()
    {
        this.amount++;
        this.calcPrice();
    }


    private void calcPrice()
    {
        this.price = basePrice + basePrice * amount * 0.2;
    }

    public double getPrice()
    {
        return this.price;
    }

    public double getIncome()
    {
        return amount * baseIncome;
    }

}
