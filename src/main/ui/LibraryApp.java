package ui;

import model.Book;
import model.Library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// A library management application
public class LibraryApp {

    private Library library;
    private ArrayList<String> acceptedInputs;

    // MODIFIES: this
    // EFFECTS: create and run the library
    public LibraryApp() {
        library = new Library();
        runLibrary();
    }

    // EFFECTS: execute each method of the application depending on user input
    private void runLibrary() {
        boolean stop = false;
        while (!stop) {
            String input = getInput();
            stop = handleInput(input);
        }
    }

    // REQUIRES: input be a String
    // EFFECTS: calls the corresponding method according to input
    private boolean handleInput(String input) {
        switch (input) {
            case "1":
                addBook();
                break;
            case "2":
                searchByAttribute();
                break;
            case "3":
                tagManagement();
                break;
            case "4":
                viewOrDelete();
                break;
            case "5":
                System.out.println("save and stuff");
                break;
            case "E":
                return true;
        }
        return false;
    }

    // EFFECTS: prompts for, accept and return the appropriate user input
    private String getInput() {
        acceptedInputs = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "E"));
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter: ");
        System.out.println("1 - to add a book");
        System.out.println("2 - to find a book by attribute");
        System.out.println("3 - to use tags management");
        System.out.println("4 - to view or delete books");
        System.out.println("E - to end the session");

        String input = scan.nextLine();
        while (!acceptedInputs.contains(input)) {
            System.out.println("Please only enter one of the given options:");
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

        System.out.println("Year read:");
        int year = Integer.parseInt(scan.nextLine());

        System.out.println("Genre: ");
        String genre = scan.nextLine();

        library.addBook(title, author,rating, year, genre);
    }

    private void viewOrDelete() {
        System.out.println("Please enter:");
        System.out.println("1 - To view all books");
        System.out.println("2 - To delete a book by title");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        switch (input) {
            case "1":
                viewAllBooks();
                break;
            case "2":
                deleteBook();
                break;
        }
    }

    // MODIFIES: this
    // EFFECTS: remove the book with the given title (if exists) in the library
    private void deleteBook() {
        System.out.println("Enter the title of the book to delete: ");
        Scanner scan = new Scanner(System.in);
        String title = scan.nextLine();
        boolean delete = library.deleteBook(title);
        if (delete) {
            System.out.println(title + " is deleted from library");
        } else {
            System.out.println("No books found with that name");
        }

    }

    // EFFECTS: display all the books in the library including their attributes
    private void viewAllBooks() {
        ArrayList<Book> books = library.getBooks();
        if (books.size() == 0) {
            System.out.println("No books in library");
        }
        for (int i = 0; i < books.size(); i++) {
            String pos = Integer.toString(i + 1);
            Book b = books.get(i);
            System.out.println(pos + " - " + b.getTitle() + " - Author: " + b.getAuthor() + " - Rating: "
                    + b.getRating() + " - Genre: " + b.getGenre() + " - Year Read: " + b.getYearRead());
        }
    }

    // EFFECTS: prompts user for which attribute to search for and calls appropriate methods
    private void searchByAttribute() {
        System.out.println("Please enter: ");
        System.out.println("1 - To search by author name");
        System.out.println("2 - To search by genre");
        System.out.println("3 - To search by rating");
        System.out.println("4 - To search by year read");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        switch (input) {
            case "1":
                searchAuthor();
                break;
            case "2":
                searchGenre();
                break;
            case "3":
                searchRating();
                break;
            case"4":
                searchYearRead();
                break;
        }
    }

    // EFFECTS: accept user input for a name, search the library's list of books for books with said author's name
    private void searchAuthor() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Name of author to search: ");
        String author = scan.nextLine();
        ArrayList booksFound = library.findAuthor(author);
        handleSearchResults(booksFound);
    }

    // EFFECTS: accept user input for genre, search library's list of books for books of that genre
    private void searchGenre() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Genre to search: ");
        String genre = scan.nextLine();
        ArrayList booksFound = library.findGenre(genre);
        handleSearchResults(booksFound);
    }

    // EFFECTS: accept user input for a rating, search library's list of books for books with that same rating
    private void searchRating() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Rating to search: ");
        int rating = Integer.parseInt(scan.nextLine());
        ArrayList booksFound = library.findRating(rating);
        handleSearchResults(booksFound);
    }

    // EFFECTS: accept user input for a date, search library's list of books for books read at that date
    private void searchYearRead() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Year read to search: ");
        int year = Integer.parseInt(scan.nextLine());
        ArrayList booksFound = library.findYear(year);
        handleSearchResults(booksFound);
    }

    // REQUIRES: booksFound be an ArrayList of String
    // EFFECTS: output message for no books found or the results if books were found in the search
    private void handleSearchResults(ArrayList booksFound) {
        if (booksFound.size() == 0) {
            System.out.println("Sorry, no books fit that attribute in the library.");
        } else {
            System.out.println("The books found are: ");
            outputAL(booksFound);
        }
    }

    // EFFECTS: print all elements in an ArrayList
    private void outputAL(ArrayList al) {
        for (int i = 0; i < al.size(); i++) {
            System.out.println(al.get(i));
        }
    }

    // EFFECTS: prompts and takes in input for which tag management function the user wants to use, calls appropriate
    //          method
    private void tagManagement() {
        System.out.println("Please enter: ");
        System.out.println("1 - to add a tag to a book");
        System.out.println("2 - find books by tags");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        switch (input) {
            case "1":
                addTagToBook();
                break;
            case "2":
                findBooksByTag();
                break;
        }
    }

    // MODIFIES: this
    // EFFECTS: add a tag that the user inputs to their book of choice
    private void addTagToBook() {
        System.out.println("Enter the title of the book to add a tag:");
        Scanner scan = new Scanner(System.in);
        String title = scan.nextLine();
        System.out.println("Enter a tag to add to the book:");
        String tag = scan.nextLine();
        boolean success = library.addTagToBook(title, tag);
        if (success) {
            System.out.println("Tag " + tag + " added to " + title);
        } else {
            System.out.println("Sorry, no book with that title was found");
        }
    }

    // EFFECTS: prompts and takes in input for tag to search by, search and display result
    private void findBooksByTag() {
        System.out.println("Enter how many tags to include: ");
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        ArrayList<String> checkTags = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            System.out.println("Enter the " + i + " tag:");
            checkTags.add(scan.nextLine());
        }
        ArrayList<String> bookName = library.searchByTags(checkTags);
        if (bookName.size() == 0) {
            System.out.println("No books with those tags in library");
        } else {
            System.out.println("Books with those tags are:");
            outputAL(bookName);
        }
    }
}
