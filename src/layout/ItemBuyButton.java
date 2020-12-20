package layout;

import buyables.ShopItem;

import javax.swing.*;
import java.awt.*;

public class ItemBuyButton extends JButton {

    ShopItem item;

    public ItemBuyButton(ShopItem item) {
        this.item = item;
        this.setText(item.getName());
        this.setPreferredSize(new Dimension(120,100));
        this.addActionListener(e -> {

        });
    }



}
