package pl.mwmwz;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
class BooksData {
    private static BooksData jedynyBooksData = null;

    List<Book> allBooks = new ArrayList<>();

    private BooksData() {
    }

    static BooksData getInstance() {
        if (jedynyBooksData == null) {
            jedynyBooksData = new BooksData();
        }
        return jedynyBooksData;
    }
}
