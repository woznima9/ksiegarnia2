package pl.mwmwz;

import lombok.Getter;
import lombok.Setter;

public class Author implements Comparable<Author> {
    @Setter
    @Getter
    private int idAuthor;

    @Setter
    @Getter
    private String name;

    @Setter
    @Getter
    private int age;



    public Author(int idAuthor, String name, int age) {
        this.idAuthor = idAuthor;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return " "+name;
    }

    @Override
    public int compareTo(Author o) {
        return Integer.compare(this.age, o.age);
    }
}
