package dev.thangngo.entities;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BookAuthorId implements Serializable {
    private int bookId;
    private int authorId;


    public BookAuthorId() {}

    public BookAuthorId(int bookId, int authorId) {
        this.bookId = bookId;
        this.authorId = authorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookAuthorId)) return false;
        BookAuthorId that = (BookAuthorId) o;
        return bookId == that.bookId && authorId == that.authorId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, authorId);
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
}
