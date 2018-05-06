package pl.mwmwz;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

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

    @Getter
    @Setter
    private String coverType;

    @Getter
    @Setter
    private List<Author> authors;

    @Getter
    @Setter
    private Category category;



    public Book(String titleBook, String indexBook, int yearPublicationBook, String coverType, List<Author> authors, Category category) {
        this.titleBook = titleBook;
        this.indexBook = indexBook;
        this.yearPublicationBook = yearPublicationBook;
        this.coverType=coverType;
        this.authors=authors;
        this.category = category;

    }



    @Override
    public String toString() {
        return "\"" + titleBook + "\"" +
                ", index: " + indexBook +
                ", year: " + yearPublicationBook +
                ", cover: " + coverType +
                ", authors " + authors +
                ", category " + category ;
    }

    @Override
    public int compareTo(Book o) {

        return Integer.compare(this.yearPublicationBook, o.yearPublicationBook);
    }
}
