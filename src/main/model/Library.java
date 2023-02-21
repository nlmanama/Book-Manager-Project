package model;

import java.util.ArrayList;

// A library that contains a list of books
public class Library {

    private ArrayList<Book> books;

    // EFFECTS: create a library that has an empty list of books
    public Library() {
        books = new ArrayList<>();
    }

    // REQUIRES: title, author, genre are String, date and rating are int
    // MODIFIES: this
    // EFFECTS: create a book with given parameters and add it to the list of books
    public void addBook(String ti, String au, int rat, int date, String gen) {
        Book b = new Book(ti, au, rat, date, gen);
        books.add(b);
    }

    // REQUIRES: author must be a String
    // EFFECTS: search through the list of books and find all books with the given author name
    public ArrayList findAuthor(String author) {
        ArrayList<String> bookName = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            if (b.getAuthor().equals(author)) {
                bookName.add(b.getTitle());
            }
        }

        return bookName;
    }
}
