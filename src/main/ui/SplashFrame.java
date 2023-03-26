package ui;

import javax.swing.*;
import java.awt.*;

public class SplashFrame {

    private JFrame frame;

    public SplashFrame() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);


        ImageIcon splash = new ImageIcon("src/main/ui/DraftSplash.JPG");
        JLabel image = new JLabel();
        image.setIcon(splash);
        Dimension size = image.getPreferredSize();
        frame.setBounds(400, 120, size.width, size.height);
        image.setBounds(0, 0, size.width, size.height);
        frame.getContentPane().add(image);
        frame.setVisible(true);
    }

    public void hide() {
        frame.setVisible(false);
    }
}
