package dev.thangngo.mappers;

import dev.thangngo.dtos.BookDTO;
import dev.thangngo.entities.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDTO toDto(Book book);
    Book toEntity(BookDTO dto);
}
