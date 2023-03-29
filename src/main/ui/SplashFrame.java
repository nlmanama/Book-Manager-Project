package ui;

import javax.swing.*;
import java.awt.*;

// The splash screen when the application starts
public class SplashFrame {

    private JFrame frame;

    // EFFECTS: create the splash screen
    public SplashFrame() {
        initialize();
    }

    // MODIFIES: this
    // EFFECTS: create the frame with the SplashArt file as the full screen
    private void initialize() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);


        ImageIcon splash = new ImageIcon("src/main/ui/SplashArt.png");
        JLabel image = new JLabel();
        image.setIcon(splash);
        Dimension size = image.getPreferredSize();
        frame.setBounds(400, 170, size.width, size.height);
        image.setBounds(0, 0, size.width, size.height);
        frame.getContentPane().add(image);
        frame.setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: hides the frame
    public void hide() {
        frame.setVisible(false);
    }
}
