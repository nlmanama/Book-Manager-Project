package persistence;

import model.Book;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkBook(Book b, String t, String au, String gen, int rat, int year, ArrayList tags) {
        assertEquals(t, b.getTitle());
        assertEquals(au, b.getAuthor());
        assertEquals(gen, b.getGenre());
        assertEquals(rat, b.getRating());
        assertEquals(year, b.getYearRead());
        assertEquals(tags, b.getTags());
    }
}
