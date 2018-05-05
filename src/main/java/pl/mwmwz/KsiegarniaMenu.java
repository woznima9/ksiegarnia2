package pl.mwmwz;

import java.util.Scanner;

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
                    displayPattern.print(booksData.getAllBooks());
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
                    displayPattern.print(booksFunctions.pokazWydanePrzed2005(booksData.getAllBooks()));
                    break;
                case 6:
                    System.out.println("Wydawnictwa przed 2003 rokiem");
                    displayPattern.print(booksFunctions.pokazWydanePrzed2003(booksData.getAllBooks()));
                    break;
                case 7:
                    System.out.println("Dwie ostatnie książki");
                    displayPattern.print(booksFunctions.zwracajDwieOstatnieKsiazki(booksData.getAllBooks()));
                    break;
                case 8:
                    System.out.println("Książki posortowane rosnąco");
                    displayPattern.print(booksFunctions.posortujRosnacoIsbn(booksData.getAllBooks()));
                    break;
               case 9:
                    System.out.println("Książki posortowane rosnąco");
                    displayPattern.print(booksFunctions.posortujMalejacoIsbn(booksData.getAllBooks()));
                    break;

                case 10:
                    System.out.println("Zmiana strategii na RTI");
                    displayPattern.setBooksPrintStrategy(new StrategyRTI());
                    break;
                case 11:
                    System.out.println("wyjście z Menu");
                    wybieraj=false;
                    break;
                default:
                    System.out.println("wprowadzono nieistniejącą opcję");

            }
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
        System.out.println("9. Posortuj malejąco");

        System.out.println("10. powrót do strategii default RTI");
        System.out.println("11. Wyjście z programu");
    }
}
