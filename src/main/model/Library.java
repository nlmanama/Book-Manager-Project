package model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

// A library that contains a list of books
public class Library {

    private ArrayList<Book> books;

    // EFFECTS: create a library that has an empty list of books
    public Library() {
        books = new ArrayList<>();
    }

    // REQUIRES: title, author, genre are String, year and rating are int
    // MODIFIES: this
    // EFFECTS: create a book with given parameters and add it to the list of books
    public void addBook(String ti, String au, int rat, int year, String gen) {
        Book b = new Book(ti, au, rat, year, gen);
        books.add(b);
    }

    // REQUIRES: b is a Book object
    // MODIFIES: this
    // EFFECTS: add book to library
    public void addBook(Book b) {
        books.add(b);
    }

    // REQUIRES: title be String
    // MODIFIES: this
    // EFFECTS: remove the book with the given title, if multiple books found, the latest added one is removed,
    //          if none found, nothing is changed
    public boolean deleteBook(String title) {
        int index = -1;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equals(title)) {
                index = i;
            }
        }
        if (index >= 0) {
            books.remove(index);
            return true;
        } else {
            return false;
        }
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


    // REQUIRES: genre must be a String
    // EFFECTS: search through the list of books and find all books in the genre
    public ArrayList findGenre(String genre) {
        ArrayList<String> bookName = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            if (b.getGenre().equals(genre)) {
                bookName.add(b.getTitle());
            }
        }
        return bookName;
    }

    // REQUIRES: rating be an integer
    // EFFECTS: search through the list of books and find all books with the same rating
    public ArrayList findRating(int rating) {
        ArrayList<String> bookName = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            if (b.getRating() == rating) {
                bookName.add(b.getTitle());
            }
        }
        return bookName;
    }

    // REQUIRES: year be an integer
    // EFFECTS: search through the list of books and find all books read in the same year
    public ArrayList findYear(int year) {
        ArrayList<String> bookName = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            if (b.getYearRead() == year) {
                bookName.add(b.getTitle());
            }
        }
        return bookName;
    }

    public ArrayList getBooks() {
        return books;
    }

    // REQUIRES: both title and tag be String
    // MODIFIES: this
    // EFFECTS: add a tag to the book with the title given, return true if successful, false if no books found with
    // that title. If multiple books have the same title, tag is added to all.
    public boolean addTagToBook(String title, String tag) {
        boolean added = false;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equals(title)) {
                books.get(i).addTag(tag);
                added = true;
            }
        }
        return added;
    }

    // REQUIRES: tags to be an ArrayList of String
    // EFFECTS: search through library for all books that contain all tags asked for, return the books' name
    public ArrayList searchByTags(ArrayList<String> tags) {
        ArrayList<String> bookName = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).containsTags(tags)) {
                bookName.add(books.get(i).getTitle());
            }
        }
        return bookName;
    }

    // EFFECTS: creates a JSON object of this library
    public JSONObject toJson() {
        JSONObject libJson = new JSONObject();
        JSONArray arrayOfBooks = new JSONArray();
        for (Book b: books) {
            arrayOfBooks.put(b.toJson());
        }
        libJson.put("books", arrayOfBooks);
        return libJson;
    }

}
