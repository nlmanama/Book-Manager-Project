package model;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    private Library lib1;

    @BeforeEach
    void runBefore() {
        lib1 = new Library();
    }

    @Test
    void constructorTest() {
        assertTrue(lib1.getBooks().isEmpty());
    }

    @Test
    void addBookTest() {
        lib1.addBook("Book1", "Author1", 5, 2023, "Gen1");
        ArrayList<Book> books = lib1.getBooks();
        assertEquals(1, books.size());
        assertEquals("Book1", books.get(0).getTitle());
    }

    @Test
    void addMultipleBooksTest() {
        lib1.addBook("Book1", "Author1", 5, 2023, "Gen1");
        lib1.addBook("Book2", "Author2", 4, 2024, "Gen2");
        ArrayList<Book> books = lib1.getBooks();
        assertEquals(2, books.size());
        assertEquals("Book1", books.get(0).getTitle());
        assertEquals("Book2", books.get(1).getTitle());
        assertEquals("Gen2", books.get(1).getGenre());
    }

    @Test
    void differentAddBookTest() {
        Book b = new Book ("Book1", "Author1", 5, 2023, "Gen1");
        lib1.addBook(b);
        ArrayList<Book> books = lib1.getBooks();
        assertEquals(1, books.size());
        assertEquals("Book1", books.get(0).getTitle());
    }

    @Test
    void differentAddMultipleBooksTest() {
        Book b1 = new Book("Book1", "Author1", 5, 2023, "Gen1");
        Book b2 = new Book("Book2", "Author2", 4, 2024, "Gen2");
        lib1.addBook(b1);
        lib1.addBook(b2);
        ArrayList<Book> books = lib1.getBooks();
        assertEquals(2, books.size());
        assertEquals("Book1", books.get(0).getTitle());
        assertEquals("Book2", books.get(1).getTitle());
        assertEquals("Gen2", books.get(1).getGenre());
    }


    @Test
    void findAuthorNoneExistTest() {
        lib1.addBook("Book1", "Author1", 5, 2023, "Gen1");
        lib1.addBook("Book2", "Author2", 4, 2024, "Gen2");
        ArrayList<String> books = lib1.findAuthor("Author3");
        assertTrue(books.isEmpty());
    }

    @Test
    void findAuthorOneBookTest() {
        lib1.addBook("Book1", "Author1", 5, 2023, "Gen1");
        lib1.addBook("Book2", "Author2", 4, 2024, "Gen2");
        ArrayList<String> books = lib1.findAuthor("Author2");
        assertEquals(1, books.size());
        assertEquals("Book2", books.get(0));
    }

    @Test
    void findAuthorMultipleBooksTest() {
        lib1.addBook("Book1", "Author1", 5, 2023, "Gen1");
        lib1.addBook("Book2", "Author2", 4, 2024, "Gen2");
        lib1.addBook("Book3", "Author1", 5, 2025, "Gen1");
        ArrayList<String> books = lib1.findAuthor("Author1");
        assertEquals(2, books.size());
        assertEquals("Book1", books.get(0));
        assertEquals("Book3", books.get(1));
    }

    @Test
    void findGenreNoneExistTest() {
        lib1.addBook("Book1", "Author1", 5, 2023, "Gen1");
        lib1.addBook("Book2", "Author2", 4, 2024, "Gen2");
        ArrayList<String> books = lib1.findGenre("Gen4");
        assertTrue(books.isEmpty());
    }

    @Test
    void findGenreOneBookTest() {
        lib1.addBook("Book1", "Author1", 5, 2023, "Gen1");
        lib1.addBook("Book2", "Author2", 4, 2024, "Gen2");
        ArrayList<String> books = lib1.findGenre("Gen2");
        assertEquals(1, books.size());
        assertEquals("Book2", books.get(0));
    }

    @Test
    void findGenreMultipleBooksTest() {
        lib1.addBook("Book1", "Author1", 5, 2023, "Gen1");
        lib1.addBook("Book2", "Author2", 4, 2024, "Gen2");
        lib1.addBook("Book3", "Author1", 5, 2025, "Gen1");
        ArrayList<String> books = lib1.findGenre("Gen1");
        assertEquals(2, books.size());
        assertEquals("Book1", books.get(0));
        assertEquals("Book3", books.get(1));
    }

    @Test
    void findRatingNoneExistTest() {
        lib1.addBook("Book1", "Author1", 5, 2023, "Gen1");
        lib1.addBook("Book2", "Author2", 4, 2024, "Gen2");
        ArrayList<String> books = lib1.findRating(3);
        assertTrue(books.isEmpty());
    }

    @Test
    void findRatingOneBookTest() {
        lib1.addBook("Book1", "Author1", 5, 2023, "Gen1");
        lib1.addBook("Book2", "Author2", 4, 2024, "Gen2");
        ArrayList<String> books = lib1.findRating(4);
        assertEquals(1, books.size());
        assertEquals("Book2", books.get(0));
    }

    @Test
    void findRatingMultipleBooksTest() {
        lib1.addBook("Book1", "Author1", 5, 2023, "Gen1");
        lib1.addBook("Book2", "Author2", 4, 2024, "Gen2");
        lib1.addBook("Book3", "Author1", 5, 2025, "Gen1");
        ArrayList<String> books = lib1.findRating(5);
        assertEquals(2, books.size());
        assertEquals("Book1", books.get(0));
        assertEquals("Book3", books.get(1));
    }

    @Test
    void findYearReadNoneExistTest() {
        lib1.addBook("Book1", "Author1", 5, 2023, "Gen1");
        lib1.addBook("Book2", "Author2", 4, 2024, "Gen2");
        ArrayList<String> books = lib1.findYear(2011);
        assertTrue(books.isEmpty());
    }

    @Test
    void findYearReadOneBookTest() {
        lib1.addBook("Book1", "Author1", 5, 2023, "Gen1");
        lib1.addBook("Book2", "Author2", 4, 2024, "Gen2");
        ArrayList<String> books = lib1.findYear(2024);
        assertEquals(1, books.size());
        assertEquals("Book2", books.get(0));
    }

    @Test
    void findYearReadMultipleBooksTest() {
        lib1.addBook("Book1", "Author1", 5, 2023, "Gen1");
        lib1.addBook("Book2", "Author2", 4, 2024, "Gen2");
        lib1.addBook("Book3", "Author1", 5, 2023, "Gen1");
        ArrayList<String> books = lib1.findYear(2023);
        assertEquals(2, books.size());
        assertEquals("Book1", books.get(0));
        assertEquals("Book3", books.get(1));
    }

    @Test
    void deleteBookFoundTest() {
        lib1.addBook("Book1", "Author1", 5, 2023, "Gen1");
        boolean delete = lib1.deleteBook("Book1");
        assertTrue(delete);
        assertTrue(lib1.getBooks().isEmpty());
    }

    @Test
    void deleteBookNoneFoundTest() {
        lib1.addBook("Book1", "Author1", 5, 2023, "Gen1");
        boolean delete = lib1.deleteBook("Book2");
        assertFalse(delete);
        assertEquals(1, lib1.getBooks().size());
    }

    @Test
    void deleteBookDifferentIndex() {
        lib1.addBook("Book1", "Author1", 5, 2023, "Gen1");
        lib1.addBook("Book2", "Author2", 4, 2024, "Gen2");
        lib1.addBook("Book3", "Author1", 5, 2023, "Gen1");
        boolean delete = lib1.deleteBook("Book2");
        assertTrue(delete);
        assertEquals(2, lib1.getBooks().size());
        ArrayList<Book> books = lib1.getBooks();
        Book b1 = books.get(0);
        Book b2 = books.get(1);
        assertEquals("Book1", b1.getTitle());
        assertEquals("Book3", b2.getTitle());
    }

    @Test
    void addTagToBookSuccessTest() {
        lib1.addBook("Book1", "Author1", 5, 2023, "Gen1");
        boolean success = lib1.addTagToBook("Book1", "Favourite");
        assertTrue(success);
        ArrayList<Book> books = lib1.getBooks();
        Book b = books.get(0);
        assertEquals(1, b.getTags().size());
    }

    @Test
    void searchByTagsNoneExistTest() {
        lib1.addBook("Book1", "Author1", 5, 2023, "Gen1");
        lib1.addTagToBook("Book1", "Favourite");
        lib1.addBook("Book2", "Author2", 4, 2024, "Gen2");
        lib1.addTagToBook("Book2", "Novella");
        ArrayList<String> checkTags = new ArrayList<>();
        checkTags.add("Hardcover");
        ArrayList<String> books = lib1.searchByTags(checkTags);
        assertTrue(books.isEmpty());
    }

    @Test
    void searchByTagsOneExistTest() {
        lib1.addBook("Book1", "Author1", 5, 2023, "Gen1");
        lib1.addTagToBook("Book1", "Favourite");
        lib1.addTagToBook("Book1", "Hardcover");
        lib1.addBook("Book2", "Author2", 4, 2024, "Gen2");
        lib1.addTagToBook("Book2", "Novella");
        ArrayList<String> checkTags = new ArrayList<>();
        checkTags.add("Hardcover");
        ArrayList<String> books = lib1.searchByTags(checkTags);
        assertEquals(1, books.size());
        assertEquals("Book1", books.get(0));
    }

    @Test
    void searchByTagsMultipleBooksTest() {
        lib1.addBook("Book1", "Author1", 5, 2023, "Gen1");
        lib1.addTagToBook("Book1", "Favourite");
        lib1.addBook("Book2", "Author2", 4, 2024, "Gen2");
        lib1.addTagToBook("Book2", "Favourite");
        lib1.addTagToBook("Book2", "Novella");
        ArrayList<String> checkTags = new ArrayList<>();
        checkTags.add("Favourite");
        ArrayList<String> books = lib1.searchByTags(checkTags);
        assertEquals(2, books.size());
        assertEquals("Book1", books.get(0));
        assertEquals("Book2", books.get(1));
    }

    @Test
    void searchByTagsMultipleTagsTest() {
        lib1.addBook("BookA", "Author1", 5, 2023, "Gen1");
        lib1.addTagToBook("BookA", "Favourite");
        lib1.addTagToBook("BookA", "Novella");
        lib1.addBook("BookB", "Author2", 4, 2024, "Gen2");
        lib1.addTagToBook("BookB", "Favourite");
        lib1.addTagToBook("BookB", "Novella");
        ArrayList<String> checkTags = new ArrayList<>();
        checkTags.add("Novella");
        checkTags.add("Favourite");
        ArrayList<String> books = lib1.searchByTags(checkTags);
        assertEquals(2, books.size());
        assertEquals("BookA", books.get(0));
        assertEquals("BookB", books.get(1));
    }

    @Test
    void toJsonTest() {
        lib1.addBook("BookA", "Author1", 5, 2023, "Gen1");
        lib1.addBook("BookB", "Author2", 4, 2024, "Gen2");
        JSONObject libObject = lib1.toJson();
        JSONArray bookAr = libObject.getJSONArray("books");
        JSONObject b1 = (JSONObject) bookAr.get(0);
        JSONObject b2 = (JSONObject) bookAr.get(1);
        assertEquals(2, bookAr.length());
        assertEquals("BookA", b1.getString("title"));
        assertEquals("BookB", b2.getString("title"));
    }
}


