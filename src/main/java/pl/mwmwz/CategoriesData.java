package pl.mwmwz;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
class CategoriesData {
    private static CategoriesData jedynyCategoriesData = null;
    List<Category> allCategories = new ArrayList<>();

    private CategoriesData() {
    }


    static CategoriesData getInstance() {
        if (jedynyCategoriesData == null) {
            jedynyCategoriesData = new CategoriesData();

        }
        return jedynyCategoriesData;
    }
}
