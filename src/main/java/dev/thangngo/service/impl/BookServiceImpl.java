package dev.thangngo.service.impl;

import dev.thangngo.entities.Book;
import dev.thangngo.repository.BookRepository;
import dev.thangngo.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book getBookById(int id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void createOrUpdate(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void removeBook(int id) {
        bookRepository.deleteById(id);
    }
}
