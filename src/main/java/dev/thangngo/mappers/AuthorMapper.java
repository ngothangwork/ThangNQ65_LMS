package dev.thangngo.mappers;

import dev.thangngo.dtos.requests.AuthorRequest;
import dev.thangngo.dtos.responses.AuthorResponse;
import dev.thangngo.entities.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    Author toEntity(AuthorRequest request);

    @Mapping(source = "books", target = "books")
    AuthorResponse toResponse(Author author);
}
