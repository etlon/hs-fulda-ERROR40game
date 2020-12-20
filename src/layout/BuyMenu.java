package layout;

import buyables.ItemGrandma;
import buyables.ItemYarn;
import buyables.ShopItem;

import javax.swing.*;
import java.awt.*;

public class BuyMenu extends JLabel {

    public ShopItem[] list;

    public BuyMenu(int x, int y, int width, int height) {
        this.setBounds(x,y,width,height);
        //this.setBorder(new EmptyBorder(0,10,0,0));
        this.setFont(new Font("Arial Black", Font.PLAIN, 30));
        this.setVerticalAlignment(JLabel.BOTTOM);
        this.setOpaque(true);
        this.setBackground(Color.WHITE);

        list = new ShopItem[5];
        list[0] = new ItemYarn();
        list[1] = new ItemGrandma();
        list[2] = new ItemYarn();
        list[3] = new ItemGrandma();
        list[4] = new ItemYarn();

        addPanels();

    }

    private void addPanels() {
        for(int i = 0; i < list.length; i++) {

            ItemBuyButton button = new ItemBuyButton(list[i]);
            ItemBuyPanel panel = new ItemBuyPanel(0, i * (630 / list.length),182, (630 / list.length), button);
            //panel.setBackground(new Color(i*20, 0, 0));
            this.add(panel);
        }
    }




}
