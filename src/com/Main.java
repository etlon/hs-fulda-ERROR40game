package com;

import com.layout.BuyAutoClickerPanelLayout;
import com.layout.BuyMenu;
import com.layout.ItemBuyButton;
import com.layout.ItemBuyPanel;
import com.layout.MainClickerBackgroundLabel;
import com.layout.MainClickerMiddleLayout;
import com.layout.PassiveIncomeLabel;
import java.awt.BorderLayout;


public class Main {
    /*

     com.DefaultMainFrame
     |
     |---->BuyAutoClickerPanelLayout
     |     |-->amountTotalClicksLabel    height: 50px
     |     |-->BuyMenu                   height: height - 50px
     |         |-->ItemBuyPanel
     |             |-->ItemBuyButton
     |---->MainClickerMiddleLayout
     |     |-->MainClickerBackgroundLabel
     |         |-->Villain
     |     |-->MainClickerMiddleButton
     */

    /**
     * @see DefaultMainFrame
     * @see BuyAutoClickerPanelLayout
     * @see AmountTotalClicksLabel
     * @see BuyMenu
     * @see ItemBuyPanel
     * @see ItemBuyButton
     * @see MainClickerMiddleLayout
     * @see MainClickerMiddleButton
     */

    public static void main(String[] args) {
        int midClickerLength = 300;
        String documentFolder = ToolManager.getDocumentPath();
        String folderName = "/kittenclicker/";
        ToolManager.createFolderIfNotExist(folderName);
        Shop shop = new Shop();
        AmountTotalClicksLabel amountTotalClicks = new AmountTotalClicksLabel(0, 0, 182, 50);
        FileManager fileManager = new FileManager(documentFolder + folderName + "game.save", shop, amountTotalClicks);
        DefaultMainFrame defaultMainFrame = new DefaultMainFrame(1280, 720);

        new AutoSave(fileManager).start();
        new PassiveIncome(shop, amountTotalClicks).start();

        defaultMainFrame.addWindowListener(new WindowEventListener(fileManager));
        int defaultMainFrameHeight = defaultMainFrame.getHeight();
        BuyAutoClickerPanelLayout buyAutoClickerPanelLayout =
                new BuyAutoClickerPanelLayout(0, 0, 182, defaultMainFrameHeight);

        MainClickerMiddleLayout mainClickerMiddleLayout =
                new MainClickerMiddleLayout(182, 0, 1000, defaultMainFrameHeight);

        defaultMainFrame.add(buyAutoClickerPanelLayout);
        defaultMainFrame.add(mainClickerMiddleLayout, BorderLayout.CENTER);
        PassiveIncomeLabel passiveIncomeLabel = new PassiveIncomeLabel(1182, 0, 182, 50, shop);
        defaultMainFrame.add(passiveIncomeLabel);

        int mainClickerX = mainClickerMiddleLayout.getWidth() / 2 - midClickerLength / 2;
        int mainClickerY = mainClickerMiddleLayout.getHeight() / 2 - midClickerLength / 2;
        MainClickerMiddleButton mainClickerButton = new MainClickerMiddleButton(
                mainClickerX, mainClickerY, midClickerLength, midClickerLength, amountTotalClicks);

        mainClickerMiddleLayout.add(mainClickerButton);
        MainClickerBackgroundLabel mainClickerBackgroundLabel =
                new MainClickerBackgroundLabel(0, 0, 1000, defaultMainFrameHeight);
        mainClickerMiddleLayout.add(mainClickerBackgroundLabel);

        Villain villain = new Villain(50, 50, mainClickerMiddleLayout, mainClickerButton, amountTotalClicks);
        mainClickerBackgroundLabel.add(villain);
        buyAutoClickerPanelLayout.add(amountTotalClicks);

        int buyMenuHeight = buyAutoClickerPanelLayout.getHeight() - amountTotalClicks.getHeight();
        BuyMenu buyMenu = new BuyMenu(0, 50, 182, buyMenuHeight, amountTotalClicks, passiveIncomeLabel); //85
        buyAutoClickerPanelLayout.add(buyMenu);

        buyMenu.addPanels(shop.getItemList());
        defaultMainFrame.setVisible(true);
    }

}