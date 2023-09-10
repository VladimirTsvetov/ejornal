package com.ejornal.ejornal.services;

import com.ejornal.ejornal.model.Employee;
import com.ejornal.ejornal.model.Group;
import com.ejornal.ejornal.model.Program;
import com.ejornal.ejornal.repositories.EmployeeRepository;
import com.ejornal.ejornal.repositories.GroupRepository;
import com.ejornal.ejornal.repositories.ProgramRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProgramServiceTest {
    @Autowired
    ProgramRepository programRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    GroupRepository groupRepository;


    @Test
    void findAll() {
        List<Program> programList = programRepository.findAll();
        Assertions.assertNotEquals(programList.isEmpty(),true);
    }

    @Test
    void findById() {
        Program program = programRepository.findById(1L).get();
        Assertions.assertNotNull(program);
    }

    @Test
    void findByTitle() {
        Program program = programRepository.findByTitle("Робототехника").get();
        Assertions.assertNotNull(program);
    }


}