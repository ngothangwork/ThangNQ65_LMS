package dev.thangngo.service;

import dev.thangngo.entities.Book;

import java.util.List;

public interface BookService {
    Book getBookById(int id);
    List<Book> getAllBooks();
    void createOrUpdate(Book book);
    void removeBook(int id);
}

