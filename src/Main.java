import buyables.ItemGrandma;
import buyables.ItemYarn;
import buyables.ShopItem;
import layout.*;

import javax.swing.*;
import java.awt.*;
import java.io.File;


public class Main
{
    public static AmountTotalClicksLabel amountTotalClicks;
    public static Shop shop;
    public static FileManager fm;
    public static DefaultMainFrame dmf;
    public static BuyAutoClickerPanelLayout buyAutoClickerPanelLayout;
    public static MainClickerMiddleLayout mainClickerMiddleLayout;
    public static MainClickerMiddleButton mainClickerMiddleButton;
    public static BuyMenu buyMenu;

    public static void main(String[] args)
    {
        int amountItems = 5;
        String documentFolder = ToolManager.getDocumentPath();
        String folderName = "/kittenclicker/";
        shop = new Shop();
        amountTotalClicks = new AmountTotalClicksLabel(0, 0, 182, 50);
        File theDir = new File(documentFolder + folderName);
        fm = new FileManager(documentFolder + folderName + "game.save");

        Thread as = new AutoSave(fm);

        /*

        DefaultMainFrame
        |
        |---->BuyAutoClickerPanelLayout
        |     |-->amountTotalClicksLabel    height: 50px
        |     |-->BuyMenu                   height: height - 50px
        |---->MainClickerMiddleLayout
              |-->mainClickerMiddleButton

         */




        //amountTotalClicks = new AmountTotalClicksLabel(0, 0, 182, 50);
        dmf = new DefaultMainFrame(1280, 720);
        buyAutoClickerPanelLayout = new BuyAutoClickerPanelLayout(0, 0, 182, dmf.getHeight());
        mainClickerMiddleLayout = new MainClickerMiddleLayout(182, 0, 1000, dmf.getHeight());
        mainClickerMiddleButton = new MainClickerMiddleButton(mainClickerMiddleLayout.getWidth() / 2 - 150, mainClickerMiddleLayout.getHeight() / 2 - 150, 300, 300);
        buyMenu = new BuyMenu(0,50, 182, (buyAutoClickerPanelLayout.getHeight() - amountTotalClicks.getHeight())); //85

        System.out.println("BuyAutoClickerPanelLayoutHeight: " + buyAutoClickerPanelLayout.getHeight());
        System.out.println("amountTotalClicksLabel: " + amountTotalClicks.getHeight());
        System.out.println("BuyMenuHeight: " + buyMenu.getHeight());

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


