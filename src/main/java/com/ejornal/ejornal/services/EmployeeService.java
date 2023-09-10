package com.ejornal.ejornal.services;

import com.ejornal.ejornal.dto.EmployeeDto;
import com.ejornal.ejornal.dto.ProgramDto;
import com.ejornal.ejornal.dto.StudentDto;
import com.ejornal.ejornal.mappers.EmployeeMapper;
import com.ejornal.ejornal.mappers.ProgramMapper;
import com.ejornal.ejornal.mappers.StudentMapper;
import com.ejornal.ejornal.model.Employee;
import com.ejornal.ejornal.model.Program;
import com.ejornal.ejornal.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class EmployeeService {
    private final EmployeeRepository employeeRepository;



    public List<EmployeeDto> findAll(){
        List<Employee> employeeList = employeeRepository.findAll();
        List<EmployeeDto> employeeDtoList = new ArrayList<>();

        for(Employee p : employeeList){
            employeeDtoList.add(EmployeeMapper.entityToDto(p));
        }

        return employeeDtoList;

    }

    public EmployeeDto findById(Long id) {
       return EmployeeMapper.entityToDto(employeeRepository.findById(id).get());
    }

    public EmployeeDto findBySurname(String name) {
        return EmployeeMapper.entityToDto(employeeRepository.findBySurname(name).get());
    }

    public void createNewEmployee(EmployeeDto employeeDto) {
        employeeRepository.save(EmployeeMapper.dtoToEntity(employeeDto));
    }


    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }
}
