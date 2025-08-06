package dev.thangngo.repositories.impl;

import dev.thangngo.entities.Book;
import dev.thangngo.repositories.BookRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Book findById(int id) {
        return entityManager.find(Book.class, id);
    }

    @Override
    public List<Book> findAll() {
        return entityManager.createQuery("FROM Book", Book.class).getResultList();
    }

    @Override
    public void save(Book book) {
        entityManager.merge(book);
    }

    @Override
    public void deleteById(int id) {
        Book book = findById(id);
        if (book != null) {
            entityManager.remove(entityManager.contains(book) ? book : entityManager.merge(book));
        }
    }
}
