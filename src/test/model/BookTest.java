package model;


import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
        assertEquals(5, book1.getRating());
        assertEquals(2023, book1.getYearRead());
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

    @Test
    void containsTagsDoesContainTest() {
        book1.addTag("Action");
        book1.addTag("YA");
        ArrayList<String> checkTags = new ArrayList<>();
        checkTags.add("YA");
        checkTags.add("Action");
        boolean contains = book1.containsTags(checkTags);
        assertTrue(contains);
    }

    @Test
    void containsTagsNotContainAny() {
        book1.addTag("Action");
        book1.addTag("YA");
        ArrayList<String> checkTags = new ArrayList<>();
        checkTags.add("Mystery");
        boolean contains = book1.containsTags(checkTags);
        assertFalse(contains);
    }

    @Test
    void containsTagsContainOneButNotAll() {
        book1.addTag("Action");
        book1.addTag("YA");
        ArrayList<String> checkTags = new ArrayList<>();
        checkTags.add("YA");
        checkTags.add("Mystery");
        boolean contains = book1.containsTags(checkTags);
        assertFalse(contains);
    }

    @Test
    void toJsonTest() {
        JSONObject b1 = book1.toJson();
        assertEquals(b1.get("title"), "Book");
        assertEquals(b1.get("author"), "Author");
        assertEquals(b1.getInt("rating"), 5);
        assertEquals(b1.getInt("yearRead"), 2023);
        assertEquals(b1.getString("genre"), "Genre");
    }
}
