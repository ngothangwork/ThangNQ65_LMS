package dev.thangngo.services;

import dev.thangngo.dtos.requests.book.BookCreateRequest;
import dev.thangngo.dtos.requests.book.BookUpdateRequest;
import dev.thangngo.dtos.responses.book.BookResponse;
import dev.thangngo.dtos.responses.book.BookDetailResponse;

import java.util.List;

public interface BookService {
    BookResponse createBook(BookCreateRequest request);
    BookResponse updateBook(int id, BookUpdateRequest request);
    void deleteBook(int id);
    BookDetailResponse getBookById(int id);
    List<BookResponse> getAllBooks();
}
