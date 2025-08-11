// BookAuthorServiceImpl.java
package dev.thangngo.services.impl;

import dev.thangngo.dtos.requests.bookauthor.BookAuthorRequest;
import dev.thangngo.dtos.responses.bookauthor.BookAuthorResponse;
import dev.thangngo.entities.BookAuthor;
import dev.thangngo.entities.BookAuthorId;
import dev.thangngo.mappers.BookAuthorMapper;
import dev.thangngo.repositories.BookAuthorRepository;
import dev.thangngo.services.BookAuthorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookAuthorServiceImpl implements BookAuthorService {

    private final BookAuthorRepository bookAuthorRepository;
    private final BookAuthorMapper bookAuthorMapper;

    public BookAuthorServiceImpl(BookAuthorRepository bookAuthorRepository, BookAuthorMapper bookAuthorMapper) {
        this.bookAuthorRepository = bookAuthorRepository;
        this.bookAuthorMapper = bookAuthorMapper;
    }

    @Override
    public BookAuthorResponse createBookAuthor(BookAuthorRequest request) {
        BookAuthor entity = bookAuthorMapper.toEntity(request);
        entity.setId(new BookAuthorId(request.getBookId(), request.getAuthorId()));
        bookAuthorRepository.save(entity);
        return bookAuthorMapper.toResponse(entity);
    }

    @Override
    public void deleteBookAuthor(int bookId, int authorId) {
        bookAuthorRepository.deleteById(new BookAuthorId(bookId, authorId));
    }

    @Override
    public List<BookAuthorResponse> getAllBookAuthors() {
        return bookAuthorRepository.findAll()
                .stream()
                .map(bookAuthorMapper::toResponse)
                .collect(Collectors.toList());
    }
}
