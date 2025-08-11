package dev.thangngo.dtos.responses.book;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.thangngo.dtos.responses.author.AuthorResponse;

import java.time.LocalDate;
import java.util.List;

public class BookResponse {
    private int id;
    private String title;
    private String category;
    private boolean available;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate createDate;

    private String version;
    private List<AuthorResponse> authors;

    public List<AuthorResponse> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorResponse> authors) {
        this.authors = authors;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

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
}
