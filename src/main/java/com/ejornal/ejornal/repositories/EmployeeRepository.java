package com.ejornal.ejornal.repositories;

import com.ejornal.ejornal.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findBySurname(String name);
}
