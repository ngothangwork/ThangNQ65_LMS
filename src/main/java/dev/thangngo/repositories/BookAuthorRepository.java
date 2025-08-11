package dev.thangngo.repositories;

import dev.thangngo.entities.BookAuthor;
import dev.thangngo.entities.BookAuthorId;

import java.util.List;

public interface BookAuthorRepository {
    BookAuthor findById(BookAuthorId id);
    List<BookAuthor> findAll();
    void save(BookAuthor bookAuthor);
    void deleteById(BookAuthorId id);
}
