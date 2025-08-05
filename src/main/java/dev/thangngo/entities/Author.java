package dev.thangngo.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @Column(name = "author_id")
    private int id;

    @Column(name = "author_name")
    private String name;

    @Column(name = "author_birth_year")
    private int birthYear;

    @OneToMany(mappedBy = "author")
    private Set<BookAuthor> bookAuthors;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public Set<BookAuthor> getBookAuthors() {
        return bookAuthors;
    }

    public void setBookAuthors(Set<BookAuthor> bookAuthors) {
        this.bookAuthors = bookAuthors;
    }
}
