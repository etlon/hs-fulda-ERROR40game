import layout.BuyAutoClickerPanelLayout;
import layout.MainClickerMiddleLayout;

import java.awt.*;


public class Main
{
    public static AmountTotalClicksLabel amountTotalClicks;
    public static Shop shop;

    public static void main(String[] args)
    {

        DefaultMainFrame dmf = new DefaultMainFrame(1280, 720);

        amountTotalClicks = new AmountTotalClicksLabel(0, 0, 100, 100);
        BuyAutoClickerPanelLayout buyAutoClickerPanelLayout = new BuyAutoClickerPanelLayout(0, 0, 182, dmf.getHeight());
        MainClickerMiddleLayout mainClickerMiddleLayout = new MainClickerMiddleLayout(182, 0, 1000, dmf.getHeight());

        MainClickerMiddleButton mainClickerMiddleButton = new MainClickerMiddleButton(mainClickerMiddleLayout.getWidth() / 2 - 150, mainClickerMiddleLayout.getHeight() / 2 - 150, 300, 300);

        shop = new Shop();
        Thread income = new PassiveIncome(shop);
        income.start();
        String documentFolder = ToolManager.getDocumentPath();
        FileManager fm = new FileManager(documentFolder + "/game.save");
        Thread as = new AutoSave(fm);
        as.start();

        dmf.addWindowListener(new WindowEventListener(fm));

        mainClickerMiddleButton.addActionListener(e ->
        {
            amountTotalClicks.increaseCounter();
            Thread t = new ButtonAnim(mainClickerMiddleButton);
            t.start();

        });

        //Adding BuyMenuLayout to MainFrame
        dmf.add(buyAutoClickerPanelLayout);
        //Adding MiddleMenuLayout to MainFrame
        dmf.add(mainClickerMiddleLayout, BorderLayout.CENTER);

        mainClickerMiddleLayout.add(mainClickerMiddleButton);

        buyAutoClickerPanelLayout.add(amountTotalClicks);

        dmf.setVisible(true);


    }

}


