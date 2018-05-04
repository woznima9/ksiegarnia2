package pl.mwmwz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class KsiegarniaApp {
    static String BOOKS_FILE_NAME = "books.csv";

    public static void main(String[] args) {
        System.out.println("__K S I E G A R N I A__\n");

        List<Book> books = createBooksFromFile();
        BooksData booksData = BooksData.getInstance();
        booksData.setAllBooks(books);
        System.out.println(books);
        System.out.println(books.size());

        KsiegarniaMenu ksiegarniaMenu = new KsiegarniaMenu();
        ksiegarniaMenu.showMenu();
        System.out.println("Osiągnięto koniec programu");
    }


     static List<Book> createBooksFromFile() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(BOOKS_FILE_NAME)));
        List<Book> books = new ArrayList<>();
        try {
            String textLine = bufferedReader.readLine();
            while (textLine != null) {
                System.out.println(textLine);
                String[] attributes = textLine.split(";");
                Book book = createBook(attributes);
                books.add(book);
                textLine = bufferedReader.readLine();
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return books;
    }


    private static Book createBook(String[] attributes) {
        return new Book(attributes[0], (attributes[1]), Integer.parseInt(attributes[2]));

    }


}


