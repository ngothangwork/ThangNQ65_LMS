package dev.thangngo.entities;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "members")
public class Member {

    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "member_name")
    private String name;

    @Column(name = "member_email")
    private String email;

    @Column(name = "member_phone")
    private String phone;

    @Column(name = "member_version")
    private String version;

    @OneToMany(mappedBy = "member")
    private Set<Borrowing> borrowings;

    public Member() {}

    public Member(int id, String name, String email, String phone, String version, Set<Borrowing> borrowings) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.version = version;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Set<Borrowing> getBorrowings() {
        return borrowings;
    }

    public void setBorrowings(Set<Borrowing> borrowings) {
        this.borrowings = borrowings;
    }
}
