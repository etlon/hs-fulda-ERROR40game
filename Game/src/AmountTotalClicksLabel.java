import javax.swing.*;
import java.awt.*;

public class AmountTotalClicksLabel extends JLabel {

    private int count = 0;

    /**
     *
     * @param x origin of label on x axis
     * @param y origin of label on y axis
     * @param width width of the label
     * @param height height of the label
     */

    public AmountTotalClicksLabel(int x, int y, int width, int height) {
        this.setBounds(x,y,width,height);

        this.setText("0");
        this.setFont(new Font("Arial Black", Font.PLAIN, 30));
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setVerticalAlignment(JLabel.CENTER);

    }

    /**
     * increases the totalClickCounter by one
     */

    public void increaseCounter() {
        count++;
        this.setText(formatCounter(count));
    }

    /**
     * increases the totalClickCounter by a specified amount
     * @param amount amount to increase
     */

    public void increaseCounter(int amount) {
        count += amount;
        this.setText(formatCounter(count));
    }


    /**
     * shortens long numbers for the counter
     * @param count count to be shortened
     */

    public String formatCounter(int count){

        if(count >= 1_000_000_000) return count/1_000_000_000 + " bil";
        if(count >= 1_000_000) return count/1_000_000 + " mil";

        return "" + count;
    }

}
