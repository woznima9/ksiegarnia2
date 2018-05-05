package pl.mwmwz;

import java.util.List;

public class StrategyRTI implements BooksPrintStrategy {
    @Override
    public void print(List<Book> allBooks) {
        for (Book element : allBooks) {
            System.out.println(element.getYearPublicationBook() + " " + element.getTitleBook() + " " + element.getIndexBook());
        }
    }
}
