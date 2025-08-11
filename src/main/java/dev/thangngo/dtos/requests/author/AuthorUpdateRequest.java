package dev.thangngo.dtos.requests.author;

import jakarta.validation.constraints.NotNull;

public class AuthorUpdateRequest {
    @NotNull
    private String name;

    @NotNull
    private int birthYear;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }
}
