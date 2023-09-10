package com.ejornal.ejornal.mappers;

import com.ejornal.ejornal.dto.GroupDto;
import com.ejornal.ejornal.dto.StudentDto;
import com.ejornal.ejornal.model.Group;
import com.ejornal.ejornal.model.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {

    @Test
    void dtoToEntity() {
        GroupDto groupDto = new GroupDto();
        groupDto.setTitle("1B");
        groupDto.setId(1L);

        Assertions.assertEquals("1B",groupDto.getTitle());
        Assertions.assertEquals(1L,groupDto.getId());

        StudentDto studentDto = new StudentDto();
        studentDto.setName("Ivan");
        studentDto.setSurname("Ivanoff");
        studentDto.setAge(12);
        studentDto.setAddress("Moscow");
        studentDto.setId(1L);
        studentDto.setGroupDto(groupDto);

        Assertions.assertNotNull(studentDto);
        Assertions.assertEquals("Ivan",studentDto.getName());
        Assertions.assertEquals("Ivanoff",studentDto.getSurname());
        Assertions.assertEquals(12,studentDto.getAge());
        Assertions.assertEquals("Moscow",studentDto.getAddress());
        Assertions.assertEquals(1L,studentDto.getId());
        Assertions.assertEquals(groupDto,studentDto.getGroupDto());

        Student student = new Student();
        student.setId(studentDto.getId());
        student.setName(studentDto.getName());
        student.setAge(studentDto.getAge());
        student.setSurname(studentDto.getSurname());
        student.setAddress(studentDto.getAddress());
        student.setGroup(GroupMapper.dtoToEntity(studentDto.getGroupDto()));

        Assertions.assertEquals(studentDto.getName(),student.getName());
        Assertions.assertEquals(studentDto.getSurname(),student.getSurname());
        Assertions.assertEquals(studentDto.getAge(),student.getAge());
        Assertions.assertEquals(studentDto.getId(),student.getId());
        Assertions.assertEquals(studentDto.getGroupDto(),GroupMapper.entityToDto(student.getGroup()));

    }

    @Test
    void entityToDto() {

        Group group = new Group();
        group.setTitle("1B");
        group.setId(1L);

        Assertions.assertEquals("1B",group.getTitle());
        Assertions.assertEquals(1L,group.getId());

        Student student = new Student();
        student.setName("Ivan");
        student.setSurname("Ivanoff");
        student.setAge(12);
        student.setAddress("Moscow");
        student.setId(1L);
        student.setGroup(group);

        Assertions.assertNotNull(student);
        Assertions.assertEquals("Ivan",student.getName());
        Assertions.assertEquals("Ivanoff",student.getSurname());
        Assertions.assertEquals(12,student.getAge());
        Assertions.assertEquals("Moscow",student.getAddress());
        Assertions.assertEquals(1L,student.getId());
        Assertions.assertEquals(group,student.getGroup());

        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setName(student.getName());
        studentDto.setAge(student.getAge());
        studentDto.setSurname(student.getSurname());
        studentDto.setAddress(student.getAddress());
        studentDto.setGroupDto(GroupMapper.entityToDto(student.getGroup()));

        Assertions.assertEquals(studentDto.getName(),student.getName());
        Assertions.assertEquals(studentDto.getSurname(),student.getSurname());
        Assertions.assertEquals(studentDto.getAge(),student.getAge());
        Assertions.assertEquals(studentDto.getId(),student.getId());
        Assertions.assertEquals(studentDto.getGroupDto(),GroupMapper.entityToDto(student.getGroup()));
    }
}