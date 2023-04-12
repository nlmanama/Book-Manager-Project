package ui;

import model.Book;
import model.Event;
import model.EventLog;
import model.Library;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;

// The window with the main menu of the application
public class MainFrame implements WindowListener {
    private JFrame frame;
    private SplashFrame splash;
    private MainFrame reference = this;
    private Library library;

    private static final String JSON_STORE = "./data/library.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // EFFECTS: create a MainFrame with a JsonWriter and a JsonReader to the data file, a new library and show the
    // splash screen
    public MainFrame() {
        library = new Library();
        showSplashScreen();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        initialize();
    }

    // MODIFIES: this
    // EFFECTS: creates the frame and adds features to it
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(400, 170, 800, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setBackground(Color.WHITE);

        addBookButton();
        deleteBookButton();
        addViewLibraryButton();
        addFindBookButton();
        addSaveButton();
        addLoadButton();

        frame.addWindowListener(this);
        frame.setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: show the splash screen for a few seconds
    private void showSplashScreen() {
        try {
            splash = new SplashFrame();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        splash.hide();
    }

    // MODIFIES: this
    // EFFECTS: add a JButton to frame that opens the window to add a book, also hides the main frame
    private void addBookButton() {
        JButton addBookButton = new JButton("Add Book");
        addBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddBookFrame addBookFrame = new AddBookFrame(reference);
                frame.setVisible(false);
            }
        });
        addBookButton.setBounds(185, 30, 200, 60);
        frame.getContentPane().add(addBookButton);
    }

    // MODIFIES: this
    // EFFECTS: add a JButton to frame that opens the window to delete a book, also hides the main frame
    private void deleteBookButton() {
        JButton deleteBookButton = new JButton("Delete Book");
        deleteBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteBookFrame deleteBookFrame = new DeleteBookFrame(reference);
                frame.setVisible(false);
            }
        });
        deleteBookButton.setBounds(415, 30, 200, 60);
        frame.getContentPane().add(deleteBookButton);
    }

    // MODIFIES: this
    // EFFECTS: add a JButton to frame that opens the window to view all books, also hides the main frame
    private void addViewLibraryButton() {
        JButton viewLibrary = new JButton("View Library");
        viewLibrary.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewLibraryFrame viewFrame = new ViewLibraryFrame(library, reference);
                frame.setVisible(false);
            }
        });
        viewLibrary.setBounds(300, 120, 200, 60);
        frame.getContentPane().add(viewLibrary);
    }

    // MODIFIES: this
    // EFFECTS: add a JButton to frame that opens the window to find books, also hides the main frame
    private void addFindBookButton() {
        JButton findBookButton = new JButton("Find Book");
        findBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchFrame searchFrame = new SearchFrame(library, reference);
                frame.setVisible(false);
            }
        });
        findBookButton.setBounds(300, 210, 200, 60);
        frame.getContentPane().add(findBookButton);
    }

    // MODIFIES: this
    // EFFECTS: add a JButton to frame that opens the window to save the current library, also hides the main frame
    private void addSaveButton() {
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    jsonWriter.open();
                    jsonWriter.write(library);
                    jsonWriter.close();
                    new MessageFrame("Saved library to " + JSON_STORE);
                } catch (FileNotFoundException ex) {
                    new MessageFrame("Unable to write to file: " + JSON_STORE);
                }
            }
        });
        saveButton.setBounds(185, 300, 200, 60);
        frame.getContentPane().add(saveButton);
    }

    // MODIFIES: this
    // EFFECTS: add a JButton to frame that opens the window to load up the stored library, also hides the main frame
    private void addLoadButton() {
        JButton loadButton = new JButton("Load");
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    library = jsonReader.read();
                    new MessageFrame("Loaded library from " + JSON_STORE);
                } catch (IOException ex) {
                    new MessageFrame("Unable to read from file: " + JSON_STORE);
                }
            }
        });
        loadButton.setBounds(415, 300, 200, 60);
        frame.getContentPane().add(loadButton);
    }

    // MODIFIES: this
    // EFFECTS: show the frame
    public void show() {
        frame.setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: hides the frame
    public void hide() {
        frame.setVisible(false);
    }

    // REQUIRES: b is a Book object
    // MODIFIES: this
    // EFFECTS: add the given book to the library
    public void addBookToLibrary(Book b) {
        library.addBook(b);
    }

    // REQUIRES: title is a String
    // MODIFIES: this
    // EFFECTS: delete the book with the title from library, return the status of the operation
    public boolean deleteBookFromLibrary(String title) {
        return library.deleteBook(title);
    }


    private void displayLog(EventLog el) {
        for (Event e : el) {
            System.out.println(e.toString() + "\n");
        }
    }


    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        displayLog(EventLog.getInstance());
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

}
