package dev.thangngo.dtos.requests.borrowing;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class BorrowingCreateRequest {
    @NotNull
    private LocalDate borrowDate;

    @NotNull
    private LocalDate dueDate;

    private LocalDate returnDate;

    @NotNull
    private String status;

    @NotNull
    private String version;

    @NotNull
    private Integer memberId;

    @NotNull
    private Integer bookId;


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

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }
}
