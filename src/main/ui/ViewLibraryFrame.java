package ui;

import model.Book;
import model.Library;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ViewLibraryFrame {
    private Library library;
    private MainFrame referenceBack;
    private JFrame frame;
    private JTable table;
    private String[][] display;
    private String[] columnName = {"Title", "Author", "Rating", "Year Read", "Genre"};

    public ViewLibraryFrame(Library l, MainFrame ref) {
        library = l;
        referenceBack = ref;
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
        ArrayList<Book> books = library.getBooks();
        display = new String[books.size()][5];
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            String ti = b.getTitle();
            String au = b.getAuthor();
            String ra = String.valueOf(b.getRating());
            String year = String.valueOf(b.getYearRead());
            String genre = b.getGenre();
            String[] populateData = {ti, au, ra, year, genre};
            for (int x = 0; x < 5; x++) {
                display[i][x] = populateData[x];
            }
        }
    }

}
