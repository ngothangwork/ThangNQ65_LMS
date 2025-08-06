package dev.thangngo.controllers;

import dev.thangngo.dtos.requests.AuthorRequest;
import dev.thangngo.dtos.responses.AuthorResponse;
import dev.thangngo.services.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<List<AuthorResponse>> getAllAuthors() {
        return ResponseEntity.ok(authorService.getAllAuthors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponse> getAuthorById(@PathVariable int id) {
        AuthorResponse response = authorService.getAuthorById(id);
        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<String> createAuthor(@RequestBody AuthorRequest request) {
        authorService.createAuthor(request);
        return ResponseEntity.ok("Author created successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAuthor(@PathVariable int id, @RequestBody AuthorRequest request) {
        authorService.updateAuthor(id, request);
        return ResponseEntity.ok("Author updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable int id) {
        authorService.removeAuthor(id);
        return ResponseEntity.ok("Author deleted successfully");
    }
}
