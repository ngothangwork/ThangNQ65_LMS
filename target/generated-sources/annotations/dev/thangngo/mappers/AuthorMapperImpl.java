package dev.thangngo.mappers;

import dev.thangngo.dtos.AuthorDTO;
import dev.thangngo.entities.Author;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-06T10:57:09+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class AuthorMapperImpl implements AuthorMapper {

    @Override
    public AuthorDTO toDto(Author author) {
        if ( author == null ) {
            return null;
        }

        AuthorDTO authorDTO = new AuthorDTO();

        authorDTO.setId( author.getId() );
        authorDTO.setName( author.getName() );
        authorDTO.setBirthYear( author.getBirthYear() );

        return authorDTO;
    }

    @Override
    public Author toEntity(AuthorDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Author author = new Author();

        author.setId( dto.getId() );
        author.setName( dto.getName() );
        author.setBirthYear( dto.getBirthYear() );

        return author;
    }
}
