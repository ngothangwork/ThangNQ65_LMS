package dev.thangngo.dtos.responses.author;

import dev.thangngo.dtos.responses.bookauthor.BookAuthorResponse;

import java.util.Set;

public class AuthorDetailResponse {
    private int id;
    private String name;
    private int birthYear;
    private Set<BookAuthorResponse> books;

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

    public Set<BookAuthorResponse> getBooks() {
        return books;
    }

    public void setBooks(Set<BookAuthorResponse> books) {
        this.books = books;
    }
}
