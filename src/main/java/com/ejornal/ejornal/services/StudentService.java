package com.ejornal.ejornal.services;

import com.ejornal.ejornal.dto.ScheduleDto;
import com.ejornal.ejornal.dto.StudentDto;
import com.ejornal.ejornal.mappers.ScheduleMapper;
import com.ejornal.ejornal.mappers.StudentMapper;
import com.ejornal.ejornal.model.Schedule;
import com.ejornal.ejornal.model.Student;
import com.ejornal.ejornal.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class StudentService {
    private final StudentRepository studentRepository;


    public List<StudentDto> findAll(){
        List<Student> studentList = studentRepository.findAll();
        List<StudentDto> scheduleDtoList = new ArrayList<>();

        for(Student s : studentList){
            scheduleDtoList.add(StudentMapper.entityToDto(s));
        }
        return scheduleDtoList;
    }

    public StudentDto findById(Long id) {
        return StudentMapper.entityToDto(studentRepository.findById(id).get());
    }

    public StudentDto findByName(String name) {
        return StudentMapper.entityToDto(studentRepository.findByName(name).get());
    }

    public StudentDto findBySurname(String name) {
       return StudentMapper.entityToDto(studentRepository.findBySurname(name).get());
    }

    public void createNewStudent(StudentDto studentDto) {
        studentRepository.save(StudentMapper.dtoToEntity(studentDto));
    }


    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }
}
