package layout;

import javax.swing.*;

public class SimpleLayout extends JPanel {

    public SimpleLayout(int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);
        this.setLayout(null);
    }
}
