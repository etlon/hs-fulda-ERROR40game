package com;

import com.layout.*;

import java.awt.*;

        /*

        com.DefaultMainFrame
        |
        |---->BuyAutoClickerPanelLayout
        |     |-->amountTotalClicksLabel    height: 50px
        |     |-->BuyMenu                   height: height - 50px
        |---->MainClickerMiddleLayout
              |-->mainClickerMiddleButton

         */

public class Main
{
    public static AmountTotalClicksLabel amountTotalClicks;
    public static BuyMenu buyMenu;
    public static Shop shop;
    public static FileManager fm;
    public static DefaultMainFrame dmf;
    public static BuyAutoClickerPanelLayout buyAutoClickerPanelLayout;
    public static MainClickerMiddleLayout mainClickerMiddleLayout;
    public static MainClickerMiddleButton mainClickerMiddleButton;


    public static void main(String[] args)
    {
        String documentFolder = ToolManager.getDocumentPath();
        String folderName = "/kittenclicker/";
        ToolManager.createFolderIfNotExist(folderName);
        shop = new Shop();
        amountTotalClicks = new AmountTotalClicksLabel(0, 0, 182, 50);
        fm = new FileManager(documentFolder + folderName + "game.save");

        Thread as = new AutoSave(fm);

        dmf = new DefaultMainFrame(1280, 720);
        buyAutoClickerPanelLayout = new BuyAutoClickerPanelLayout(0, 0, 182, dmf.getHeight());
        mainClickerMiddleLayout = new MainClickerMiddleLayout(182, 0, 1000, dmf.getHeight());
        mainClickerMiddleButton = new MainClickerMiddleButton(mainClickerMiddleLayout.getWidth() / 2 - 150, mainClickerMiddleLayout.getHeight() / 2 - 150, 300, 300);
        buyMenu = new BuyMenu(0,50, 182, (buyAutoClickerPanelLayout.getHeight() - amountTotalClicks.getHeight())); //85

        Thread income = new PassiveIncome(shop);

        income.start();
        as.start();

        dmf.addWindowListener(new WindowEventListener(fm));

        dmf.add(buyAutoClickerPanelLayout);

        dmf.add(mainClickerMiddleLayout, BorderLayout.CENTER);

        mainClickerMiddleLayout.add(mainClickerMiddleButton);

        buyAutoClickerPanelLayout.add(amountTotalClicks);

        buyAutoClickerPanelLayout.add(buyMenu);

        dmf.setVisible(true);

        buyMenu.addPanels(shop.getItemList());


    }

}


