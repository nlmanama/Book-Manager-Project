package ui;

import model.Library;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DisplayResultsFrame {
    private ArrayList<String> results;
    private MainFrame referenceBack;
    private JFrame frame;
    private JTable table;
    private String[][] display;
    private String[] columnName = {"Book Titles"};

    public DisplayResultsFrame(ArrayList<String> titles, MainFrame ref) {
        this.results = titles;
        this.referenceBack = ref;
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(400, 170, 800, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        showBooks();
        addBackButton();

        frame.setVisible(true);
    }

    private void addBackButton() {
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                referenceBack.show();
                frame.setVisible(false);
            }
        });
        backButton.setBounds(300, 320, 200, 60);
        frame.getContentPane().add(backButton);
    }

    private void showBooks() {
        convertTo2DArray();
        table = new JTable(display, columnName);
        table.setBounds(100, 30, 600, 250);
        table.setDefaultEditor(Object.class, null);

        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(100, 30, 600, 250);
        frame.getContentPane().add(scroll);
    }

    private void convertTo2DArray() {
        display = new String[results.size()][1];
        for (int i = 0; i < results.size(); i++) {
            display[i][0] = results.get(i);
        }
    }
}
