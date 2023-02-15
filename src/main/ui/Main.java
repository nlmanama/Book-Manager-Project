package ui;

import model.Library;
import java.util.Scanner;

public class Main {
    private static Library library;

    public static void main(String[] args) {
        library = new Library();
        Scanner scan = new Scanner(System.in);

        boolean stop = false;
        while (!stop) {
            System.out.println("Please enter: ");
            System.out.println("1 - to add a book");
            System.out.println("2 - to find a book by author name");
            System.out.println("E - to end the session");

            String input = scan.nextLine();
            switch (input) {
                case "1":
                    addBook();
                    break;
                case "2":
                    searchAuthor();
                    break;
                case "E":
                    System.out.println("Thank you!");
                    stop = true;
                    break;
            }
        }
    }

    private static void addBook() {
        // stub
    }

    private static void searchAuthor() {
        // stub
    }

}
