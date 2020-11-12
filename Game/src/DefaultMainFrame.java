import javax.swing.*;

public class DefaultMainFrame extends JFrame {

    JFrame frame;

    public DefaultMainFrame() {
        frame = new JFrame("Kitten Clicker");
        frame.setSize(1280, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);

    }



}