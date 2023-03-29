package ui;

import model.Library;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// A window screen to delete book
public class DeleteBookFrame {

    private JFrame frame;
    private JTextField title;
    private MainFrame referenceBack;

    // REQUIRES: ref be the MainFrame object that created this object
    // EFFECTS: create a window frame that allows the title of a book to be entered, deletes that book from library
    // if exists. Has reference to the MainFrame object that created this frame.
    public DeleteBookFrame(MainFrame ref) {
        this.referenceBack = ref;
        initialize();
    }

    // MODIFIES: this
    // EFFECTS: create the JFrame for the window, adds features to the frame
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(600, 270, 400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        deleteLabelArea();
        addDeleteButton();

        frame.setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: create JLabel to prompt for the title of book, also initialize the JTextField to enter the title, add
    // both to frame
    private void deleteLabelArea() {
        JLabel titleLabel = new JLabel("Title to delete:");
        titleLabel.setBounds(150, 30, 200, 40);
        frame.getContentPane().add(titleLabel);

        title = new JTextField();
        title.setBounds(100, 70, 200, 40);
        frame.getContentPane().add(title);
    }

    // MODIFIES: this, referenceBack
    // EFFECTS: add JButton to frame that deletes the book with the entered title from library, response appropriately
    // and hide frame
    private void addDeleteButton() {
        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String deleteTitle = title.getText();
                boolean deleted = referenceBack.deleteBookFromLibrary(deleteTitle);
                referenceBack.show();
                if (deleted) {
                    new MessageFrame("Deleted " + deleteTitle);
                } else {
                    new MessageFrame("Failed to delete " + deleteTitle);
                }
                frame.setVisible(false);
            }
        });
        deleteButton.setBounds(125, 135, 150, 30);
        frame.getContentPane().add(deleteButton);
    }

}
