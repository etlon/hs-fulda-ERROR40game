package com;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class AmountTotalClicksLabel extends JLabel {

    private BigDecimal count = new BigDecimal(0);
    private char[] suffixArray = {' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    DecimalFormat df;
    /**
     *
     * @param x origin of label on x axis
     * @param y origin of label on y axis
     * @param width width of the label
     * @param height height of the label
     */

    public AmountTotalClicksLabel(int x, int y, int width, int height) {

        this.setBounds(x,y,width,height);
        this.setBorder(new EmptyBorder(0,10,0,0));
        this.setText("0");
        this.setFont(new Font("Arial Black", Font.PLAIN, 30));
        this.setOpaque(true);
        this.setBackground(Color.YELLOW);

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
     * @param amount amount to increase
     */

    public void increaseCounter(double amount) {
        count = count.add(new BigDecimal(amount));
        this.setText(formatCounter(count));
    }

    public void increaseCounter(String amount){
        count = count.add(new BigDecimal(amount));
        this.setText(formatCounter(count));
    }


    /**
     * shortens long numbers for the counter
     * @param count count to be shortened and having an
     * unit added to them
     */

    public String formatCounter(BigDecimal count){

        int counter=0;
        //gerade keine Lust ein Index Out of Bounds zu verhindern
        if(counter == 26) System.exit(0);
        if(count.compareTo(new BigDecimal(1000)) <= 0) return String.valueOf(count);
        while (count.compareTo(new BigDecimal(1000))>=0) {
            count = count.divide(new BigDecimal(1000));
            counter++;
        }

        return df.format(count.doubleValue()) + suffixArray[counter];
    }

    /**
     * returns current count as String
     */

    public String getCount(){
        return ""+count;
    }

}
