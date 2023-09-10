package com.ejornal.ejornal.repositories;

import com.ejornal.ejornal.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group,Long> {
    Optional<Group> findByTitle(String title);
}
