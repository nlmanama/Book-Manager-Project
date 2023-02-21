package model;

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
}
