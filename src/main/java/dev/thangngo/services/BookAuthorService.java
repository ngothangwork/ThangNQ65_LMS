package dev.thangngo.services;

import dev.thangngo.dtos.requests.bookauthor.BookAuthorRequest;
import dev.thangngo.dtos.responses.bookauthor.BookAuthorResponse;

import java.util.List;

public interface BookAuthorService {
    BookAuthorResponse createBookAuthor(BookAuthorRequest request);
    void deleteBookAuthor(int bookId, int authorId);
    List<BookAuthorResponse> getAllBookAuthors();
}
