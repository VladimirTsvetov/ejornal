package com.ejornal.ejornal.services;

import com.ejornal.ejornal.model.Program;
import com.ejornal.ejornal.repositories.ProgramRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProgramService {
    private final ProgramRepository programRepository;

    public ProgramService(ProgramRepository programRepository) {
        this.programRepository = programRepository;
    }

    public List<Program> findAll(){
        return programRepository.findAll();
    }

}
