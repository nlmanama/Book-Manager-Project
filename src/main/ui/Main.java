package ui;

import model.Library;

import java.io.FileNotFoundException;


public class Main {

    public static void main(String[] args) {
        try {
            new LibraryApp();
        } catch (FileNotFoundException e) {
            System.out.println("Error, file not found.");
        }
    }
}
