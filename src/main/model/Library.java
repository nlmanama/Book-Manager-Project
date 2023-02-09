package model;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(String ti, String au, int rat, int date, String gen) {
        Book b = new Book(ti, au, rat, date, gen);
        books.add(b);
    }

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
