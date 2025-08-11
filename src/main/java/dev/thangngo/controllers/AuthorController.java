package dev.thangngo.controllers;

import dev.thangngo.dtos.requests.author.AuthorCreateRequest;
import dev.thangngo.dtos.requests.author.AuthorUpdateRequest;
import dev.thangngo.dtos.responses.author.AuthorResponse;
import dev.thangngo.dtos.responses.author.AuthorDetailResponse;
import dev.thangngo.services.AuthorService;
import jakarta.validation.Valid;
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

    @PostMapping
    public ResponseEntity<AuthorResponse> createAuthor(
            @Valid @RequestBody AuthorCreateRequest request) {
        return ResponseEntity.ok(authorService.createAuthor(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorResponse> updateAuthor(
            @PathVariable("id") int id,
            @Valid @RequestBody AuthorUpdateRequest request) {
        return ResponseEntity.ok(authorService.updateAuthor(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable("id") int id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDetailResponse> getAuthorById(@PathVariable int id) {
        return ResponseEntity.ok(authorService.getAuthorById(id));
    }

    @GetMapping
    public ResponseEntity<List<AuthorResponse>> getAllAuthors() {
        return ResponseEntity.ok(authorService.getAllAuthors());
    }

    @GetMapping("/search")
    public ResponseEntity<List<AuthorResponse>> getAuthorsByName(@RequestParam("name") String name) {
        return ResponseEntity.ok(authorService.getAuthorsByName(name));
    }


}
