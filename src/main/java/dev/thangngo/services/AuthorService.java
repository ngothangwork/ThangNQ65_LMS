package dev.thangngo.services;

import dev.thangngo.dtos.requests.AuthorRequest;
import dev.thangngo.dtos.responses.AuthorResponse;

import java.util.List;

public interface AuthorService {
    AuthorResponse getAuthorById(int id);
    List<AuthorResponse> getAllAuthors();
    AuthorResponse getAuthorByName(String name);
    void createAuthor(AuthorRequest request);
    void updateAuthor(int id, AuthorRequest request);
    void removeAuthor(int id);
}
