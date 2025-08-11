package dev.thangngo.services.impl;

import dev.thangngo.dtos.requests.author.AuthorCreateRequest;
import dev.thangngo.dtos.requests.author.AuthorUpdateRequest;
import dev.thangngo.dtos.responses.author.AuthorResponse;
import dev.thangngo.dtos.responses.author.AuthorDetailResponse;
import dev.thangngo.entities.Author;
import dev.thangngo.mappers.AuthorMapper;
import dev.thangngo.repositories.AuthorRepository;
import dev.thangngo.services.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public AuthorServiceImpl(AuthorRepository authorRepository, AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    @Override
    public AuthorResponse createAuthor(AuthorCreateRequest request) {
        Author author = authorMapper.toEntity(request);
        authorRepository.save(author);
        return authorMapper.toResponse(author);
    }

    @Override
    public AuthorResponse updateAuthor(int id, AuthorUpdateRequest request) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));
        authorMapper.updateEntity(author, request);
        authorRepository.save(author);
        return authorMapper.toResponse(author);
    }

    @Override
    public void deleteAuthor(int id) {
        if (!authorRepository.existsById(id)) {
            throw new RuntimeException("Author not found");
        }
        authorRepository.deleteById(id);
    }

    @Override
    public AuthorDetailResponse getAuthorById(int id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));
        return authorMapper.toDetailResponse(author);
    }

    @Override
    public List<AuthorResponse> getAllAuthors() {
        return authorRepository.findAll()
                .stream()
                .map(authorMapper::toResponse)
                .toList();
    }

    @Override
    public List<AuthorResponse> getAuthorsByName(String name) {
        List<Author> authors = authorRepository.findByAuthorName(name);
        if (authors.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No authors found with name: " + name);
        }
        return authors.stream()
                .map(authorMapper::toResponse)
                .toList();
    }


}
