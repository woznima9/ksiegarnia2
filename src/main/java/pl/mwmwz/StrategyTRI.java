package pl.mwmwz;

import java.util.List;

public class StrategyTRI implements BooksPrintStrategy {
    @Override
    public void print(List<Book> allBooks) {
        for (Book element : allBooks) {
            System.out.println(element.getTitleBook() + " " + element.getYearPublicationBook() + " " + element.getIndexBook());
        }
    }
}
