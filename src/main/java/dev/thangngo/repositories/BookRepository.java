package dev.thangngo.repositories;

import dev.thangngo.entities.Book;

import java.util.List;

public interface BookRepository {
    Book findById(int id);
    List<Book> findAll();
    void save(Book book);
    void deleteById(int id);
}
