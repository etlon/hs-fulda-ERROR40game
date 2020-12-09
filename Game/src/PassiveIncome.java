public class PassiveIncome extends Thread
{
    private Shop shop;

    public PassiveIncome(Shop shop)
    {
        this.shop = shop;
    }


    public void run()
    {
        while (true)
        {
            Main.amountTotalClicks.increaseCounter(shop.getIncome());
            try
            {
                Thread.sleep(1000);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

}
