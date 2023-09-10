package com.ejornal.ejornal.services;

import com.ejornal.ejornal.model.Employee;
import com.ejornal.ejornal.model.Group;
import com.ejornal.ejornal.repositories.EmployeeRepository;
import com.ejornal.ejornal.repositories.GroupRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class GroupServiceTest {
    @Autowired
    GroupRepository groupRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    void findAll() {
        List<Group> groupList = groupRepository.findAll();
        Assertions.assertNotEquals(groupList.isEmpty(),true);
    }

    @Test
    void findById() {
        Group group = groupRepository.findById(1L).get();
        Assertions.assertNotNull(group);
    }

    @Test
    void findByTitle() {
        Group group = groupRepository.findByTitle("7А7Б").get();
        Assertions.assertNotNull(group);
    }

    @Test
    void createNewGroup() {
        Employee employee = new Employee();
        employee.setName("Михаил");
        employee.setPatronymic("Михаилович");
        employee.setSurname("Жванецкий");
        employee.setTitle("Профессор");
        employee.setAddress("Москва");
        employee.setPhone("12345678");
        employee.setEmail("mm@jmail.com");

        employeeRepository.save(employee);

        Group testGroup = new Group();
        testGroup.setTitle("111");
        testGroup.setStudents(null);
        testGroup.setEmployee(employee);
        groupRepository.save(testGroup);
        Group group = groupRepository.findByTitle("111").get();
        Assertions.assertNotNull(group);
    }


}