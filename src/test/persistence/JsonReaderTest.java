package persistence;

import model.Book;
import model.Library;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderTest extends JsonTest{

    @Test
    void readerFileNotExistTest() {
        JsonReader reader = new JsonReader("./data/fakeFile.json");
        try {
            Library l = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void readerEmptyLibraryTest() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyLibrary.json");
        try {
            Library l = reader.read();
            assertEquals(0,l.getBooks().size());
        } catch (IOException e) {
            fail("Couldn't read file");
        }
    }

    @Test
    void readerGeneralLibraryTest() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralLibrary.json");
        try {
            Library l = reader.read();
            ArrayList<Book> books = l.getBooks();
            assertEquals(2, books.size());
            ArrayList<String> book1Tags = new ArrayList<>();
            book1Tags.add("Favourite");
            book1Tags.add("PJO");
            ArrayList<String> book2Tags = new ArrayList<>();
            checkBook(books.get(0), "Percy Jackson: The Lighting Thief", "Rick Riordan", "YA", 5,
                    2017, book1Tags);
            checkBook(books.get(1), "Harry Potter and the Philosopher's Stone", "J K Rowling", "YA", 4,
                    2019, book2Tags);
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

}
