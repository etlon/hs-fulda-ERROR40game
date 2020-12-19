import layout.BuyAutoClickerPanelLayout;
import layout.BuyMenu;
import layout.MainClickerMiddleLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;


public class Main
{
    public static AmountTotalClicksLabel amountTotalClicks;
    public static Shop shop;
    public static FileManager fm;
    public static JLabel[] shopLabel;

    public static void main(String[] args)
    {

        String documentFolder = ToolManager.getDocumentPath();
        String folderName = "/kittenclicker/";
        shop = new Shop();
        int amountItems = shop.getAmountItems();
        shopLabel=new JLabel[amountItems];
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
        DefaultMainFrame dmf = new DefaultMainFrame(1280, 720);
        BuyAutoClickerPanelLayout buyAutoClickerPanelLayout = new BuyAutoClickerPanelLayout(0, 0, 182, dmf.getHeight());
        MainClickerMiddleLayout mainClickerMiddleLayout = new MainClickerMiddleLayout(182, 0, 1000, dmf.getHeight());
        MainClickerMiddleButton mainClickerMiddleButton = new MainClickerMiddleButton(mainClickerMiddleLayout.getWidth() / 2 - 150, mainClickerMiddleLayout.getHeight() / 2 - 150, 300, 300);
        BuyMenu buyMenu = new BuyMenu(0,50, 182, (buyAutoClickerPanelLayout.getHeight() - amountTotalClicks.getHeight())); //85

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


        for(int i = 0; i < amountItems; i++) {

            JLabel label = new JLabel();
            label.setOpaque(true);
            label.setBackground(Color.white);
            label.setBounds(0, i * (630 / amountItems),182,(630 / amountItems));
            label.setBackground(new Color(i*(255/amountItems), i*(255/amountItems), i*(255/amountItems)));
            label.setText("" + i);
            label.setVerticalAlignment(SwingConstants.CENTER);
            label.setHorizontalAlignment(SwingConstants.CENTER);

            label.addMouseListener(new MouseAdapter()
            {
                @Override
                public void mouseReleased(MouseEvent e)
                {
                    if (e.isPopupTrigger() || e.getButton() == MouseEvent.BUTTON1) {
                        shop.buyItem(shop.getClickedItem(label,shopLabel));
                    }
                }
            });


            shopLabel[i]=label;

            buyMenu.add(label);
        }











        dmf.setVisible(true);


    }

}


