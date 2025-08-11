package dev.thangngo.dtos.responses.borrowing;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.thangngo.dtos.responses.book.BookResponse;
import dev.thangngo.dtos.responses.member.MemberResponse;

import java.time.LocalDate;

public class BorrowingResponse {
    private int id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate borrowDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dueDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate returnDate;

    private String status;
    private String version;
    private MemberResponse member;
    private BookResponse book;

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

    public MemberResponse getMember() {
        return member;
    }

    public void setMember(MemberResponse member) {
        this.member = member;
    }

    public BookResponse getBook() {
        return book;
    }

    public void setBook(BookResponse book) {
        this.book = book;
    }
}
