package pl.mwmwz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class KsiegarniaApp {
    private static String BOOKS_FILE_NAME = "books.csv";
    private static String AUTHOR_FILE_NAME = "authors.csv";
    private static String CATEGORIES_FILE_NAME = "categories.csv";

    public static void main(String[] args) {
        System.out.println("__K S I E G A R N I A__\n");

        CategoriesData categoriesData = CategoriesData.getInstance();
        List<Category> categories = createCategoriesFromFile();
        System.out.println(categories);

        categoriesData.setAllCategories(categories);
        System.out.println(categoriesData);

        AuthorsData authorsData = AuthorsData.getInstance();
        List<Author> authors = createAutorFromFile();
        authorsData.setAllAuthors(authors);

        List<Book> books = createBooksFromFile();
        BooksData booksData = BooksData.getInstance();
        booksData.setAllBooks(books);


        KsiegarniaMenu ksiegarniaMenu = new KsiegarniaMenu();
        ksiegarniaMenu.showMenu();

        System.out.println("Koniec programu");
    }

    private static List<Category> createCategoriesFromFile() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader
                (ClassLoader.getSystemResourceAsStream(CATEGORIES_FILE_NAME)));

        List<Category> categories = new ArrayList<>();
        try {
            String textLine = bufferedReader.readLine();
            while (textLine != null) {
                String[] attributes = textLine.split(";");
                Category category = createCategory(attributes);
                categories.add(category);
                textLine = bufferedReader.readLine();
            }
        } catch (IOException e1){
                e1.printStackTrace();
            }
            return categories;

    }


    private static List<Book> createBooksFromFile() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader
                (ClassLoader.getSystemResourceAsStream(BOOKS_FILE_NAME)));
        List<Book> books = new ArrayList<>();
        List<Author> authorBookList = new ArrayList<>();
        try {
            String textLine = bufferedReader.readLine();
            while (textLine != null) {
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
        ArrayList<Author> bookAuthors = new ArrayList<>();
        String numerkiAutorowString = attributes[4];
        String[] numerkiAutorowTablica = numerkiAutorowString.split(",");
        int[] numerkiAutorowIntTablica = new int[numerkiAutorowString.length()];
        for (int i = 0; i < numerkiAutorowTablica.length; i++) {
            numerkiAutorowIntTablica[i] = Integer.parseInt(numerkiAutorowTablica[i]);
            Author author = getAuthorById(numerkiAutorowIntTablica[i]);
            bookAuthors.add(i, author);
        }
        // wyciąganie kategorii do importu book


        List<Category> categoryList = CategoriesData.getInstance().getAllCategories();

        Category pomocniczaZmiennaDoKategorii = null;
        for (Category element:categoryList ){
            if (Integer.parseInt(attributes[5])==element.getCategoryID()) {
                pomocniczaZmiennaDoKategorii=element;
            }

        }


        return new Book(attributes[0], (attributes[1]), Integer.parseInt(attributes[2]), (attributes[3]),
                bookAuthors, pomocniczaZmiennaDoKategorii);

    }

    private static Author getAuthorById(int id) {
        List<Author> allAuthors = AuthorsData.getInstance().getAllAuthors();
        for (Author element : allAuthors) {
            if (element.getIdAuthor() == id) {
                return element;
            }
        }

        return null;
    }

    private static List<Author> createAutorFromFile() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader
                (ClassLoader.getSystemResourceAsStream(AUTHOR_FILE_NAME)));
        List<Author> authors = new ArrayList<>();
        try {
            String textLine = bufferedReader.readLine();
            while (textLine != null) {
                String[] attributes = textLine.split(";");
                Author author = createAutor(attributes);
                authors.add(author);
                textLine = bufferedReader.readLine();
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return authors;
    }

    private static Author createAutor(String[] attributes) {
        return new Author(Integer.parseInt(attributes[0]), attributes[1], Integer.parseInt(attributes[2]));
    }
    private static Category createCategory(String[] attributes) {

        return new Category(Integer.parseInt(attributes[0]),attributes[1] , Integer.parseInt(attributes[2]));
    }
}


