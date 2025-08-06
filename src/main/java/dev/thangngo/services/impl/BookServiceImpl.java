package dev.thangngo.services.impl;

import dev.thangngo.dtos.BookDTO;
import dev.thangngo.entities.Book;
import dev.thangngo.mappers.BookMapper;
import dev.thangngo.repositories.BookRepository;
import dev.thangngo.services.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public BookDTO getBookById(int id) {
        Book book = bookRepository.findById(id);
        return book != null ? bookMapper.toDto(book) : null;
    }

    @Override
    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(bookMapper::toDto)
                .toList();
    }

    @Override
    public void createOrUpdate(BookDTO bookDTO) {
        Book book = bookMapper.toEntity(bookDTO);
        bookRepository.save(book);
    }

    @Override
    public void removeBook(int id) {
        bookRepository.deleteById(id);
    }
}
