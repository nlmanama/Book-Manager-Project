package model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {
    private Book book1;

    @BeforeEach
    void runBefore() {
        book1 = new Book("Book", "Author", 5, 2023, "Genre");
    }

    @Test
    void constructorTest() {
        assertEquals("Book", book1.getTitle());
        assertEquals("Author", book1.getAuthor());
        assertTrue(book1.getTags().isEmpty());
    }

    @Test
    void addTagsTest() {
        book1.addTag("Romance");
        assertEquals("Romance", book1.getTags().get(0));
    }

    @Test
    void addMultipleTags() {
        book1.addTag("Action");
        book1.addTag("YA");
        assertEquals("Action", book1.getTags().get(0));
        assertEquals("YA", book1.getTags().get(1));
        assertEquals(2, book1.getTags().size());
    }
}