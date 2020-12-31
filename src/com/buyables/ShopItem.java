package com.buyables;

import java.text.DecimalFormat;

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
    }

    protected void calcPrice() {
        this.price = basePrice * Math.pow(1.2, amount);
        DecimalFormat df = new DecimalFormat("0");
        this.price = Double.parseDouble(df.format(this.price));
    }

    public double getPrice() {
        this.calcPrice();
        return this.price;
    }

    public double getBaseIncome() {
        return this.baseIncome;
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
