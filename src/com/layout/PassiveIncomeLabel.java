package com.layout;

import com.Main;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PassiveIncomeLabel extends JLabel {


    public PassiveIncomeLabel(int x, int y, int width, int height) {

        this.setBounds(x,y,width,height);
        this.setBorder(new EmptyBorder(0,10,0,0));
        this.setText(String.valueOf(Main.shop.getIncome()));
        this.setFont(new Font("Arial Black", Font.PLAIN, 30));

    }

    public void updatePassiveIncome(){
        this.setText(String.valueOf(Main.shop.getIncome()));
    }
}
