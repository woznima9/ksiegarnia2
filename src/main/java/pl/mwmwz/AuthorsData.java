package pl.mwmwz;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
class AuthorsData {
    private static AuthorsData jedynyAuthorsData = null;
    List<Author> allAuthors = new ArrayList<>();

    private AuthorsData() {
    }

    static AuthorsData getInstance() {
        if (jedynyAuthorsData==null){
            jedynyAuthorsData=new AuthorsData();
        }
        return jedynyAuthorsData;
    }


}
