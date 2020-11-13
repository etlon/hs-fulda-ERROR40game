import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class DefaultMainFrame extends JFrame {

    JFrame frame;
    JLabel amountClickedLabel;
    int count = 0;
    int jframeWidth = 1280;
    int jframeHeight = 720;
    int mainClickerMiddleWidth = 300;
    int mainClickerMiddleHeight = 300;

    public DefaultMainFrame() {

        frame = new JFrame("Kitten Clicker");
        frame.setSize(jframeWidth, jframeHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);

        amountClickedLabel = new JLabel();
        amountClickedLabel.setBounds(jframeWidth/2,jframeHeight - 600,100,100);
        Font labelFont = amountClickedLabel.getFont();
        amountClickedLabel.setFont(new Font(labelFont.getName(), Font.PLAIN, 30));
        amountClickedLabel.setText("0");

        JButton mainClickerMiddle = new JButton();
        mainClickerMiddle.setBounds(jframeWidth/2 - (mainClickerMiddleWidth/2),jframeHeight/2 - (mainClickerMiddleHeight/2), mainClickerMiddleWidth, mainClickerMiddleHeight);
        try {
            BufferedImage buttonIcon = ImageIO.read(new File("Game/assets/bongocatresized.png"));
            mainClickerMiddle.setIcon(new ImageIcon(buttonIcon));
            mainClickerMiddle.setBorder(BorderFactory.createEmptyBorder());
            mainClickerMiddle.setContentAreaFilled(false);
        } catch(Exception e) {
            e.printStackTrace();
        }

        mainClickerMiddle.addActionListener(e -> {
           count++;
           amountClickedLabel.setText("" + count);
        });

        frame.add(amountClickedLabel);
        frame.add(mainClickerMiddle);

        frame.setVisible(true);

    }

}