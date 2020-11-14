public class Main
{
    public static void main(String[] args)
    {

        DefaultMainFrame dmf = new DefaultMainFrame(1280,720);
        AmountTotalClicksLabel amountTotalClicks = new AmountTotalClicksLabel(0,0,100,100);
        BuyAutoClickerPanelLayout buyAutoClickerPanel = new BuyAutoClickerPanelLayout(0,0, 182, dmf.getHeight());
        MainClickerMiddleButton mainClickerMiddle = new MainClickerMiddleButton(dmf.getWidth()/2 - 150, dmf.getHeight()/2 - 150, 300, 300);
        mainClickerMiddle.addActionListener(e -> {
            amountTotalClicks.increaseCounter();
        });


        dmf.add(buyAutoClickerPanel);
        dmf.add(mainClickerMiddle);
        buyAutoClickerPanel.add(amountTotalClicks);

        dmf.setVisible(true);



    }

}


