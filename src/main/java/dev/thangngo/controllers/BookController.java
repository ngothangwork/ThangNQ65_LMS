package dev.thangngo.controllers;

import dev.thangngo.dtos.BookDTO;
import dev.thangngo.services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable("id") int id) {
        BookDTO bookDTO = bookService.getBookById(id);
        return bookDTO != null
                ? ResponseEntity.ok(bookDTO)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") int id) {
        bookService.removeBook(id);
        return ResponseEntity.ok("Book deleted successfully");
    }


    @PostMapping
    public ResponseEntity<String> createOrUpdateBook(@RequestBody BookDTO bookDTO) {
        bookService.createOrUpdate(bookDTO);
        return ResponseEntity.ok("Book saved successfully");
    }
}
