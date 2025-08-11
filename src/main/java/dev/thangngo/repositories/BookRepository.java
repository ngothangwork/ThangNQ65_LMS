package dev.thangngo.repositories;

import dev.thangngo.entities.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    Optional<Book> findById(int id);
    List<Book> findAll();
    void save(Book book);
    void deleteById(int id);
    boolean existsById(int id);
}

