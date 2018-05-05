package pl.mwmwz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class BooksFunctions {

    Book podajIsbn(List<Book> books, String isbn) {
        for (Book element : books) {
            if (element.getIndexBook().equals(isbn)) {
                return element;
            }
        }
        return null;
    }

    List<Book> posortujRosnacoIsbn(List<Book> books) {
        Collections.sort(books);
        return books;
    }

    List<Book> zwracajDwieOstatnieKsiazki(List<Book> books) {
        List<Book> books1 = new ArrayList<>();
        int size = books.size();
        for (int i = 0; i < 2; i++) {
            books1.add(i, books.get(size - 2 + i));
        }
        return books1;
    }

    List<Book> posortujMalejacoIsbn(List<Book> books) {
        Collections.sort(books);
        Collections.reverse(books);
        return books;
    }

    Book najwczesniejWydana(List<Book> books) {
        List<Book> posortowane = posortujRosnacoIsbn(books);
        return posortowane.get(0);
    }

    Book najpozniejWydana(List<Book> books) {
        List<Book> posortowane = posortujMalejacoIsbn(books);
        return posortowane.get(0);
    }

    int sumujLataWydania(List<Book> books) {
        return books.stream().mapToInt(book -> book.getYearPublicationBook()).sum();
    }

    int wydanePo2007(List<Book> books) {
        int wydane = 0;
        for (Book element : books) {
            if (element.getYearPublicationBook() > 2007) {
                wydane++;
            }
        }
        return wydane;
    }

    boolean czyWszystkieWydanePo2000(List<Book> books) {
        for (Book element : books) {
            if (element.getYearPublicationBook() < 2000) {
                return false;
            }
        }
        return true;
    }

    int pdajSredniRok(List<Book> books) {
        return sumujLataWydania(books) / books.size();
    }

    int po2009NaLitT(List<Book> books) {
        int ilosc = 0;
        for (Book element : books) {
            if (element.getTitleBook().startsWith("T") && element.getYearPublicationBook() > 2009) {
                ++ilosc;
            }
        }
        return ilosc;
    }

    void dodaj100LatdoDatyWydania(List<Book> books) {
        for (Book element : books) {
            element.setYearPublicationBook(element.getYearPublicationBook() + 100);
        }
    }


    ArrayList<String> tytulyKsiazekZRrokiemPodzielnymPrzez2(List<Book> books) {
        ArrayList<String> tytuly = new ArrayList<>();
        int i = 0;
        for (Book element : books) {
            if ((element.getYearPublicationBook() % 2) == 0) {
                tytuly.add(i++, element.getTitleBook());
            }
        }
        return tytuly;
    }

    List<Book> pokazWydanePrzed2005(List<Book> allBooks) {
        List<Book> wydanePrzed2005 = new ArrayList<>();
        boolean znaleziono=false;
        for (Book element : allBooks) {
            if (element.getYearPublicationBook() < 2005) {
                wydanePrzed2005.add(element);
                znaleziono = true;
            }
        }
        if (!znaleziono) {
            System.out.println("Nie znaleziono takiej pozycji");
        }
        return wydanePrzed2005;
    }

    List<Book> pokazWydanePrzed2003(List<Book> allBooks) {
        List<Book> przefiltrowana = allBooks.stream().filter(book -> book
                .getYearPublicationBook() < 2003).collect(Collectors.toList());

        if (przefiltrowana.isEmpty()) {
            System.out.println("Nie znaleziono");
        }
        return przefiltrowana;
    }


    List<Book> pokazListe(List<Book> allBooks) {
        List<Book> lista = new ArrayList<>();
        for (int i = 0; i < allBooks.size(); ++i) {
            lista.add(i, allBooks.get(i));
        }
        return lista;
    }
}
