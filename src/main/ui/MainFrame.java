package ui;

import model.Book;
import model.Library;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainFrame {
    private JFrame frame;
    private SplashFrame splash;
    private MainFrame reference = this;
    private Library library;

    public MainFrame() {
        library = new Library();
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
                AddBookFrame addBookFrame = new AddBookFrame(reference);
                frame.setVisible(false);
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
                ViewLibraryFrame viewFrame = new ViewLibraryFrame(library, reference);
                frame.setVisible(false);
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
        JButton loadButton = new JButton("Load");
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Stuff loaded");
            }
        });
        loadButton.setBounds(415, 300, 200, 60);
        frame.getContentPane().add(loadButton);
    }

    public void show() {
        frame.setVisible(true);
    }

    public void hide() {
        frame.setVisible(false);
    }

    public void addBookToLibrary(Book b) {
        library.addBook(b);
    }

    public void testOutput() {
        ArrayList<Book> books = library.getBooks();
        ArrayList<String> names = new ArrayList<>();
        for (Book b: books) {
            names.add(b.getTitle());
        }
        outputAL(names);
    }

    private void outputAL(ArrayList al) {
        for (int i = 0; i < al.size(); i++) {
            System.out.println(al.get(i));
        }
    }

}
