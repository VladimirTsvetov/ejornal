package com.ejornal.ejornal.controllers;

import com.ejornal.ejornal.dto.EmployeeDto;
import com.ejornal.ejornal.dto.GroupDto;
import com.ejornal.ejornal.dto.ProgramDto;
import com.ejornal.ejornal.mappers.ProgramMapper;
import com.ejornal.ejornal.model.Program;
import com.ejornal.ejornal.services.ProgramService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
//@CrossOrigin("*")
@RequestMapping("/programs")
@RequiredArgsConstructor
public class ProgramController {
    @Autowired
    private ProgramService programService;
    @GetMapping
    List<ProgramDto> findAll(){
        return programService.findAll();
    };

    @GetMapping("/{id}")
    ProgramDto findById(@PathVariable Long id){
        return programService.findById(id);
    }

    @GetMapping("/bytitle")
    ProgramDto findByTitle(@RequestParam String title){
        return programService.findByTitle(title);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewProgram(@RequestBody ProgramDto programDto) {
        programService.createNewProgram(programDto);
    }

    @DeleteMapping("/{id}")
    public void deleteProgramById(@PathVariable Long id) {
        programService.deleteById(id);
    }
}
