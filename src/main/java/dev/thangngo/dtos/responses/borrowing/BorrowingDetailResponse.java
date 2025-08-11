package dev.thangngo.dtos.responses.borrowing;

import dev.thangngo.dtos.responses.book.BookDetailResponse;
import dev.thangngo.dtos.responses.member.MemberDetailResponse;

import java.time.LocalDate;

public class BorrowingDetailResponse {
    private int id;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private String status;
    private String version;
    private MemberDetailResponse member;
    private BookDetailResponse book;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public MemberDetailResponse getMember() {
        return member;
    }

    public void setMember(MemberDetailResponse member) {
        this.member = member;
    }

    public BookDetailResponse getBook() {
        return book;
    }

    public void setBook(BookDetailResponse book) {
        this.book = book;
    }
}
