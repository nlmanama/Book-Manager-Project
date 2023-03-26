package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class MainFrame {
    private JFrame frame;
    private SplashFrame splash;

    public MainFrame() {
        //showSplashScreen();
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(400, 170, 800, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        addBookButton();
        addViewLibraryButton();
        addFindBookButton();
        addSaveButton();
        addLoadButton();

        frame.setVisible(true);
    }

    private void showSplashScreen() {
        try {
            splash = new SplashFrame();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        splash.hide();
    }

    private void addBookButton() {
        JButton addBookButton = new JButton("Add Book");
        addBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Books being added");
            }
        });
        addBookButton.setBounds(300, 30, 200, 60);
        frame.getContentPane().add(addBookButton);
    }

    private void addViewLibraryButton() {
        JButton viewLibrary = new JButton("View Library");
        viewLibrary.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Viewing in progress");
            }
        });
        viewLibrary.setBounds(300, 120, 200, 60);
        frame.getContentPane().add(viewLibrary);
    }

    private void addFindBookButton() {
        JButton findBookButton = new JButton("Find Book");
        findBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Books being found");
            }
        });
        findBookButton.setBounds(300, 210, 200, 60);
        frame.getContentPane().add(findBookButton);
    }

    private void addSaveButton() {
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Saving stuff");
            }
        });
        saveButton.setBounds(185, 300, 200, 60);
        frame.getContentPane().add(saveButton);
    }

    private void addLoadButton() {
        JButton loadButton = new JButton("Save");
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Stuff loaded");
            }
        });
        loadButton.setBounds(415, 300, 200, 60);
        frame.getContentPane().add(loadButton);
    }

}
