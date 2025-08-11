package dev.thangngo.dtos.responses.book;

import dev.thangngo.dtos.responses.bookauthor.BookAuthorResponse;

import java.time.LocalDate;
import java.util.Set;

public class BookDetailResponse {
    private int id;
    private String title;
    private String category;
    private boolean available;
    private LocalDate createdDate;
    private String version;
    private Set<BookAuthorResponse> authors;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Set<BookAuthorResponse> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<BookAuthorResponse> authors) {
        this.authors = authors;
    }
}
