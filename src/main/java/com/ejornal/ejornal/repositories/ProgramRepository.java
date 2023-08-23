package com.ejornal.ejornal.repositories;

import com.ejornal.ejornal.model.Program;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgramRepository extends JpaRepository<Program,Long> {
}
