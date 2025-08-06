package dev.thangngo.repositories.impl;

import dev.thangngo.entities.Author;
import dev.thangngo.repositories.AuthorRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorRepositoryImpl implements AuthorRepository {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public Author findById(int id) {
        return entityManager.find(Author.class, id);
    }

    @Override
    public Author findByAuthorName(String name) {
        return entityManager.find(Author.class, name);
    }

    @Override
    public List<Author> findAll() {
        return entityManager.createQuery("FROM Author", Author.class).getResultList();
    }

    @Override
    public void save(Author author) {
        entityManager.merge(author);
    }

    @Override
    public void deleteById(int id) {
        Author author = findById(id);
        if(author != null) {
            entityManager.remove(entityManager.contains(author) ? author : entityManager.merge(author));
        }
    }
}
