package ru.nidjat.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nidjat.entity.Person;

@Repository
public interface UserRepository extends JpaRepository<Person, Long> {



}
