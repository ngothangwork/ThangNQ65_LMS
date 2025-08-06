package dev.thangngo.mappers;

import dev.thangngo.dtos.BookDTO;
import dev.thangngo.entities.Book;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-06T10:57:09+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public BookDTO toDto(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDTO bookDTO = new BookDTO();

        bookDTO.setId( book.getId() );
        bookDTO.setTitle( book.getTitle() );
        bookDTO.setCategory( book.getCategory() );
        bookDTO.setAvailable( book.isAvailable() );

        return bookDTO;
    }

    @Override
    public Book toEntity(BookDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Book book = new Book();

        book.setId( dto.getId() );
        book.setTitle( dto.getTitle() );
        book.setCategory( dto.getCategory() );
        book.setAvailable( dto.isAvailable() );
        book.setVersion( dto.getVersion() );

        return book;
    }
}
