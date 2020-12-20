package layout;

import buyables.ShopItem;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class BuyLabel extends JLabel {

    ShopItem item;
    BufferedImage image;

    public BuyLabel(int x, int y, int width, int height, ShopItem item) {
        this.setBounds(x, y, width, height);
        this.item=item;
        this.setProperties();

    }

    public BuyLabel(int x, int y, int width, int height,ShopItem item, String fileName) {
        this.setBounds(x, y, width, height);
        this.setImage(fileName);
        this.item=item;
        this.setProperties();

    }

    private void setProperties()
    {
        this.setOpaque(true);
        this.setBackground(Color.white);
        // label.setBackground(new Color(i * (255 / amountItems), i * (255 / amountItems), i * (255 / amountItems)));
        this.setText("" + item.getName());
        this.setVerticalAlignment(SwingConstants.CENTER);
        this.setHorizontalAlignment(SwingConstants.CENTER);
    }

    public boolean setImage(String fileName) {
        try {
            image = ImageIO.read(getClass().getResource("/assets/" + fileName));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public ShopItem getItem()
    {
        return item;
    }


}
