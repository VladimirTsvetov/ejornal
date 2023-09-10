package com.ejornal.ejornal.services;

import com.ejornal.ejornal.dto.ProgramDto;
import com.ejornal.ejornal.mappers.ProgramMapper;
import com.ejornal.ejornal.model.Program;
import com.ejornal.ejornal.repositories.ProgramRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class ProgramService {
    private final ProgramRepository programRepository;


    public List<ProgramDto> findAll(){
        List<Program> programList = programRepository.findAll();
        List<ProgramDto> programDtoList = new ArrayList<>();

        for(Program p : programList){
            programDtoList.add(ProgramMapper.entityToDto(p));
        }

        return programDtoList;
    }

    public ProgramDto findById(Long id) {
        return ProgramMapper.entityToDto(programRepository.findById(id).get());
    }

    public ProgramDto findByTitle(String title){
        return ProgramMapper.entityToDto(programRepository.findByTitle(title).get());
    }

    public void createNewProgram(ProgramDto programDto) {
        programRepository.save(ProgramMapper.dtoToEntity(programDto));
    }

    public void deleteById(Long id) {
        programRepository.deleteById(id);
    }
}
