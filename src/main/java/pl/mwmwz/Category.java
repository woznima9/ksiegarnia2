package pl.mwmwz;

import lombok.Getter;
import lombok.Setter;

public class Category implements Comparable<Category> {

    @Getter
    @Setter
    int categoryID;
    @Getter
    @Setter
    String categoryName;
    @Getter
    @Setter
    int categoryShowPriorytet;


    public Category(int categoryID, String categoryName, int categoryShowPriorytet) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.categoryShowPriorytet = categoryShowPriorytet;
    }

    @Override
    public String toString() {
        return "{catID=" + categoryID +
                ", catName=" + categoryName +
                ", catPrior=" + categoryShowPriorytet +"}";
    }

    @Override
    public int compareTo(Category o) {
        return Integer.compare(this.categoryShowPriorytet, o.categoryShowPriorytet);
    }
}
