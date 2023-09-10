package com.ejornal.ejornal.mappers;

import com.ejornal.ejornal.dto.EmployeeDto;
import com.ejornal.ejornal.dto.GroupDto;
import com.ejornal.ejornal.model.Employee;
import com.ejornal.ejornal.model.Group;

import java.util.ArrayList;
import java.util.List;

public class EmployeeMapper {
    public static EmployeeDto entityToDto(Employee employee){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setName(employee.getName());
        employeeDto.setPatronymic(employee.getPatronymic());
        employeeDto.setSurname(employee.getSurname());
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setAddress(employee.getAddress());
        employeeDto.setTitle(employee.getTitle());
        employeeDto.setPhone(employee.getPhone());
        List<Group> groupList = employee.getGroups();
        List<GroupDto> groupDtoList = new ArrayList<>();
        for(Group group : groupList)
            groupDtoList.add(GroupMapper.entityToDto(group));
        employeeDto.setGroups(groupDtoList);


        return employeeDto;
    }

    public static Employee dtoToEntity(EmployeeDto employeeDto){
        Employee employee = new Employee();
        employee.setId(employeeDto.getId());
        employee.setName(employeeDto.getName());
        employee.setPatronymic(employeeDto.getPatronymic());
        employee.setSurname(employeeDto.getSurname());
        employee.setEmail(employeeDto.getEmail());
        employee.setAddress(employeeDto.getAddress());
        employee.setTitle(employeeDto.getTitle());
        employee.setPhone(employeeDto.getPhone());
        List<GroupDto> groupDtoList = employeeDto.getGroups();
        List<Group> groupList = new ArrayList<>();
        for(GroupDto groupDto : groupDtoList)
            groupList.add(GroupMapper.dtoToEntity(groupDto));
        employee.setGroups(groupList);
        return employee;
    }
}
