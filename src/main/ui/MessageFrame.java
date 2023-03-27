package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MessageFrame {

    private JFrame frame;
    private String message;

    public MessageFrame(String mes) {
        this.message = mes;
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(600, 270, 400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel display = new JLabel(message);
        display.setBounds(100, -20, 200, 175);
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
