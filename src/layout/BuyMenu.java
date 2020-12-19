package layout;

import javax.swing.*;
import java.awt.*;

public class BuyMenu extends JLabel {
    private int amountItems;

    public BuyMenu(int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);
        //this.setBorder(new EmptyBorder(0,10,0,0));
        this.setFont(new Font("Arial Black", Font.PLAIN, 30));
        this.setVerticalAlignment(JLabel.BOTTOM);
        this.setOpaque(true);
        this.setBackground(Color.WHITE);

        this.amountItems = 5;


    }


}
