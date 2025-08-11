package dev.thangngo.repositories;

import dev.thangngo.entities.Borrowing;

import java.util.List;
import java.util.Optional;

public interface BorrowingRepository {
    Optional<Borrowing> findById(int id);
    List<Borrowing> findAll();
    void save(Borrowing borrowing);
    void deleteById(int id);
    boolean existsById(int id);
}
