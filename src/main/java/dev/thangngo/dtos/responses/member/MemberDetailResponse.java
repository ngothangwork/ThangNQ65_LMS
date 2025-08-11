package dev.thangngo.dtos.responses.member;

import dev.thangngo.dtos.responses.borrowing.BorrowingResponse;

import java.util.List;

public class MemberDetailResponse {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String version;
    private List<BorrowingResponse> borrowings;


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<BorrowingResponse> getBorrowings() {
        return borrowings;
    }

    public void setBorrowings(List<BorrowingResponse> borrowings) {
        this.borrowings = borrowings;
    }
}
