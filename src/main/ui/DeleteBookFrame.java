package ui;

import model.Library;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteBookFrame {

    private JFrame frame;
    private JTextField title;
    private MainFrame referenceBack;

    public DeleteBookFrame(MainFrame ref) {
        this.referenceBack = ref;
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(600, 270, 400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        deleteLabelArea();
        addDeleteButton();

        frame.setVisible(true);
    }

    private void deleteLabelArea() {
        JLabel titleLabel = new JLabel("Title to delete:");
        titleLabel.setBounds(150, 30, 200, 40);
        frame.getContentPane().add(titleLabel);

        title = new JTextField();
        title.setBounds(100, 70, 200, 40);
        frame.getContentPane().add(title);
    }

    private void addDeleteButton() {
        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String deleteTitle = title.getText();
                boolean deleted = referenceBack.deleteBookFromLibrary(deleteTitle);
                referenceBack.show();
                if (deleted) {
                    new MessageFrame("Deleted");
                } else {
                    new MessageFrame("Failed");
                }
                frame.setVisible(false);
            }
        });
        deleteButton.setBounds(125, 135, 150, 30);
        frame.getContentPane().add(deleteButton);
    }

}
