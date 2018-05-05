package pl.mwmwz;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


public class BooksFunctionsTest {
    private BooksFunctions booksFunctions = new BooksFunctions();

    private List<Book> books = new ArrayList<>();

    @Before  // TESTY na poniższych danych testowych
    public void init() {
        books.add(new Book("Clean Code", "0132350882", 2008));
        books.add(new Book("Effective Java", "0134685997", 2018));
        books.add(new Book("Test Driven Development", "0321146530", 2003));
        books.add(new Book("Patterns of Enterprise Application Architecture", "0321127420", 2002));
        books.add(new Book("Head First Design Patterns", "0596007124", 2004));
    }

//    @Before // Testy na danych rzeczywistych z importowanego pliku
//    public void init() {
//        books = createBooksFromFile();
//    }


    @Test // 1.	Znajdź książkę o podanym ISBN.
    public void znajdzKsiazkeOpodanymIsbnTest() {
        Book book = booksFunctions.podajIsbn(books, "0321146530");
        assertEquals("0321146530", book.getIndexBook());
    }

    @Test // 2.	Posortuj książki po roku wydania zaczynajac od wydanej najwcześniej.
    public void posortujKsiazkiOdNajmlodszejTest() {
        List<Book> sortedBooks = booksFunctions.posortujRosnacoIsbn(books);
        System.out.println(sortedBooks);
        assertEquals("0321127420", sortedBooks.get(0).getIndexBook());
        assertEquals("0134685997", sortedBooks.get(4).getIndexBook());
    }

    @Test // 3.	Zwróć dwie ostatnie książki.
    public void zwracajDwieOstatnieKsiazkiTest() {
        List<Book> dwieOstatnie = booksFunctions.zwracajDwieOstatnieKsiazki(books);
//        System.out.println("wydruk testowy");
//        System.out.println(dwieOstatnie.get(0));
//        System.out.println(dwieOstatnie.get(1));
//        System.out.println(dwieOstatnie.get(0).getIndexBook());
//        System.out.println(dwieOstatnie.get(1).getIndexBook());
        assertEquals("0321127420", dwieOstatnie.get(0).getIndexBook());
        assertEquals("0596007124", dwieOstatnie.get(1).getIndexBook());
    }

    @Test // 4.	Posortuj książki po roku wydania zaczynajac od wydanej najpóźniej.
    public void posortujKsiazkiOdNajstarszejTest() {
        List<Book> sortedBooks = booksFunctions.posortujMalejacoIsbn(books);
        //System.out.println(sortedBooks);
        assertEquals("0134685997", sortedBooks.get(0).getIndexBook());
        assertEquals("0321127420", sortedBooks.get(4).getIndexBook());
    }

    @Test // 5.	Zwróć najwcześniej wydana książkę.
    public void najwczesniejWydanaTest() {
        Book najwczesniejsza = booksFunctions.najwczesniejWydana(books);
        assertEquals(2002, najwczesniejsza.getYearPublicationBook());
    }

    @Test // 6.	Zwróć najpóźniej wydana książkę.
    public void najpozniejWydanaTest() {
        Book najpozniejsza = booksFunctions.najpozniejWydana(books);
        assertEquals(2018, najpozniejsza.getYearPublicationBook());
    }

    @Test // 7.	Zwróć sumę lat wydania wszystkich książek.
    public void sumujLataWydania() {
        int sumaWydania;
        sumaWydania = booksFunctions.sumujLataWydania(books);
        assertEquals(10035, sumaWydania);
    }

    @Test // 8.	Zwróć liczbę książek wydanych po 2007 roku.
    public void iloscWydanychPo2007Test() {
        int iloscWydanych = booksFunctions.wydanePo2007(books);
        assertEquals(2, iloscWydanych);
    }

    @Test // 9.	Zwróć informacje o tym czy wszystkie książki w naszym katalogu są wydane po 2000 roku.
    public void czyWszystkieWydanePo2000Test() {
        assertTrue(booksFunctions.czyWszystkieWydanePo2000(books));
    }

    @Test // 10.	Zwróć średni rok wydania książki w naszym katalogu.
    public void sredniRokWydaniaTest() {
        assertEquals(2007, booksFunctions.pdajSredniRok(books));
    }

    @Test // 11.	Zwróć informacje o tym czy jakakolwiek książka w naszym katalogu jest wydana przed 2000 rokiem.
    public void czyIstniejeKsiazkaWydanaPrzed2000Test() {
        assertTrue(booksFunctions.czyWszystkieWydanePo2000(books));
    }

    @Test // 12.	Zwróć wszystkie książki, których tytuł zaczyna się od litery “T” i były one wydane po 2009 roku
    public void tytulKsiazekNaLitereT() {
        int wydanePo2009NaLitereT = booksFunctions.po2009NaLitT(books);
        assertEquals(0, wydanePo2009NaLitereT);
    }

    @Test // 13.	Dodajmy wszystkim książkom 100 lat do daty wydania (tak, wiem ze to nie ma sensu)
    public void dodaj100LatdoDatyWydaniaTest() {
        booksFunctions.dodaj100LatdoDatyWydania(books);
        assertEquals(2108, books.get(0).getYearPublicationBook());
        assertEquals(2118, books.get(1).getYearPublicationBook());
        assertEquals(2103, books.get(2).getYearPublicationBook());
        assertEquals(2102, books.get(3).getYearPublicationBook());
        assertEquals(2104, books.get(4).getYearPublicationBook());
    }

    @Test // 14.	Zwróć tytuły wszystkich książek, których rok jest podzielny przez 2.
    public void tytulyKsiazekZRrokiemPodzielnymPrzez2Test() {
        ArrayList <String> tytulyKsiazek = booksFunctions.tytulyKsiazekZRrokiemPodzielnymPrzez2(books);
      //  System.out.println(tytulyKsiazek);
        String wynik = tytulyKsiazek.toString();
        assertEquals("[Clean Code, Effective Java, Patterns of Enterprise Application Architecture, Head First Design Patterns]", wynik);
    }
}


/*

ZAKRES TESTÓW:
1.	Znajdź książkę o podanym ISBN.
2.	Posortuj książki po roku wydania zaczynajac od wydanej najwcześniej.
3.	Zwróć dwie ostatnie książki.
4.	Posortuj książki po roku wydania zaczynajac od wydanej najpóźniej.
5.	Zwróć najwcześniej wydana książkę.
6.	Zwróć najpóźniej wydana książkę.
7.	Zwróć sumę lat wydania wszystkich książek.
8.	Zwróć liczbę książek wydanych po 2007 roku.
9.	Zwróć informacje o tym czy wszystkie książki w naszym katalogu są wydane po 2000 roku.
10.	Zwróć średni rok wydania książki w naszym katalogu.
11.	Zwróć informacje o tym czy jakakolwiek książka w naszym katalogu jest wydana przed 2000 rokiem.
12.	Zwróć wszystkie książki, których tytuł zaczyna się od litery “T” i były one wydane po 2009 roku
13.	Dodajmy wszystkim książkom 100 lat do daty wydania (tak, wiem ze to nie ma sensu)
14.	Zwróć tytuły wszystkich książek, których rok jest podzielny przez 2.

 */