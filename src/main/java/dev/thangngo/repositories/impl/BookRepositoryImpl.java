package dev.thangngo.repositories.impl;

import dev.thangngo.entities.Book;
import dev.thangngo.repositories.BookRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookRepositoryImpl implements BookRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Optional<Book> findById(int id) {
        Book book = entityManager.createQuery(
                        "SELECT b FROM Book b LEFT JOIN FETCH b.bookAuthors ba LEFT JOIN FETCH ba.author WHERE b.id = :id", Book.class)
                .setParameter("id", id)
                .getSingleResult();
        return Optional.ofNullable(book);
    }


    @Override
    public List<Book> findAll() {
        return entityManager.createQuery("FROM Book", Book.class).getResultList();
    }

    @Override
    public void save(Book book) {
        if (book.getId() == 0) {
            entityManager.persist(book);
        } else {
            entityManager.merge(book);
        }
    }

    @Override
    public void deleteById(int id) {
        findById(id).ifPresent(book -> entityManager.remove(entityManager.contains(book) ? book : entityManager.merge(book)));
    }

    @Override
    public boolean existsById(int id) {
        return false;
    }
}
