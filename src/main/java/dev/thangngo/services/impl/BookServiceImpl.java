package dev.thangngo.services.impl;

import dev.thangngo.dtos.requests.author.AuthorCreateRequest;
import dev.thangngo.dtos.requests.book.BookCreateRequest;
import dev.thangngo.dtos.requests.book.BookUpdateRequest;
import dev.thangngo.dtos.responses.book.BookResponse;
import dev.thangngo.dtos.responses.book.BookDetailResponse;
import dev.thangngo.entities.Author;
import dev.thangngo.entities.Book;
import dev.thangngo.entities.BookAuthor;
import dev.thangngo.entities.BookAuthorId;
import dev.thangngo.mappers.AuthorMapper;
import dev.thangngo.mappers.BookMapper;
import dev.thangngo.repositories.AuthorRepository;
import dev.thangngo.repositories.BookAuthorRepository;
import dev.thangngo.repositories.BookRepository;
import dev.thangngo.services.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final BookAuthorRepository bookAuthorRepository;
    private final BookMapper bookMapper;
    private final AuthorMapper authorMapper;

    public BookServiceImpl(BookRepository bookRepository,
                           AuthorRepository authorRepository,
                           BookAuthorRepository bookAuthorRepository,
                           BookMapper bookMapper,
                           AuthorMapper authorMapper) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.bookAuthorRepository = bookAuthorRepository;
        this.bookMapper = bookMapper;
        this.authorMapper = authorMapper;
    }

    @Override
    public BookResponse createBook(BookCreateRequest request) {
        Book book = bookMapper.toEntity(request);
        bookRepository.save(book);
        Set<BookAuthor> bookAuthors = new HashSet<>();
        for (AuthorCreateRequest authorReq : request.getAuthors()) {
            Author author = authorRepository.findByAuthorName(authorReq.getName())
                    .stream()
                    .findFirst()
                    .orElseGet(() -> {
                        Author newAuthor = authorMapper.toEntity(authorReq);
                        authorRepository.save(newAuthor);
                        return newAuthor;
                    });

            BookAuthor bookAuthor = new BookAuthor();
            bookAuthor.setId(new BookAuthorId(book.getId(), author.getId()));
            bookAuthor.setBook(book);
            bookAuthor.setAuthor(author);
            bookAuthor.setRole("Author");
            bookAuthorRepository.save(bookAuthor);

            bookAuthors.add(bookAuthor);
        }

        book.setBookAuthors(bookAuthors);

        return bookMapper.toResponse(book);
    }

    @Transactional
    public BookResponse updateBook(int id, BookUpdateRequest request) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        book.setTitle(request.getTitle());
        book.setCategory(request.getCategory());
        book.setAvailable(request.isAvailable());
        book.setCreatedDate(request.getCreatedDate());
        book.setVersion(request.getVersion());


        Set<Integer> newAuthorIds = request.getAuthors() == null ? Set.of() :
                request.getAuthors().stream()
                        .map(authorDto -> authorDto.getId())
                        .collect(Collectors.toSet());

        Set<BookAuthor> currentBookAuthors = book.getBookAuthors();

        Set<BookAuthor> toRemove = currentBookAuthors.stream()
                .filter(ba -> !newAuthorIds.contains(ba.getAuthor().getId()))
                .collect(Collectors.toSet());

        toRemove.forEach(ba -> bookAuthorRepository.deleteById(ba.getId()));
        currentBookAuthors.removeAll(toRemove);

        for (Integer authorId : newAuthorIds) {
            boolean exists = currentBookAuthors.stream()
                    .anyMatch(ba -> ba.getAuthor().getId() == authorId);

            if (!exists) {
                Author author = authorRepository.findById(authorId)
                        .orElseThrow(() -> new RuntimeException("Author not found with id " + authorId));

                BookAuthor bookAuthor = new BookAuthor();
                bookAuthor.setBook(book);
                bookAuthor.setAuthor(author);
                bookAuthor.setId(new BookAuthorId(book.getId(), author.getId()));
                bookAuthor.setRole("Author"); // hoặc lấy role nếu có
                bookAuthorRepository.save(bookAuthor);
                currentBookAuthors.add(bookAuthor);
            }
        }

        book.setBookAuthors(currentBookAuthors);

        bookRepository.save(book);

        return bookMapper.toResponse(book);
    }



    @Override
    public BookDetailResponse getBookById(int id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        return bookMapper.toDetailResponse(book);
    }

    @Override
    public List<BookResponse> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(bookMapper::toResponse)
                .toList();
    }

    @Override
    public void deleteBook(int id) {
        if (!bookRepository.existsById(id)) {
            throw new RuntimeException("Book not found");
        }
        bookRepository.deleteById(id);
    }
}
