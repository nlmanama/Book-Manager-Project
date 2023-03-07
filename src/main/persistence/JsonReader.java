package persistence;

import model.Book;
import model.Library;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Represents a reader that reads library from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs a reader to read file from source
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads library from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Library read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseLibrary(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parse library from JSON object and returns it
    private Library parseLibrary(JSONObject jsonObject) {
        Library l = new Library();
        addBooks(l, jsonObject);
        return l;
    }

    // MODIFIES: l
    // EFFECTS: parses books from JSON object and adds them to the library
    private void addBooks(Library l, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("books");
        for (Object json : jsonArray) {
            JSONObject nextBook = (JSONObject) json;
            addBook(l, nextBook);
        }
    }


    // MODIFIES: l
    // EFFECTS: parse book from JSON object and adds it to the library
    private void addBook(Library l, JSONObject jsonObject) {
        String title = jsonObject.getString("title");
        String author = jsonObject.getString("author");
        int rating = jsonObject.getInt("rating");
        int yearRead = jsonObject.getInt("yearRead");
        String genre = jsonObject.getString("genre");
        Book b = new Book(title, author, rating, yearRead, genre);

        JSONArray tags = jsonObject.getJSONArray("tags");
        for (int i = 0; i < tags.length(); i++) {
            b.addTag(tags.getString(i));
        }

        l.addBook(b);
    }

}
