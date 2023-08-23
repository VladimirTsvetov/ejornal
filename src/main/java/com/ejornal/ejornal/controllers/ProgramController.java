package com.ejornal.ejornal.controllers;

import com.ejornal.ejornal.model.Program;
import com.ejornal.ejornal.services.ProgramService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@CrossOrigin("*")
@RequestMapping("/programs")
@RequiredArgsConstructor
public class ProgramController {
    @Autowired
    private ProgramService programService;
    @GetMapping
    List<Program> findAll(){
        return programService.findAll();
    };
}
