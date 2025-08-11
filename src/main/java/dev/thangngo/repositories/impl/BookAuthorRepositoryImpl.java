package dev.thangngo.repositories.impl;

import dev.thangngo.entities.BookAuthor;
import dev.thangngo.entities.BookAuthorId;
import dev.thangngo.repositories.BookAuthorRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookAuthorRepositoryImpl implements BookAuthorRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public BookAuthor findById(BookAuthorId id) {
        return entityManager.find(BookAuthor.class, id);
    }

    @Override
    public List<BookAuthor> findAll() {
        return entityManager.createQuery("FROM BookAuthor", BookAuthor.class)
                .getResultList();
    }

    @Override
    public void save(BookAuthor bookAuthor) {
        entityManager.merge(bookAuthor);
    }

    @Override
    public void deleteById(BookAuthorId id) {
        BookAuthor entity = findById(id);
        if (entity != null) {
            entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
        }
    }
}
