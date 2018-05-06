package pl.mwmwz;

import java.util.List;

public class StrategyITR implements BooksPrintStrategy {
    @Override
    public void print(List<Book> allBooks) {
        for (Book element : allBooks) {
            System.out.println(element.getIndexBook() + " " + element.getTitleBook() + " " +
                    element.getYearPublicationBook()+" "+element.getAuthors()+" " + element.getCategory());
        }
    }
}
