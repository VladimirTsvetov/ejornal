package com.ejornal.ejornal.repositories;

import com.ejornal.ejornal.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Long> {
    Optional<Student> findByName(String name);
    Optional<Student> findBySurname(String name);
}
