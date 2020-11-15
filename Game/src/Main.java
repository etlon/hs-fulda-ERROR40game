import layout.BuyAutoClickerPanelLayout;
import layout.MainClickerMiddleLayout;


public class Main
{
    public static void main(String[] args)
    {
        DefaultMainFrame dmf = new DefaultMainFrame(1280,720);
        AmountTotalClicksLabel amountTotalClicks = new AmountTotalClicksLabel(0,0,100,100);
        BuyAutoClickerPanelLayout buyAutoClickerPanelLayout = new BuyAutoClickerPanelLayout(0,0, 182, dmf.getHeight());
        MainClickerMiddleLayout mainClickerMiddleLayout = new MainClickerMiddleLayout(182, 0, 1000, dmf.getHeight());

        MainClickerMiddleButton mainClickerMiddleButton = new MainClickerMiddleButton(0,0, 300, 300);


        mainClickerMiddleButton.addActionListener(e -> {
            amountTotalClicks.increaseCounter();
        });

        //Adding BuyMenuLayout to MainFrame
        dmf.add(buyAutoClickerPanelLayout);
        //Adding MiddleMenuLayout to MainFrame
        dmf.add(mainClickerMiddleLayout);

        mainClickerMiddleLayout.add(mainClickerMiddleButton);

        buyAutoClickerPanelLayout.add(amountTotalClicks);

        dmf.setVisible(true);








    }

}


