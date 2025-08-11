package dev.thangngo.mappers;

import dev.thangngo.dtos.requests.book.BookCreateRequest;
import dev.thangngo.dtos.requests.book.BookUpdateRequest;
import dev.thangngo.dtos.responses.author.AuthorResponse;
import dev.thangngo.dtos.responses.book.BookResponse;
import dev.thangngo.dtos.responses.book.BookDetailResponse;
import dev.thangngo.entities.Author;
import dev.thangngo.entities.Book;
import dev.thangngo.entities.BookAuthor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface BookMapper {
    @Mapping(target = "authors", source = "bookAuthors", qualifiedByName = "mapBookAuthorsToAuthors")
    BookResponse toResponse(Book entity);

    @Named("mapBookAuthorsToAuthors")
    default List<AuthorResponse> mapBookAuthorsToAuthors(Set<BookAuthor> bookAuthors) {
        if (bookAuthors == null) {
            return null;
        }
        return bookAuthors.stream()
                .map(bookAuthor -> {
                    Author author = bookAuthor.getAuthor();
                    AuthorResponse authorResponse = new AuthorResponse();
                    authorResponse.setId(author.getId());
                    authorResponse.setName(author.getName());
                    authorResponse.setBirthYear(author.getBirthYear());
                    return authorResponse;
                })
                .collect(Collectors.toList());
    }

    Book toEntity(BookCreateRequest request);


    BookDetailResponse toDetailResponse(Book entity);

    void updateEntity(@MappingTarget Book entity, BookUpdateRequest request);
}
