package pl.mwmwz;

import java.util.List;

class DisplayPattern {
    private BooksPrintStrategy booksPrintStrategy;


    DisplayPattern(BooksPrintStrategy booksPrintStrategy) {
        this.booksPrintStrategy = booksPrintStrategy;
    }

    void setBooksPrintStrategy(BooksPrintStrategy booksPrintStrategy) {
        this.booksPrintStrategy = booksPrintStrategy;
    }


    void print(List<Book> allBooks) {
        booksPrintStrategy.print(allBooks);
    }


}