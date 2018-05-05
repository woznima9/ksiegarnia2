package pl.mwmwz;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class KsiegarniaMenu {


    public void showMenu() {
        int chose;

        menuContent();
        Scanner in = new Scanner(System.in);
        chose = in.nextInt();
        boolean wybieraj = true;

        while (wybieraj) {
            BooksData booksData = BooksData.getInstance();
            BooksFunctions booksFunctions = new BooksFunctions();
            switch (chose) {
                case 1:
                    System.out.println("Ksiegarnia email: ksiegarnia@kniga.pl");
                    break;
                case 2:
                    System.out.println("Załadowane książki");
                    booksFunctions.pokazlistaTytulow(booksData.getAllBooks());
                    break;
                case 3:
                    System.out.println("Wydawnictwa przed 2005 rokiem");
                    booksFunctions.pokazWydanePrzed2005(booksData.getAllBooks());
                    break;
                case 4:
                    System.out.println("Wydawnictwa przed 2003 rokiem");
                    pokazWydanePrzed2003(booksData.getAllBooks());
                    break;
                case 5:
                    System.out.println("Dwie ostatnie książki");
                    System.out.println(booksFunctions.zwracajDwieOstatnieKsiazki(booksData.getAllBooks()));
                    break;
                case 6:
                    System.out.println("Książki posortowane rosnąco");
                    System.out.println(booksFunctions.posortujRosnacoIsbn(booksData.getAllBooks()));
                    break;
                case 7:
                    System.out.println("wyjście z Menu");
                    return;
            }
            menuContent();
            chose = in.nextInt();
        }
    }


    public void pokazWydanePrzed2003(List<Book> allBooks) {
        List<Book> przefiltrowana = allBooks.stream().filter(book -> book
                .getYearPublicationBook() < 2003).collect(Collectors.toList());

        if (przefiltrowana.isEmpty()) {
            System.out.println("Nie znaleziono");
        } else {
            przefiltrowana.forEach(book -> System.out.println(book));
        }
    }


    private void menuContent() {
        System.out.println("\n\nWybierz z MENU\n");
        System.out.println("1. adres email");
        System.out.println("2. wyświetl tytuły załadowanych książek");
        System.out.println("3. Wyświetl książki wydane przed 2005 rokiem");
        System.out.println("4. Wyświetl książki wydane przed 2003 rokiem");
        System.out.println("5. Wyświetl dwie ostatnie książki");
        System.out.println("6. Posortuj rosnąco");

        System.out.println("7. Wyjście z programu");
    }
}
