package com.ejornal.ejornal.controllers;

import com.ejornal.ejornal.dto.StudentDto;
import com.ejornal.ejornal.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin("*")
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    @Autowired
    private StudentService studentService;
    @GetMapping
    List<StudentDto> findAll(){
        return studentService.findAll();
    };

    @GetMapping("/{id}")
    StudentDto findById(@PathVariable Long id){
        return studentService.findById(id);
    }

    @GetMapping("/byname") //localhost:8189/journal/students/byname?name=Иван
    StudentDto findByName(@RequestParam String name){
        return studentService.findByName(name);
    }

    @GetMapping("/bysurname") //localhost:8189/journal/students/bysurname?name=Иванов
    StudentDto findBySurname(@RequestParam String name){
        return studentService.findBySurname(name);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewStudent(@RequestBody StudentDto studentDto) {
        studentService.createNewStudent(studentDto);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Long id) {
        studentService.deleteById(id);
    }

    /*
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewEmployee(@RequestBody EmployeeDto employeeDto) {
        employeeService.createNewEmployee(employeeDto);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable Long id) {
        employeeService.deleteById(id);
    }
     */

}
