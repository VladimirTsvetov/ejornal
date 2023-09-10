package com.ejornal.ejornal.services;

import com.ejornal.ejornal.model.Employee;
import com.ejornal.ejornal.model.Group;
import com.ejornal.ejornal.repositories.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EmployeeServiceTest {
    @Autowired
    EmployeeRepository employeeRepository;
    @Test
    void findAll() {
        List<Employee> employeeList = employeeRepository.findAll();
      Assertions.assertNotEquals(employeeList.isEmpty(),true);

    }

    @Test
    void findById() {
        Employee employee = employeeRepository.findById(1L).get();
        Assertions.assertNotNull(employee);
    }

    @Test
    void findBySurname() {
        Employee employee = employeeRepository.findBySurname("Капица").get();
        Assertions.assertNotNull(employee);
    }

    @Test
    void createNewEmployee() {


        Employee employee = new Employee();
        employee.setName("Михаил");
        employee.setPatronymic("Михаилович");
        employee.setSurname("Жванецкий");
        employee.setTitle("Профессор");
        employee.setAddress("Москва");
        employee.setPhone("12345678");
        employee.setEmail("mm@jmail.com");


        Assertions.assertNotNull(employee);
        Assertions.assertEquals("Михаил",employee.getName());
        Assertions.assertEquals("Михаилович",employee.getPatronymic());
        Assertions.assertEquals("Жванецкий",employee.getSurname());
        Assertions.assertEquals("Профессор",employee.getTitle());
        Assertions.assertEquals("Москва",employee.getAddress());
        Assertions.assertEquals("12345678",employee.getPhone());
        Assertions.assertEquals("mm@jmail.com",employee.getEmail());


        employeeRepository.save(employee);
        Employee savedEmployee = employeeRepository.findBySurname("Жванецкий").get();
        Assertions.assertNotNull(savedEmployee);
        Assertions.assertEquals(employee.getName(),savedEmployee.getName());
        Assertions.assertEquals(employee.getPatronymic(),savedEmployee.getPatronymic());
        Assertions.assertEquals(employee.getSurname(),savedEmployee.getSurname());
        Assertions.assertEquals(employee.getPhone(),savedEmployee.getPhone());
        Assertions.assertEquals(employee.getEmail(),savedEmployee.getEmail());
        Assertions.assertEquals(employee.getTitle(),savedEmployee.getTitle());

    }


}