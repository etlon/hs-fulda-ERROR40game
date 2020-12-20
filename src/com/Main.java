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
    public static FileManager fileManager;
    public static DefaultMainFrame defaultMainFrame;
    public static BuyAutoClickerPanelLayout buyAutoClickerPanelLayout;
    public static MainClickerMiddleLayout mainClickerMiddleLayout;
    public static MainClickerMiddleButton mainClickerMiddleButton;

    public static void main(String[] args)
    {
        int middleClickerLength = 300;
        String documentFolder = ToolManager.getDocumentPath();
        String folderName = "/kittenclicker/";
        ToolManager.createFolderIfNotExist(folderName);
        shop = new Shop();
        amountTotalClicks = new AmountTotalClicksLabel(0, 0, 182, 50);
        fileManager = new FileManager(documentFolder + folderName + "game.save");
        //Setting Layout
        defaultMainFrame = new DefaultMainFrame(1280, 720);
        buyAutoClickerPanelLayout = new BuyAutoClickerPanelLayout(0, 0, 182, defaultMainFrame.getHeight());
        mainClickerMiddleLayout = new MainClickerMiddleLayout(182, 0, 1000, defaultMainFrame.getHeight());
        mainClickerMiddleButton = new MainClickerMiddleButton(mainClickerMiddleLayout.getWidth() / 2 - middleClickerLength / 2, mainClickerMiddleLayout.getHeight() / 2 - middleClickerLength / 2, middleClickerLength, middleClickerLength);
        buyMenu = new BuyMenu(0,50, 182, (buyAutoClickerPanelLayout.getHeight() - amountTotalClicks.getHeight())); //85
        //Multithreading
        new AutoSave(fileManager).start();
        new PassiveIncome(shop).start();
        //Adding all components
        defaultMainFrame.addWindowListener(new WindowEventListener(fileManager));
        defaultMainFrame.add(buyAutoClickerPanelLayout);
        defaultMainFrame.add(mainClickerMiddleLayout, BorderLayout.CENTER);
        mainClickerMiddleLayout.add(mainClickerMiddleButton);
        buyAutoClickerPanelLayout.add(amountTotalClicks);
        buyAutoClickerPanelLayout.add(buyMenu);
        buyMenu.addPanels(shop.getItemList());

        defaultMainFrame.setVisible(true);

    }

}


