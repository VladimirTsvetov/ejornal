package com.ejornal.ejornal.mappers;

import com.ejornal.ejornal.dto.ProgramDto;
import com.ejornal.ejornal.model.Program;

public class ProgramMapper {
    public static Program dtoToEntity(ProgramDto programDto){
        Program program = new Program();
        program.setId(programDto.getId());
        program.setTitle(programDto.getTitle());
        program.setGroup(GroupMapper.dtoToEntity(programDto.getGroupDto()));

        return program;
    }

    public static ProgramDto entityToDto(Program program){
        ProgramDto programDto = new ProgramDto();
        programDto.setId(program.getId());
        programDto.setTitle(program.getTitle());
        programDto.setGroupDto(GroupMapper.entityToDto(program.getGroup()));
        return programDto;
    }
}
