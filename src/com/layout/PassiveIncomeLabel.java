package com.layout;

import com.Shop;
import com.ToolManager;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public class PassiveIncomeLabel extends JLabel {

    private Shop shop;

    public PassiveIncomeLabel(int x, int y, int width, int height, Shop shop) {

        this.shop = shop;
        this.setBounds(x, y, width, height);
        this.setBorder(new EmptyBorder(0, 5, 0, 0));
        this.updatePassiveIncome();
        this.setFont(new Font("Arial Black", Font.PLAIN, 18));

    }

    public void updatePassiveIncome() {
        this.setText("<html>" + "per sec" + "<br />" + ToolManager.formatCounter(shop.getIncome()) + "</html>");
    }
}
