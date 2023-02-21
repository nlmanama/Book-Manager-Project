package model;

import java.util.ArrayList;

// Represents a book with a title, author, rating, date read, genre, and, customs tags
public class Book {
    private String title;
    private String author;
    private int rating;
    private int dateRead;
    private String genre;
    private ArrayList<String> tags;

    // REQUIRES: title, author, genre are String, date and rating are int
    // EFFECTS: create a book with a title, author, genre, date read and rating,
    //          with an empty tags list
    public Book(String ti, String au, int rat, int date, String gen) {
        this.title = ti;
        this.author = au;
        this.rating = rat;
        this.dateRead = date;
        this.genre = gen;
        this.tags = new ArrayList<>();
    }

    // REQUIRES: tag is a String
    // MODIFIES: this
    // EFFECTS: add tag to ArrayList tags
    public void addTag(String tag) {
        tags.add(tag);
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getRating() {
        return rating;
    }

    public int getDateRead() {
        return dateRead;
    }

    public String getGenre() {
        return genre;
    }

    public ArrayList getTags() {
        return tags;
    }


}

