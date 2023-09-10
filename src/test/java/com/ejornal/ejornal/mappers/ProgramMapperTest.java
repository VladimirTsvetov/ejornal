package com.ejornal.ejornal.mappers;

import com.ejornal.ejornal.dto.GroupDto;
import com.ejornal.ejornal.dto.ProgramDto;
import com.ejornal.ejornal.model.Group;
import com.ejornal.ejornal.model.Program;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProgramMapperTest {

    @Test
    void dtoToEntity() {
        //создаем группу
        GroupDto groupDto = new GroupDto();
        groupDto.setTitle("1A");
        groupDto.setId(1L);

        Assertions.assertNotNull(groupDto);
        Assertions.assertEquals("1A",groupDto.getTitle());
        Assertions.assertEquals(1L,groupDto.getId());

        //готовим ДТО, проверяем ее
        ProgramDto programDto = new ProgramDto();
        programDto.setGroupDto(groupDto);
        programDto.setTitle("Робототехника");
        programDto.setId(1L);

        Assertions.assertNotNull(programDto);
        Assertions.assertEquals(1L,programDto.getId());
        Assertions.assertEquals("Робототехника",programDto.getTitle());
        Assertions.assertEquals(groupDto,programDto.getGroupDto());

        //теперь проверяем маппер
        Program program = new Program();
        program.setGroup(GroupMapper.dtoToEntity(programDto.getGroupDto()));
        program.setTitle(programDto.getTitle());
        program.setId(programDto.getId());

        Assertions.assertNotNull(program);
        Assertions.assertEquals(program.getId(),programDto.getId());
        Assertions.assertEquals(program.getTitle(),programDto.getTitle());
        Assertions.assertEquals(program.getGroup(),GroupMapper.dtoToEntity(programDto.getGroupDto()));

    }

    @Test
    void entityToDto() {
        //создаем группу
        Group group = new Group();
        group.setTitle("1A");
        group.setId(1L);

        Assertions.assertNotNull(group);
        Assertions.assertEquals("1A",group.getTitle());
        Assertions.assertEquals(1L,group.getId());

        //готовим ДТО, проверяем ее
        Program program = new Program();
        program.setGroup(group);
        program.setTitle("Робототехника");
        program.setId(1L);

        Assertions.assertNotNull(program);
        Assertions.assertEquals(1L,program.getId());
        Assertions.assertEquals("Робототехника",program.getTitle());
        Assertions.assertEquals(group,program.getGroup());

        //теперь проверяем маппер
        ProgramDto programDto = new ProgramDto();
        programDto.setGroupDto(GroupMapper.entityToDto(program.getGroup()));
        programDto.setTitle(program.getTitle());
        programDto.setId(program.getId());

        Assertions.assertNotNull(program);
        Assertions.assertEquals(program.getId(),programDto.getId());
        Assertions.assertEquals(program.getTitle(),programDto.getTitle());
        Assertions.assertEquals(program.getGroup(),GroupMapper.dtoToEntity(programDto.getGroupDto()));
    }
}