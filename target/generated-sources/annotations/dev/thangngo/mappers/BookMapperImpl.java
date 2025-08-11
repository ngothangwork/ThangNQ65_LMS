package dev.thangngo.mappers;

import dev.thangngo.dtos.requests.book.BookCreateRequest;
import dev.thangngo.dtos.requests.book.BookUpdateRequest;
import dev.thangngo.dtos.responses.book.BookDetailResponse;
import dev.thangngo.dtos.responses.book.BookResponse;
import dev.thangngo.entities.Book;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-12T00:03:36+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public BookResponse toResponse(Book entity) {
        if ( entity == null ) {
            return null;
        }

        BookResponse bookResponse = new BookResponse();

        bookResponse.setAuthors( mapBookAuthorsToAuthors( entity.getBookAuthors() ) );
        bookResponse.setVersion( entity.getVersion() );
        bookResponse.setId( entity.getId() );
        bookResponse.setTitle( entity.getTitle() );
        bookResponse.setCategory( entity.getCategory() );
        bookResponse.setAvailable( entity.isAvailable() );

        return bookResponse;
    }

    @Override
    public Book toEntity(BookCreateRequest request) {
        if ( request == null ) {
            return null;
        }

        Book book = new Book();

        book.setTitle( request.getTitle() );
        book.setCategory( request.getCategory() );
        book.setAvailable( request.isAvailable() );
        book.setCreatedDate( request.getCreatedDate() );
        book.setVersion( request.getVersion() );

        return book;
    }

    @Override
    public BookDetailResponse toDetailResponse(Book entity) {
        if ( entity == null ) {
            return null;
        }

        BookDetailResponse bookDetailResponse = new BookDetailResponse();

        bookDetailResponse.setId( entity.getId() );
        bookDetailResponse.setTitle( entity.getTitle() );
        bookDetailResponse.setCategory( entity.getCategory() );
        bookDetailResponse.setAvailable( entity.isAvailable() );
        bookDetailResponse.setCreatedDate( entity.getCreatedDate() );
        bookDetailResponse.setVersion( entity.getVersion() );

        return bookDetailResponse;
    }

    @Override
    public void updateEntity(Book entity, BookUpdateRequest request) {
        if ( request == null ) {
            return;
        }

        entity.setTitle( request.getTitle() );
        entity.setCategory( request.getCategory() );
        entity.setAvailable( request.isAvailable() );
        entity.setCreatedDate( request.getCreatedDate() );
        entity.setVersion( request.getVersion() );
    }
}
