package dev.thangngo.mappers;

import dev.thangngo.dtos.requests.author.AuthorCreateRequest;
import dev.thangngo.dtos.requests.author.AuthorUpdateRequest;
import dev.thangngo.dtos.responses.author.AuthorResponse;
import dev.thangngo.dtos.responses.author.AuthorDetailResponse;
import dev.thangngo.entities.Author;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    Author toEntity(AuthorCreateRequest request);

    AuthorResponse toResponse(Author entity);

    AuthorDetailResponse toDetailResponse(Author entity);

    void updateEntity(@MappingTarget Author entity, AuthorUpdateRequest request);
}
