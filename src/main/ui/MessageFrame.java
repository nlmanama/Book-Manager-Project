package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// A window that displays a short message to the user
public class MessageFrame {

    private JFrame frame;
    private String message;

    // REQUIRES: mes be a String
    // EFFECTS: creates a frame with the message to be displayed
    public MessageFrame(String mes) {
        this.message = mes;
        initialize();
    }

    // MODIFIES: this
    // EFFECTS: creates the frame with the JLabel that shows the message, with a Done button that hides the frame
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(600, 270, 400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel display = new JLabel(message, SwingConstants.CENTER);
        display.setBounds(75, 20, 250, 60);
        frame.getContentPane().add(display);

        JButton backButton = new JButton("Done");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });
        backButton.setBounds(125, 100, 150, 30);
        frame.getContentPane().add(backButton);

        frame.setVisible(true);
    }


}
