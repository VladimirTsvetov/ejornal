package com.ejornal.ejornal.mappers;

import com.ejornal.ejornal.dto.EmployeeDto;
import com.ejornal.ejornal.dto.GroupDto;
import com.ejornal.ejornal.model.Employee;
import com.ejornal.ejornal.model.Group;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeMapperTest {

    @Test
    void entityToDto() {
        //Готовим тестовый объект
        List<Group> groups = new ArrayList<>();
        Group gr = new Group();
        gr.setTitle("1");
        groups.add(gr);

        Employee employee = new Employee();
        employee.setName("Михаил");
        employee.setPatronymic("Васильевич");
        employee.setSurname("Ломоносов");
        employee.setTitle("Профессор");
        employee.setAddress("Москва");
        employee.setPhone("12345678");
        employee.setEmail("lomonosov@jmail.com");
        employee.setGroups(groups);

        //мучительно проверяем созданный тестовый объект

        Assertions.assertNotNull(employee);
        Assertions.assertEquals("Михаил",employee.getName());
        Assertions.assertEquals("Васильевич",employee.getPatronymic());
        Assertions.assertEquals("Ломоносов",employee.getSurname());
        Assertions.assertEquals("Профессор",employee.getTitle());
        Assertions.assertEquals("Москва",employee.getAddress());
        Assertions.assertEquals("12345678",employee.getPhone());
        Assertions.assertEquals("lomonosov@jmail.com",employee.getEmail());
        Assertions.assertEquals(groups.get(0),employee.getGroups().get(0));


        //выполняем преобразование сущности в ДТО
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

        //теперь сверяем содержимое
        Assertions.assertNotNull(employeeDto);
        Assertions.assertEquals(employeeDto.getName(),employee.getName());
        Assertions.assertEquals(employeeDto.getPatronymic(),employee.getPatronymic());
        Assertions.assertEquals(employeeDto.getSurname(),employee.getSurname());
        Assertions.assertEquals(employeeDto.getTitle(),employee.getTitle());
        Assertions.assertEquals(employeeDto.getAddress(),employee.getAddress());
        Assertions.assertEquals(employeeDto.getEmail(),employee.getEmail());
        Assertions.assertEquals(employeeDto.getGroups().get(0).getTitle(),employee.getGroups().get(0).getTitle());


    }

    @Test
    void dtoToEntity() {

        //Готовим тестовый объект
        List<GroupDto> groups = new ArrayList<>();
        GroupDto gr = new GroupDto();
        gr.setTitle("1");
        groups.add(gr);

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Михаил");
        employeeDto.setPatronymic("Васильевич");
        employeeDto.setSurname("Ломоносов");
        employeeDto.setTitle("Профессор");
        employeeDto.setAddress("Москва");
        employeeDto.setPhone("12345678");
        employeeDto.setEmail("lomonosov@jmail.com");
        employeeDto.setGroups(groups);

        //мучительно проверяем созданный тестовый объект

        Assertions.assertNotNull(employeeDto);
        Assertions.assertEquals("Михаил",employeeDto.getName());
        Assertions.assertEquals("Васильевич",employeeDto.getPatronymic());
        Assertions.assertEquals("Ломоносов",employeeDto.getSurname());
        Assertions.assertEquals("Профессор",employeeDto.getTitle());
        Assertions.assertEquals("Москва",employeeDto.getAddress());
        Assertions.assertEquals("12345678",employeeDto.getPhone());
        Assertions.assertEquals("lomonosov@jmail.com",employeeDto.getEmail());
        Assertions.assertEquals(groups.get(0).getTitle(),employeeDto.getGroups().get(0).getTitle());


        //выполняем преобразование сущности в ДТО
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

        //теперь сверяем содержимое
        Assertions.assertNotNull(employee);
        Assertions.assertEquals(employeeDto.getName(),employee.getName());
        Assertions.assertEquals(employeeDto.getPatronymic(),employee.getPatronymic());
        Assertions.assertEquals(employeeDto.getSurname(),employee.getSurname());
        Assertions.assertEquals(employeeDto.getTitle(),employee.getTitle());
        Assertions.assertEquals(employeeDto.getAddress(),employee.getAddress());
        Assertions.assertEquals(employeeDto.getEmail(),employee.getEmail());
        Assertions.assertEquals(employeeDto.getGroups().get(0).getTitle(),employee.getGroups().get(0).getTitle());

    }
}