package dev.thangngo.mappers;

import dev.thangngo.dtos.requests.author.AuthorCreateRequest;
import dev.thangngo.dtos.requests.author.AuthorUpdateRequest;
import dev.thangngo.dtos.responses.author.AuthorDetailResponse;
import dev.thangngo.dtos.responses.author.AuthorResponse;
import dev.thangngo.entities.Author;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-12T09:01:41+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class AuthorMapperImpl implements AuthorMapper {

    @Override
    public Author toEntity(AuthorCreateRequest request) {
        if ( request == null ) {
            return null;
        }

        Author author = new Author();

        author.setName( request.getName() );
        author.setBirthYear( request.getBirthYear() );

        return author;
    }

    @Override
    public AuthorResponse toResponse(Author entity) {
        if ( entity == null ) {
            return null;
        }

        AuthorResponse authorResponse = new AuthorResponse();

        authorResponse.setId( entity.getId() );
        authorResponse.setName( entity.getName() );
        authorResponse.setBirthYear( entity.getBirthYear() );

        return authorResponse;
    }

    @Override
    public AuthorDetailResponse toDetailResponse(Author entity) {
        if ( entity == null ) {
            return null;
        }

        AuthorDetailResponse authorDetailResponse = new AuthorDetailResponse();

        authorDetailResponse.setId( entity.getId() );
        authorDetailResponse.setName( entity.getName() );
        authorDetailResponse.setBirthYear( entity.getBirthYear() );

        return authorDetailResponse;
    }

    @Override
    public void updateEntity(Author entity, AuthorUpdateRequest request) {
        if ( request == null ) {
            return;
        }

        entity.setName( request.getName() );
        entity.setBirthYear( request.getBirthYear() );
    }
}
