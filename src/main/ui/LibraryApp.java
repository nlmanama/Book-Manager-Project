package ui;

import model.Library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LibraryApp {

    private Library library;
    private ArrayList<String> acceptedInputs;

    // EFFECTS: run the library
    public LibraryApp() {
        runLibrary();
    }

    // MODIFIES: this
    // EFFECTS: execute each function of the application depending on user input
    private void runLibrary() {
        library = new Library();
        boolean stop = false;
        while (!stop) {
            String input = getInput();
            switch (input) {
                case "1":
                    addBook();
                    break;
                case "2":
                    searchAuthor();
                    break;
                case "E":
                    System.out.println("Thank you!");
                    stop = true;
                    break;
            }
        }
    }

    // EFFECTS: prompts for, accept and return the appropriate user input
    private String getInput() {
        acceptedInputs = new ArrayList<>(Arrays.asList("1", "2", "E"));
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter: ");
        System.out.println("1 - to add a book");
        System.out.println("2 - to find a book by author name");
        System.out.println("E - to end the session");

        String input = scan.nextLine();
        while (!acceptedInputs.contains(input)) {
            input = scan.nextLine();
        }

        return input;
    }

    // MODIFIES: this
    // EFFECTS: asks for user input for details needed to create Book object,
    //          create the book and add to the library's list of books
    private void addBook() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Title of book: ");
        String title = scan.nextLine();

        System.out.println("Author of book: ");
        String author = scan.nextLine();

        System.out.println("Rating: ");
        int rating = 0;
        try {
            rating = Integer.parseInt(scan.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Please only enter an integer.");
        }

        System.out.println("Date read:");
        int date = Integer.parseInt(scan.nextLine());

        System.out.println("Genre: ");
        String genre = scan.nextLine();

        library.addBook(title, author,rating, date, genre);
    }

    // EFFECTS: accept user input for a name, search the library's list of books for books with said author's name
    private void searchAuthor() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Name of author to search: ");
        String author = scan.nextLine();

        ArrayList booksFound = library.findAuthor(author);

        if (booksFound.size() == 0) {
            System.out.println("Sorry, no books by that author in the library.");
        } else {
            System.out.println("The books by that author are: ");
            outputAL(booksFound);
        }
    }

    // EFFECTS: print all elements in an ArrayList
    private void outputAL(ArrayList al) {
        for (int i = 0; i < al.size(); i++) {
            System.out.println(al.get(i));
        }
    }
}
