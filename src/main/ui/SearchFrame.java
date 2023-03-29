package ui;

import model.Book;
import model.Library;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// A window to search for books by their features
public class SearchFrame {

    private JFrame frame;
    private Library lib;
    private MainFrame referenceBack;
    private JTextField author;
    private JTextField rating;
    private JTextField yearRead;
    private JTextField genre;

    // REQUIRES: l is a Library, ref is the MainFrame object that created this
    // EFFECTS: Create a frame that allows features of a book to be entered and search for, with the library being
    // searched and a reference to the MainFrame object that created this
    public SearchFrame(Library l, MainFrame ref) {
        this.lib = l;
        this.referenceBack = ref;
        initialize();
    }

    // MODIFIES: this
    // EFFECTS: creates the frame and adds features to it
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

    // MODIFIES: this
    // EFFECTS: adds the JTextField to enter the author, add a JButton to that searches for books with this author
    // and show results
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
                new DisplayResultsFrame(searchResults, referenceBack);
                frame.setVisible(false);
            }
        });
        authorButton.setBounds(450, 45, 200, 60);
        frame.getContentPane().add(authorButton);
    }

    // MODIFIES: this
    // EFFECTS: adds the JTextField to enter the rating, add a JButton to that searches for books with this rating
    // and show results
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
                new DisplayResultsFrame(searchResults, referenceBack);
                frame.setVisible(false);
            }
        });
        ratingButton.setBounds(450, 135, 200, 60);
        frame.getContentPane().add(ratingButton);
    }

    // MODIFIES: this
    // EFFECTS: adds the JTextField to enter the year read, add a JButton to that searches for books read this year
    // and show results
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
                new DisplayResultsFrame(searchResults, referenceBack);
                frame.setVisible(false);
            }
        });
        yearReadButton.setBounds(450, 220, 200, 60);
        frame.getContentPane().add(yearReadButton);
    }

    // MODIFIES: this
    // EFFECTS: adds the JTextField to enter the genre, add a JButton to that searches for books with this genre
    // and show results
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
                new DisplayResultsFrame(searchResults, referenceBack);
                frame.setVisible(false);
            }
        });
        genreButton.setBounds(450, 305, 200, 60);
        frame.getContentPane().add(genreButton);
    }

}
