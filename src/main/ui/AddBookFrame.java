package ui;

import model.Book;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// A window that allows features of a book to be input and adds the book to library
public class AddBookFrame {

    private JFrame frame;
    private JTextField title;
    private JTextField author;
    private JTextField rating;
    private JTextField yearRead;
    private JTextField genre;

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

        addTitleArea();
        addAuthorArea();
        addRatingArea();
        addYearReadArea();
        addGenreArea();
        addBookButton();

        frame.setVisible(true);
    }

    public void hide() {
        frame.setVisible(false);
    }

    private void addTitleArea() {
        JLabel titleLabel = new JLabel("Title:");
        titleLabel.setBounds(250, 30, 200, 30);
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 28));
        frame.getContentPane().add(titleLabel);

        title = new JTextField();
        title.setBounds(400, 30, 200, 30);
        frame.getContentPane().add(title);
    }

    private void addAuthorArea() {
        JLabel authorLabel = new JLabel("Author:");
        authorLabel.setBounds(250, 80, 200, 30);
        authorLabel.setFont(new Font("Arial", Font.PLAIN, 28));
        frame.getContentPane().add(authorLabel);

        author = new JTextField();
        author.setBounds(400, 80, 200, 30);
        frame.getContentPane().add(author);
    }

    private void addRatingArea() {
        JLabel ratingLabel = new JLabel("Rating:");
        ratingLabel.setBounds(250, 130, 200, 30);
        ratingLabel.setFont(new Font("Arial", Font.PLAIN, 28));
        frame.getContentPane().add(ratingLabel);

        rating = new JTextField();
        rating.setBounds(400, 130, 200, 30);
        frame.getContentPane().add(rating);
    }

    private void addYearReadArea() {
        JLabel yearLabel = new JLabel("Year read:");
        yearLabel.setBounds(250, 180, 200, 30);
        yearLabel.setFont(new Font("Arial", Font.PLAIN, 28));
        frame.getContentPane().add(yearLabel);

        yearRead = new JTextField();
        yearRead.setBounds(400, 180, 200, 30);
        frame.getContentPane().add(yearRead);
    }

    private void addGenreArea() {
        JLabel genreLabel = new JLabel("Genre:");
        genreLabel.setBounds(250, 230, 200, 30);
        genreLabel.setFont(new Font("Arial", Font.PLAIN, 28));
        frame.getContentPane().add(genreLabel);

        genre = new JTextField();
        genre.setBounds(400, 230, 200, 30);
        frame.getContentPane().add(genre);
    }

    private void addBookButton() {
        JButton enterButton = new JButton("Add Book");
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                referenceBack.show();
                frame.setVisible(false);
                Book bookMade = createBook();
                referenceBack.addBookToLibrary(bookMade);
            }
        });
        enterButton.setBounds(300, 300, 200, 60);
        frame.getContentPane().add(enterButton);
    }

    private Book createBook() {
        String ti = title.getText();
        String au = author.getText();
        int ra = Integer.parseInt(rating.getText());
        int year = Integer.parseInt(yearRead.getText());
        String gen = genre.getText();
        Book b = new Book(ti, au, ra, year, gen);
        return b;
    }
}
