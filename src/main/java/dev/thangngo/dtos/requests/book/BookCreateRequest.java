package dev.thangngo.dtos.requests.book;

import dev.thangngo.dtos.requests.author.AuthorCreateRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public class BookCreateRequest {
    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Category is required")
    private String category;

    @NotNull(message = "Availability is required")
    private Boolean available;

    @NotNull(message = "Created date is required")
    private LocalDate createdDate;

    @NotBlank(message = "Version is required")
    private String version;

    @NotEmpty(message = "Authors list is required")
    private List<AuthorCreateRequest> authors;

    public List<AuthorCreateRequest> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorCreateRequest> authors) {
        this.authors = authors;
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
}
