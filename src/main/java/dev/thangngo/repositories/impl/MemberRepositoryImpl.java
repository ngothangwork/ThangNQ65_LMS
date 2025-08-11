package dev.thangngo.repositories.impl;

import dev.thangngo.entities.Member;
import dev.thangngo.repositories.MemberRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MemberRepositoryImpl implements MemberRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Member> findById(int id) {
        Member member = entityManager.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public List<Member> findAll() {
        return entityManager.createQuery("FROM Member", Member.class).getResultList();
    }

    @Override
    public void save(Member member) {
        if (member.getId() == 0) {
            entityManager.persist(member);
        } else {
            entityManager.merge(member);
        }
    }

    @Override
    public void deleteById(int id) {
        findById(id).ifPresent(m -> entityManager.remove(entityManager.contains(m) ? m : entityManager.merge(m)));
    }

    @Override
    public boolean existsById(int id) {
        Long count = entityManager.createQuery(
                        "SELECT COUNT(m) FROM Member m WHERE m.id = :id", Long.class)
                .setParameter("id", id)
                .getSingleResult();
        return count > 0;
    }
}
