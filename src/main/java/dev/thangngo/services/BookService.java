package dev.thangngo.services;

import dev.thangngo.dtos.BookDTO;

import java.util.List;

public interface BookService {
    BookDTO getBookById(int id);
    List<BookDTO> getAllBooks();
    void createOrUpdate(BookDTO bookDTO);
    void removeBook(int id);
}
