package com.ejornal.ejornal.repositories;

import com.ejornal.ejornal.model.Group;
import com.ejornal.ejornal.model.Program;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProgramRepository extends JpaRepository<Program,Long> {
    Optional<Program> findByTitle(String title);
}
