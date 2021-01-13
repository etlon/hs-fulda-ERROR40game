package com;

import java.awt.Font;
import java.awt.Color;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class AmountTotalClicksLabel extends JLabel {

    private BigDecimal count = new BigDecimal(0);
    DecimalFormat df;

    /**
     * @param x      origin of label on x axis
     * @param y      origin of label on y axis
     * @param width  width of the label
     * @param height height of the label
     */

    public AmountTotalClicksLabel(int x, int y, int width, int height) {

        this.setBounds(x, y, width, height);
        this.setBorder(new EmptyBorder(0, 10, 0, 0));
        this.setText("0");
        this.setFont(new Font("Arial Black", Font.PLAIN, 30));
        //this.setOpaque(true);
        //this.setBackground(new Color(0xACACAC));
        this.setForeground(Color.WHITE);

        df = new DecimalFormat("0.000");

        //Initialize counter
        this.setText(String.valueOf(count));
        this.setVerticalAlignment(SwingConstants.CENTER);

    }

    /**
     * increases the totalClickCounter by one
     */

    public void increaseCounter() {
        increaseCounter(1);
    }

    /**
     * increases the totalClickCounter by a specified amount
     *
     * @param amount amount to increase
     */

    public void increaseCounter(double amount) {
        count = count.add(new BigDecimal(amount));
        this.setText(ToolManager.formatCounter(count));
    }

    public void increaseCounter(String amount) {
        count = count.add(new BigDecimal(amount));
        this.setText(ToolManager.formatCounter(count));
    }

    public void increaseCounter(BigDecimal amount) {
        count = count.add(amount);
        this.setText(ToolManager.formatCounter(count));
    }

    /**
     * returns current count as String
     */

    public String getCount() {
        return "" + count;
    }

}
