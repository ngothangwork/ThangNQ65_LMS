package dev.thangngo.mappers;

import dev.thangngo.dtos.requests.bookauthor.BookAuthorRequest;
import dev.thangngo.dtos.responses.bookauthor.BookAuthorResponse;
import dev.thangngo.entities.BookAuthor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookAuthorMapper {
    BookAuthor toEntity(BookAuthorRequest request);
    BookAuthorResponse toResponse(BookAuthor entity);
}
