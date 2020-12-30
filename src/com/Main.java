package com;

import com.layout.*;
import java.awt.*;

public class Main
{
    /*

     com.DefaultMainFrame
     |
     |---->BuyAutoClickerPanelLayout
     |     |-->amountTotalClicksLabel    height: 50px
     |     |-->BuyMenu                   height: height - 50px
     |         |-->ItemBuyPanel
     |             |-->ItemBuyButton
     |---->MainClickerMiddleLayout
     |     |-->MainClickerMiddleButton
     */

    /**
     *
     * @see DefaultMainFrame
     * @see BuyAutoClickerPanelLayout
     * @see AmountTotalClicksLabel
     * @see BuyMenu
     * @see ItemBuyPanel
     * @see ItemBuyButton
     * @see MainClickerMiddleLayout
     * @see MainClickerMiddleButton
     */

    public static Shop shop;
    public static FileManager fileManager;

    public static DefaultMainFrame defaultMainFrame;
    public static BuyAutoClickerPanelLayout buyAutoClickerPanelLayout;
    public static AmountTotalClicksLabel amountTotalClicks;
    public static BuyMenu buyMenu;
    public static MainClickerMiddleLayout mainClickerMiddleLayout;
    public static MainClickerMiddleButton mainClickerMiddleButton;
    public static PassiveIncomeLabel passiveIncomeLabel;
    public static MainClickerBackgroundLabel mainClickerBackgroundLabel;

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
        mainClickerBackgroundLabel = new MainClickerBackgroundLabel(0, 0, 1000, defaultMainFrame.getHeight());
        buyMenu = new BuyMenu(0,50, 182, (buyAutoClickerPanelLayout.getHeight() - amountTotalClicks.getHeight())); //85
        buyAutoClickerPanelLayout.setBackground(new Color(0x6AFF11));
        passiveIncomeLabel = new PassiveIncomeLabel(1182, 0, 182, 50); //location will be discussed with other members

        //Multithreading
        new AutoSave(fileManager).start();
        new PassiveIncome(shop).start();
        //Adding all components
        defaultMainFrame.addWindowListener(new WindowEventListener(fileManager));
        defaultMainFrame.add(buyAutoClickerPanelLayout);
        defaultMainFrame.add(mainClickerMiddleLayout, BorderLayout.CENTER);
        defaultMainFrame.add(passiveIncomeLabel);
        mainClickerMiddleLayout.add(mainClickerMiddleButton);
        mainClickerMiddleLayout.add(mainClickerBackgroundLabel);
        buyAutoClickerPanelLayout.add(amountTotalClicks);
        buyAutoClickerPanelLayout.add(buyMenu);

        buyMenu.addPanels(shop.getItemList());
        defaultMainFrame.setVisible(true);
    }

}