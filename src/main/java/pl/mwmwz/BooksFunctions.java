package pl.mwmwz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BooksFunctions {

    public Book podajIsbn(List<Book> books, String isbn) {
        for (Book element : books) {
            if (element.getIndexBook().equals(isbn)) {
                return element;
            }
        }
        return null;
    }

    public List<Book> posortujRosnacoIsbn(List<Book> books) {
        Collections.sort(books);
        return books;
    }

    public List<Book> zwracajDwieOstatnieKsiazki(List<Book> books) {
        List<Book> books1 = new ArrayList<>();
        int size = books.size();
        for (int i = 0; i < 2; i++) {
            books1.add(i, books.get(size - 2 + i));
        }
        return books1;
    }

    public List<Book> posortujMalejacoIsbn(List<Book> books) {
        Collections.sort(books);
        Collections.reverse(books);
        return books;
    }

    public Book najwczesniejWydana(List<Book> books) {
        List<Book> posortowane = posortujRosnacoIsbn(books);
        return posortowane.get(0);
    }

    public Book najpozniejWydana(List<Book> books) {
        List<Book> posortowane = posortujMalejacoIsbn(books);
        return posortowane.get(0);
    }

    public int sumujLataWydania(List<Book> books) {
        return books.stream().mapToInt(book -> book.getYearPublicationBook()).sum();
    }
//        int suma = 0;
//        for (Book element : books) {
//            suma += element.getYearPublicationBook();
//
//        }
//        return suma;
//books.stream().mapToInt()


    public int wydanePo2007(List<Book> books) {
        int wydane = 0;
        for (Book element : books) {
            if (element.getYearPublicationBook() > 2007) {
                wydane++;
            }
        }
        return wydane;
    }

    public boolean czyWszystkieWydanePo2000(List<Book> books) {
        for (Book element : books) {
            if (element.getYearPublicationBook() < 2000) {
                return false;
            }
        }
        return true;
    }

    public int pdajSredniRok(List<Book> books) {
        return sumujLataWydania(books) / books.size();
    }

    public int po2009NaLitT(List<Book> books) {
        int ilosc = 0;
        for (Book element : books) {
            if (element.getTitleBook().startsWith("T") && element.getYearPublicationBook() > 2009) {
                ++ilosc;
            }
        }
        return ilosc;
    }

    public void dodaj100LatdoDatyWydania(List<Book> books) {
        for (Book element : books) {
            element.setYearPublicationBook(element.getYearPublicationBook() + 100);
            /*System.out.println(element.getYearPublicationBook());*/
        }
    }


    public ArrayList<String> tytulyKsiazekZRrokiemPodzielnymPrzez2(List<Book> books) {
        ArrayList<String> tytuly = new ArrayList<>();
        int i = 0;
        for (Book element : books) {
            if ((element.getYearPublicationBook() % 2) == 0) {
                // System.out.println(element.getYearPublicationBook());
                tytuly.add(i++, element.getTitleBook());
            }
        }
        // System.out.println(tytuly);
        return tytuly;
    }

    public void pokazWydanePrzed2005(List<Book> allBooks) {
        boolean znaleziono = false;
        for (Book element : allBooks) {
            if (element.getYearPublicationBook() < 2005) {
                System.out.println(element);
                znaleziono = true;
            }
        }
        if (znaleziono == false) {
            System.out.println("Nie znaleziono takiej pozycji");
        }
    }

    public void pokazlistaTytulow(List<Book> allBooks) {
        for (int i = 0; i < allBooks.size(); ++i) {
            System.out.println("Książka numer: " + i + " - " + allBooks.get(i));
            //     System.out.print(allBooks.get(i).getIndexBook() + "\t\t  ");
            //     System.out.print(allBooks.get(i).getYearPublicationBook() + "\n");
        }
    }
}


