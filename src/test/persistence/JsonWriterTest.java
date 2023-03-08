package persistence;

import model.Book;
import model.Library;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest extends JsonTest {

    @Test
    void writerInvalidFileTest() {
        try {
            Library l = new Library();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void writerEmptyLibraryTest() {
        try {
            Library l = new Library();
            JsonWriter writer = new JsonWriter ("./data/testWriterEmptyLibrary.json");
            writer.open();
            writer.write(l);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyLibrary.json");
            Library readLibrary = reader.read();
            assertEquals(0, readLibrary.getBooks().size());
        } catch (IOException e) {
            fail("Unexpected IOException");
        }
    }

    @Test
    void writerGeneralLibraryTest() {
        try {
            Library l = new Library();
            l.addBook("PJO", "RR", 5, 2012, "YA");
            l.addTagToBook("PJO", "Favourite");
            l.addBook("HP", "JKR", 4, 2014, "YA");

            JsonWriter writer = new JsonWriter("./data/testWriterGeneralLibrary.json");
            writer.open();
            writer.write(l);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralLibrary.json");
            Library readLibrary = reader.read();
            ArrayList<Book> books = readLibrary.getBooks();
            assertEquals(2, books.size());
            ArrayList<String> tags1 = new ArrayList<>();
            tags1.add("Favourite");
            ArrayList<String> tags2 = new ArrayList<>();
            checkBook(books.get(0), "PJO", "RR", "YA", 5, 2012, tags1);
            checkBook(books.get(1), "HP", "JKR", "YA", 4, 2014, tags2);

        } catch (IOException e) {
            fail("Unexpected IOException");
        }
    }
}
