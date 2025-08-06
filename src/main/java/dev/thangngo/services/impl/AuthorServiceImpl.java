package dev.thangngo.services.impl;

import dev.thangngo.dtos.requests.AuthorRequest;
import dev.thangngo.dtos.responses.AuthorResponse;
import dev.thangngo.entities.Author;
import dev.thangngo.mappers.AuthorMapper;
import dev.thangngo.repositories.AuthorRepository;
import dev.thangngo.services.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public AuthorServiceImpl(AuthorRepository authorRepository, AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    @Override
    public AuthorResponse getAuthorById(int id) {
        Author author = authorRepository.findById(id);
        return author != null ? authorMapper.toResponse(author) : null;
    }

    @Override
    public List<AuthorResponse> getAllAuthors() {
        return authorRepository.findAll()
                .stream()
                .map(authorMapper::toResponse)
                .toList();
    }

    @Override
    public AuthorResponse getAuthorByName(String name) {
        Author author = authorRepository.findByAuthorName(name);
        return author != null ? authorMapper.toResponse(author) : null;
    }

    @Override
    public void createAuthor(AuthorRequest request) {
        Author author = authorMapper.toEntity(request);
        authorRepository.save(author);
    }

    @Override
    public void updateAuthor(int id, AuthorRequest request) {
        Author author = authorRepository.findById(id);
        if (author != null) {
            author.setName(request.getName());
            author.setBirthYear(request.getBirthYear());
            authorRepository.save(author);
        }
    }

    @Override
    public void removeAuthor(int id) {
        Author author = authorRepository.findById(id);
        if (author != null) {
            authorRepository.deleteById(id);
        }
    }
}
