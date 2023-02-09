package model;

import java.util.ArrayList;

public class Book {
    private ArrayList<String> tags;
    private String genre;
    private String title;
    private int rating;
    private int dateRead;
    private String author;

    public Book(String ti, String au, int rat, int date, String gen) {
        this.title = ti;
        this.author = au;
        this.rating = rat;
        this.dateRead = date;
        this.genre = gen;
        this.tags = new ArrayList<>();
    }

    public void addTag(String tag) {
        tags.add(tag);
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}
