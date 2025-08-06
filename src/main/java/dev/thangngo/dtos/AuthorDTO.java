package dev.thangngo.dtos;

import java.util.Set;

public class AuthorDTO {
    private int id;
    private String name;
    private int birthYear;
    private Set<BookDTO> book;

    public AuthorDTO() {
    }

    public AuthorDTO(int id, String name, int birthYear, Set<BookDTO> book) {
        this.id = id;
        this.name = name;
        this.birthYear = birthYear;
        this.book = book;
    }

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

    public Set<BookDTO> getBook() {
        return book;
    }

    public void setBook(Set<BookDTO> book) {
        this.book = book;
    }
}
