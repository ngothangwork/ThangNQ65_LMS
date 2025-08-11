package dev.thangngo.repositories.impl;

import dev.thangngo.entities.Borrowing;
import dev.thangngo.repositories.BorrowingRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BorrowingRepositoryImpl implements BorrowingRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Borrowing> findById(int id) {
        Borrowing borrowing = entityManager.find(Borrowing.class, id);
        return Optional.ofNullable(borrowing);
    }

    @Override
    public List<Borrowing> findAll() {
        return entityManager.createQuery("FROM Borrowing", Borrowing.class).getResultList();
    }

    @Override
    public void save(Borrowing borrowing) {
        if (borrowing.getId() == 0) {
            entityManager.persist(borrowing);
        } else {
            entityManager.merge(borrowing);
        }
    }

    @Override
    public void deleteById(int id) {
        findById(id).ifPresent(b -> entityManager.remove(entityManager.contains(b) ? b : entityManager.merge(b)));
    }

    @Override
    public boolean existsById(int id) {
        Long count = entityManager.createQuery(
                        "SELECT COUNT(b) FROM Borrowing b WHERE b.id = :id", Long.class)
                .setParameter("id", id)
                .getSingleResult();
        return count > 0;
    }
}
