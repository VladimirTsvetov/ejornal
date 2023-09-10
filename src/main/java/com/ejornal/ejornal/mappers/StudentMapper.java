package com.ejornal.ejornal.mappers;

import com.ejornal.ejornal.dto.StudentDto;
import com.ejornal.ejornal.model.Student;

public class StudentMapper {
    public static Student dtoToEntity(StudentDto studentDto){
        Student student = new Student();
        student.setId(studentDto.getId());
        student.setName(studentDto.getName());
        student.setSurname(studentDto.getSurname());
        student.setAge(studentDto.getAge());
        student.setAddress(studentDto.getAddress());
        student.setGroup(GroupMapper.dtoToEntity(studentDto.getGroupDto()));

        return student;
    }

    public static StudentDto entityToDto(Student student){
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setName(student.getName());
        studentDto.setSurname(student.getSurname());
        studentDto.setAge(student.getAge());
        studentDto.setAddress(student.getAddress());
        studentDto.setGroupDto(GroupMapper.entityToDto(student.getGroup()));
        return studentDto;
    }
}
