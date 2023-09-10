package com.ejornal.ejornal.services;

import com.ejornal.ejornal.model.Student;
import com.ejornal.ejornal.repositories.GroupRepository;
import com.ejornal.ejornal.repositories.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class StudentServiceTest {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    GroupRepository groupRepository;

    @Test
    void findAll() {
        List<Student> studentList = studentRepository.findAll();
        Assertions.assertNotEquals(studentList.isEmpty(),true);
    }

    @Test
    void findById() {
        Student student = studentRepository.findById(1L).get();
        Assertions.assertNotNull(student);
    }

    @Test
    void findByName() {
        Student student = studentRepository.findByName("Иван").get();
        Assertions.assertNotNull(student);
    }

    @Test
    void findBySurname() {
        Student student = studentRepository.findBySurname("Иванов").get();
        Assertions.assertNotNull(student);
    }



}