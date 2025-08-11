package dev.thangngo.repositories;

import dev.thangngo.entities.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Optional<Member> findById(int id);
    List<Member> findAll();
    void save(Member member);
    void deleteById(int id);
    boolean existsById(int id);
}
