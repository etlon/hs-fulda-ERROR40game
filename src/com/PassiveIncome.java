package com;

public class PassiveIncome extends Thread {
    private Shop shop;
    private AmountTotalClicksLabel amountTotalClicks;

    public PassiveIncome(Shop shop, AmountTotalClicksLabel amountTotalClicks) {
        this.shop = shop;
        this.amountTotalClicks = amountTotalClicks;
    }


    public void run() {
        while (true) {
            amountTotalClicks.increaseCounter(shop.getIncome());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
