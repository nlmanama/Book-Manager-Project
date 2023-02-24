package ui;

import model.Book;
import model.Library;

import java.sql.SQLOutput;
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
                    searchByAttribute();
                    break;
                case "3":
                    viewAllBooks();
                    break;
                case "4":
                    deleteBook();
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
        acceptedInputs = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "E"));
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter: ");
        System.out.println("1 - to add a book");
        System.out.println("2 - to find a book by attribute");
        System.out.println("3 - to view all books");
        System.out.println("4 - to delete a book by title");
        System.out.println("E - to end the session");

        String input = scan.nextLine();
        while (!acceptedInputs.contains(input)) {
            System.out.println("Please only enter one of the given options:");
            input = scan.nextLine();
        }

        return input;
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
                    + b.getRating() + " - Genre: " + b.getGenre());
        }
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

    // EFFECTS: prompts user for which attribute to search for and calls appropriate methods
    private void searchByAttribute() {
        System.out.println("Please enter: ");
        System.out.println("1 - To search by author name");
        System.out.println("2 - To search by genre");
        System.out.println("3 - To search by rating");
        System.out.println("4 - To search by date read");
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
                searchDateRead();
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
    private void searchDateRead() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Date read to search: ");
        int date = Integer.parseInt(scan.nextLine());
        ArrayList booksFound = library.findDate(date);
        handleSearchResults(booksFound);
    }

    // REQUIRES: booksFound be an ArrayList of Book
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
}
