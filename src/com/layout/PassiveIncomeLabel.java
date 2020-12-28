package com.layout;

import com.Main;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.math.BigDecimal;

public class PassiveIncomeLabel extends JLabel {


    public PassiveIncomeLabel(int x, int y, int width, int height) {

        this.setBounds(x,y,width,height);
        this.setBorder(new EmptyBorder(0,5,0,0));
        this.updatePassiveIncome();
        this.setFont(new Font("Arial Black", Font.PLAIN, 18));

    }

    public void updatePassiveIncome(){
        this.setText("<html>" + "per sec" +"<br />" + Main.amountTotalClicks.formatCounter(new BigDecimal(String.valueOf(Main.shop.getIncome()))) + "</html>");
    }
}
