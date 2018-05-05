package pl.mwmwz;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class KsiegarniaMenu {


    void showMenu() {
        int chose;

        Scanner in = new Scanner(System.in);
        boolean wybieraj = true;

        BooksData booksData = BooksData.getInstance();
        BooksFunctions booksFunctions = new BooksFunctions();
        DisplayPattern displayPattern = new DisplayPattern(new StrategyRTI());
        while (wybieraj) {
            menuContent();
            chose = in.nextInt();
            switch (chose) {
                case 1:
                    System.out.println("Ksiegarnia email: ksiegarnia@kniga.pl");
                    break;
                case 2:
                    System.out.println("Załadowane książki:");
                    displayPattern.print(booksData.allBooks);
                    break;
                case 3:
                    System.out.println("Zmiana strategii na TRI");
                    displayPattern.setBooksPrintStrategy(new StrategyTRI());
                    break;
                case 4:
                    System.out.println("Zmiana strategii na ITR");
                    displayPattern.setBooksPrintStrategy(new StrategyITR());
                    break;

                case 5:
                    System.out.println("Wydawnictwa przed 2005 rokiem");
                    booksFunctions.pokazWydanePrzed2005(booksData.getAllBooks());
                    break;
                case 6:
                    System.out.println("Wydawnictwa przed 2003 rokiem");
                    pokazWydanePrzed2003(booksData.getAllBooks());
                    break;
                case 7:
                    System.out.println("Dwie ostatnie książki");
                    System.out.println(booksFunctions.zwracajDwieOstatnieKsiazki(booksData.getAllBooks()));
                    break;
                case 8:
                    System.out.println("Książki posortowane rosnąco");
                    System.out.println(booksFunctions.posortujRosnacoIsbn(booksData.getAllBooks()));
                    break;

                case 9:
                    System.out.println("Zmiana strategii na RTI");
                    displayPattern.setBooksPrintStrategy(new StrategyRTI());
                    break;
                case 10:
                    System.out.println("wyjście z Menu");
                    wybieraj=false;
                    break;
                default:
                    System.out.println("wprowadzono nieistniejącą opcję");

            }
        }
    }


    private void pokazWydanePrzed2003(List<Book> allBooks) {
        List<Book> przefiltrowana = allBooks.stream().filter(book -> book
                .getYearPublicationBook() < 2003).collect(Collectors.toList());

        if (przefiltrowana.isEmpty()) {
            System.out.println("Nie znaleziono");
        } else {
            przefiltrowana.forEach(book -> System.out.println(book));
        }
    }


    private void menuContent() {
        System.out.println("\nWybierz z MENU\n");
        System.out.println("1. adres email");
        System.out.println("2. wyświetl załadowane książki");
        System.out.println("3. Zmiana strategii wyświetlania na TRI");
        System.out.println("4. Zmiana strategii wyświetlania na ITR");
        System.out.println("5. Wyświetl książki przed 2005");

        System.out.println("6. Wyświetl książki wydane przed 2003 rokiem");
        System.out.println("7. Wyświetl dwie ostatnie książki");
        System.out.println("8. Posortuj rosnąco");

        System.out.println("9. powrót do strategii default RTI");
        System.out.println("10. Wyjście z programu");
    }
}
