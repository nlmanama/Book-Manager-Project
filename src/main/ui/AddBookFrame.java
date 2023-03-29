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

    // REQUIRES: ref be the MainFrame object that created this object
    // EFFECTS: Construct a frame that allows a book to be added, has a reference to the MainFrame object that
    // created this frame.
    public AddBookFrame(MainFrame ref) {
        initialize();
        referenceBack = ref;
    }

    // MODIFIES: this
    // EFFECTS: create the JFrame for the window, adds features to the frame
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

    // MODIFIES: this
    // EFFECTS: hides the frame
    public void hide() {
        frame.setVisible(false);
    }

    // MODIFIES: this
    // EFFECTS: adds JLabel to prompt for a title, and the JTextField to enter the title
    private void addTitleArea() {
        JLabel titleLabel = new JLabel("Title:");
        titleLabel.setBounds(250, 30, 200, 30);
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 28));
        frame.getContentPane().add(titleLabel);

        title = new JTextField();
        title.setBounds(400, 30, 200, 30);
        frame.getContentPane().add(title);
    }

    // MODIFIES: this
    // EFFECTS: adds JLabel to prompt for an author, and the JTextField to enter the author
    private void addAuthorArea() {
        JLabel authorLabel = new JLabel("Author:");
        authorLabel.setBounds(250, 80, 200, 30);
        authorLabel.setFont(new Font("Arial", Font.PLAIN, 28));
        frame.getContentPane().add(authorLabel);

        author = new JTextField();
        author.setBounds(400, 80, 200, 30);
        frame.getContentPane().add(author);
    }

    // MODIFIES: this
    // EFFECTS: adds JLabel to prompt for a rating, and the JTextField to enter the rating
    private void addRatingArea() {
        JLabel ratingLabel = new JLabel("Rating:");
        ratingLabel.setBounds(250, 130, 200, 30);
        ratingLabel.setFont(new Font("Arial", Font.PLAIN, 28));
        frame.getContentPane().add(ratingLabel);

        rating = new JTextField();
        rating.setBounds(400, 130, 200, 30);
        frame.getContentPane().add(rating);
    }

    // MODIFIES: this
    // EFFECTS: adds JLabel to prompt for the year read, and the JTextField to enter the year read
    private void addYearReadArea() {
        JLabel yearLabel = new JLabel("Year read:");
        yearLabel.setBounds(250, 180, 200, 30);
        yearLabel.setFont(new Font("Arial", Font.PLAIN, 28));
        frame.getContentPane().add(yearLabel);

        yearRead = new JTextField();
        yearRead.setBounds(400, 180, 200, 30);
        frame.getContentPane().add(yearRead);
    }

    // MODIFIES: this
    // EFFECTS: adds JLabel to prompt for a genre, and the JTextField to enter the genre
    private void addGenreArea() {
        JLabel genreLabel = new JLabel("Genre:");
        genreLabel.setBounds(250, 230, 200, 30);
        genreLabel.setFont(new Font("Arial", Font.PLAIN, 28));
        frame.getContentPane().add(genreLabel);

        genre = new JTextField();
        genre.setBounds(400, 230, 200, 30);
        frame.getContentPane().add(genre);
    }

    // MODIFIES: this, referenceBack
    // EFFECTS: adds a JButton that adds a book with the entered feature to the library, hides the frame
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

    // REQUIRES: JTextField rating and JTextField yearRead to have integers entered in
    // EFFECTS: constructs and return a Book object with featured entered in
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
