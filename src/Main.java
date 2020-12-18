import layout.BuyAutoClickerPanelLayout;
import layout.BuyMenu;
import layout.MainClickerMiddleLayout;

import java.awt.*;
import java.io.File;


public class Main
{
    public static AmountTotalClicksLabel amountTotalClicks;
    public static Shop shop;
    public static FileManager fm;

    public static void main(String[] args)
    {
        String documentFolder = ToolManager.getDocumentPath();
        String folderName = "/kittenclicker/";
        shop = new Shop();
        amountTotalClicks = new AmountTotalClicksLabel(0, 0, 182, 50);
        File theDir = new File(documentFolder + folderName);
        fm = new FileManager(documentFolder + folderName + "game.save");

        Thread as = new AutoSave(fm);


        //amountTotalClicks = new AmountTotalClicksLabel(0, 0, 182, 50);
        DefaultMainFrame dmf = new DefaultMainFrame(1280, 720);
        BuyAutoClickerPanelLayout buyAutoClickerPanelLayout = new BuyAutoClickerPanelLayout(0, 0, 182, dmf.getHeight());
        MainClickerMiddleLayout mainClickerMiddleLayout = new MainClickerMiddleLayout(182, 0, 1000, dmf.getHeight());
        MainClickerMiddleButton mainClickerMiddleButton = new MainClickerMiddleButton(mainClickerMiddleLayout.getWidth() / 2 - 150, mainClickerMiddleLayout.getHeight() / 2 - 150, 300, 300);
        BuyMenu buyMenu = new BuyMenu(0,0, 182, dmf.getHeight()/2);

        Thread income = new PassiveIncome(shop);
        //shop = new Shop();
        //Thread income = new PassiveIncome(shop);
        income.start();
        as.start();
        //String documentFolder = ToolManager.getDocumentPath();
        //String folderName = "/kittenclicker/";
        //File theDir = new File(documentFolder + folderName);
        if (!theDir.exists()){
            theDir.mkdirs();
        }

        //fm = new FileManager(documentFolder + folderName + "game.save");
        //Thread as = new AutoSave(fm);


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

        //BuyMenu buyMenu = new BuyMenu(0,0, 182, dmf.getHeight()/2);

        buyAutoClickerPanelLayout.add(buyMenu);

        dmf.setVisible(true);


    }

}


