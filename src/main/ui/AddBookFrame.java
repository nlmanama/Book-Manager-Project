package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBookFrame {

    private JFrame frame;
    private MainFrame referenceBack;

    public AddBookFrame(MainFrame ref) {
        initialize();
        referenceBack = ref;
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(400, 170, 800, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        addBookButton();

        frame.setVisible(true);
    }

    public void hide() {
        frame.setVisible(false);
    }

    private void addBookButton() {
        JButton enterButton = new JButton("Add Book");
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                referenceBack.show();
                frame.setVisible(false);
            }
        });
        enterButton.setBounds(300, 300, 200, 60);
        frame.getContentPane().add(enterButton);
    }
}
