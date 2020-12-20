package com.buyables;


public abstract class ShopItem {
    protected double basePrice;
    protected int amount;
    protected double price;
    protected double baseIncome;
    protected String name;


    public ShopItem() {
        this.name = "";
        this.amount = 0;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void buy() {

        this.amount++;
        this.calcPrice();

    }

    protected void calcPrice() {
        this.price = basePrice + basePrice * amount * 0.2;
    }

    public double getPrice() {
        this.calcPrice();
        return this.price;
    }

    public double getIncome() {
        return amount * baseIncome;
    }

    public int getAmount() {
        return this.amount;
    }

    public String getName() {
        return this.name;
    }
}
