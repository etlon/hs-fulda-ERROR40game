package layout;

import javax.swing.*;
import java.awt.*;

public class ItemBuyPanel extends JPanel {

    public ItemBuyPanel(int x, int y, int width, int height, ItemBuyButton button) {
        this.setBounds(x, y, width, height);
        this.setOpaque(true);
        this.setBackground(Color.WHITE);
        this.setLayout(new GridBagLayout());
        this.add(button, new GridBagConstraints());

    }

}
