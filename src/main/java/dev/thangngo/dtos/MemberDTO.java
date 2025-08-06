package dev.thangngo.dtos;

import dev.thangngo.entities.Borrowing;

import java.util.Set;

public class MemberDTO {
    private int id;
    private String name;
    private String email;
    private String phone;
    private Set<Borrowing> borrowings;

    public MemberDTO() {

    }

    public MemberDTO(int id, String name, String email, String phone, Set<Borrowing> borrowings) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.borrowings = borrowings;
    }

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
    public Set<Borrowing> getBorrowings() {
        return borrowings;
    }
    public void setBorrowings(Set<Borrowing> borrowings) {
        this.borrowings = borrowings;
    }


}
