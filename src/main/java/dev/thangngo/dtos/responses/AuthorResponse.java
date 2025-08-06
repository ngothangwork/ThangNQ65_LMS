package dev.thangngo.dtos.responses;

import java.util.Set;

public class AuthorResponse {
    private int id;
    private String name;
    private int birthYear;
    private Set<BookResponse> books;

    public AuthorResponse() {}

    public AuthorResponse(int id, String name, int birthYear, Set<BookResponse> books) {
        this.id = id;
        this.name = name;
        this.birthYear = birthYear;
        this.books = books;
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

    public Set<BookResponse> getBooks() {
        return books;
    }

    public void setBooks(Set<BookResponse> books) {
        this.books = books;
    }
}
