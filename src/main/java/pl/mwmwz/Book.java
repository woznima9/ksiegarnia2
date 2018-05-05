package pl.mwmwz;

import lombok.Getter;
import lombok.Setter;

public class Book implements Comparable<Book> {

    @Getter
    @Setter
    private String titleBook;

    @Getter
    @Setter
    private String indexBook;

    @Getter
    @Setter
    private int yearPublicationBook;


    public Book(String titleBook, String indexBook, int yearPublicationBook) {
        this.titleBook = titleBook;
        this.indexBook = indexBook;
        this.yearPublicationBook = yearPublicationBook;
    }

    @Override
    public String toString() {
        return "\"" + titleBook + "\"" +
                ", index: " + indexBook +
                ", year: " + yearPublicationBook;
    }

    @Override
    public int compareTo(Book o) {
        return Integer.compare(this.yearPublicationBook, o.yearPublicationBook);
    }
}
