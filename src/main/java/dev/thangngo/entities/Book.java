package dev.thangngo.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", nullable = false, unique = true)
    private int id;

    @Column(name = "book_title", nullable = false)
    private String title;

    @Column(name = "book_category")
    private String category;

    @Column(name = "book_availability")
    private boolean available;

    @Column(name = "book_created_date")
    private LocalDate createdDate;

    @Column(name = "book_version")
    private String version;

    @OneToMany(mappedBy = "book")
    private Set<BookAuthor> bookAuthors;

    @OneToMany(mappedBy = "book")
    private Set<Borrowing> borrowings;


    public Book() {

    }

    public Book(String title, String category, boolean available, LocalDate createdDate, String version) {
        this.title = title;
        this.category = category;
        this.available = available;
        this.createdDate = createdDate;
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

    public Set<BookAuthor> getBookAuthors() {
        return bookAuthors;
    }

    public void setBookAuthors(Set<BookAuthor> bookAuthors) {
        this.bookAuthors = bookAuthors;
    }

    public Set<Borrowing> getBorrowings() {
        return borrowings;
    }

    public void setBorrowings(Set<Borrowing> borrowings) {
        this.borrowings = borrowings;
    }
}
