package dev.thangngo.repositories;

import dev.thangngo.entities.Author;

import java.util.List;

public interface AuthorRepository {
    Author findById(int id);
    Author findByAuthorName(String name);
    List<Author> findAll();
    void save(Author author);
    void deleteById(int id);
}
