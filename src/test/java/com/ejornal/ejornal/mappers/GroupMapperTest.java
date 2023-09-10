package com.ejornal.ejornal.mappers;

import com.ejornal.ejornal.dto.GroupDto;
import com.ejornal.ejornal.dto.StudentDto;
import com.ejornal.ejornal.model.Group;
import com.ejornal.ejornal.model.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GroupMapperTest {

    @Test
    void dtoToEntity() {
        GroupDto groupDto = new GroupDto();
        groupDto.setTitle("1B");
        groupDto.setId(1L);

        Assertions.assertNotNull(groupDto);
        Assertions.assertEquals("1B",groupDto.getTitle());
        Assertions.assertEquals(1L,groupDto.getId());

        Group group = new Group();
        group.setId(groupDto.getId());
        group.setTitle(groupDto.getTitle());

        Assertions.assertNotNull(group);
        Assertions.assertEquals(group.getTitle(),groupDto.getTitle());
        Assertions.assertEquals(group.getId(),groupDto.getId());

    }

    @Test
    void entityToDto() {

        //создаем студента
        Student student = new Student();
        student.setName("Ivan");
        student.setSurname("Ivanoff");
        student.setAge(12);
        student.setAddress("Moscow");
        student.setId(1L);

        //добавляем в список
        List<Student> studentList = new ArrayList<>();
        studentList.add(student);

        //создаем группу
        Group group = new Group();
        group.setTitle("1B");
        group.setId(1L);
        group.setStudents(studentList);

        //Проверяем студента и группу на соответствие
        Assertions.assertNotNull(student);
        Assertions.assertNotNull(group);

        Assertions.assertEquals("Ivan",student.getName());
        Assertions.assertEquals("Ivanoff",student.getSurname());
        Assertions.assertEquals(12,student.getAge());
        Assertions.assertEquals("Moscow",student.getAddress());
        Assertions.assertEquals(1L,student.getId());

        Assertions.assertEquals("1B",group.getTitle());
        Assertions.assertEquals(1L,group.getId());
        Assertions.assertEquals(studentList.get(0),group.getStudents().get(0));

        //теперь выполняем мапинг и проверяем результат
        GroupDto groupDto = new GroupDto();
        groupDto.setId(group.getId());
        groupDto.setTitle(group.getTitle());

        Assertions.assertEquals(group.getId(),groupDto.getId());
        Assertions.assertEquals(group.getTitle(),groupDto.getTitle());

    }
}