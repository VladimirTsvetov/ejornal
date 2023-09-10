package com.ejornal.ejornal.controllers;

import com.ejornal.ejornal.dto.EmployeeDto;
import com.ejornal.ejornal.dto.StudentDto;
import com.ejornal.ejornal.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin("*")
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    List<EmployeeDto> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    EmployeeDto findById(@PathVariable Long id){
        return employeeService.findById(id);
    }

    @GetMapping("/bysurname") //localhost:8189/journal/employees/bysurname?name=Иванов
    EmployeeDto findBySurname(@RequestParam String name){
        return employeeService.findBySurname(name);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewEmployee(@RequestBody EmployeeDto employeeDto) {
        employeeService.createNewEmployee(employeeDto);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable Long id) {
        employeeService.deleteById(id);
    }



}

