package dev.thangngo.repositories.impl;

import dev.thangngo.entities.Author;
import dev.thangngo.repositories.AuthorRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AuthorRepositoryImpl implements AuthorRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Author> findById(int id) {
        return Optional.ofNullable(entityManager.find(Author.class, id));
    }

    @Override
    public List<Author> findByAuthorName(String name) {
        List<Author> authors = entityManager
                .createQuery("FROM Author a WHERE LOWER(a.name) LIKE LOWER(CONCAT('%', :name, '%'))", Author.class)
                .setParameter("name", name)
                .getResultList();
        System.out.println("Kết quả tìm được: " + authors.size());
        return authors;
    }



    @Override
    public List<Author> findAll() {
        return entityManager.createQuery("SELECT a FROM Author a", Author.class)
                .getResultList();
    }

    @Override
    public void save(Author author) {
        if (author.getId() == 0) {
            entityManager.persist(author);
        } else {
            entityManager.merge(author);
        }
    }

    @Override
    public void deleteById(int id) {
        findById(id).ifPresent(author ->
                entityManager.remove(entityManager.contains(author) ? author : entityManager.merge(author))
        );
    }

    @Override
    public boolean existsById(int id) {
        Long count = entityManager.createQuery(
                        "SELECT COUNT(a) FROM Author a WHERE a.id = :id", Long.class)
                .setParameter("id", id)
                .getSingleResult();
        return count > 0;
    }

}
