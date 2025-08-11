package dev.thangngo.services;

import dev.thangngo.dtos.requests.author.AuthorCreateRequest;
import dev.thangngo.dtos.requests.author.AuthorUpdateRequest;
import dev.thangngo.dtos.responses.author.AuthorResponse;
import dev.thangngo.dtos.responses.author.AuthorDetailResponse;

import java.util.List;

public interface AuthorService {
    AuthorResponse createAuthor(AuthorCreateRequest request);
    AuthorResponse updateAuthor(int id, AuthorUpdateRequest request);
    void deleteAuthor(int id);
    AuthorDetailResponse getAuthorById(int id);
    List<AuthorResponse> getAllAuthors();
    List<AuthorResponse> getAuthorsByName(String name);
}
