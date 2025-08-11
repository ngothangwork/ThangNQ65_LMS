package dev.thangngo.repositories;

import dev.thangngo.entities.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository {
    Optional<Author> findById(int id);
    List<Author> findByAuthorName(String name);
    List<Author> findAll();
    void save(Author author);
    void deleteById(int id);
    boolean existsById(int id);
}
