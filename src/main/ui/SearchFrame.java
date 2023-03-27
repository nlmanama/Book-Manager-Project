package ui;

import model.Book;
import model.Library;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SearchFrame {

    private JFrame frame;
    private Library lib;
    private MainFrame referenceBack;
    private JTextField author;
    private JTextField rating;
    private JTextField yearRead;
    private JTextField genre;

    public SearchFrame(Library l, MainFrame ref) {
        this.lib = l;
        this.referenceBack = ref;
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(400, 170, 800, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        searchByAuthor();
        searchByRating();
        searchByYear();
        searchByGenre();

        frame.setVisible(true);
    }

    private void searchByAuthor() {
        author = new JTextField();
        author.setBounds(150, 45, 200, 60);
        frame.getContentPane().add(author);

        JButton authorButton = new JButton("Search by author");
        authorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String search = author.getText();
                ArrayList<String> searchResults = lib.findAuthor(search);
            }
        });
        authorButton.setBounds(450, 45, 200, 60);
        frame.getContentPane().add(authorButton);
    }

    private void searchByRating() {
        rating = new JTextField();
        rating.setBounds(150, 135, 200, 60);
        frame.getContentPane().add(rating);

        JButton ratingButton = new JButton("Search by rating");
        ratingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int search = Integer.parseInt(rating.getText());
                ArrayList<String> searchResults = lib.findRating(search);
            }
        });
        ratingButton.setBounds(450, 135, 200, 60);
        frame.getContentPane().add(ratingButton);
    }

    private void searchByYear() {
        yearRead = new JTextField();
        yearRead.setBounds(150, 220, 200, 60);
        frame.getContentPane().add(yearRead);

        JButton yearReadButton = new JButton("Search by year read");
        yearReadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int search = Integer.parseInt(yearRead.getText());
                ArrayList<String> searchResults = lib.findYear(search);
            }
        });
        yearReadButton.setBounds(450, 220, 200, 60);
        frame.getContentPane().add(yearReadButton);
    }

    private void searchByGenre() {
        genre = new JTextField();
        genre.setBounds(150, 305, 200, 60);
        frame.getContentPane().add(genre);

        JButton genreButton = new JButton("Search by genre");
        genreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String search = genre.getText();
                ArrayList<String> searchResults = lib.findGenre(search);
            }
        });
        genreButton.setBounds(450, 305, 200, 60);
        frame.getContentPane().add(genreButton);
    }

}
