package layout;

import buyables.ShopItem;

import javax.swing.*;

public class ItemBuyButton extends JButton {

    ShopItem item;

    public ItemBuyButton(ShopItem item) {
        this.setVerticalAlignment(SwingConstants.CENTER);
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.item = item;
        this.setText(item.getName());
    }



}
