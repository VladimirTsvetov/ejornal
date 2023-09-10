package com.ejornal.ejornal.services;

import com.ejornal.ejornal.dto.GroupDto;
import com.ejornal.ejornal.dto.ScheduleDto;
import com.ejornal.ejornal.mappers.GroupMapper;
import com.ejornal.ejornal.mappers.ScheduleMapper;
import com.ejornal.ejornal.model.Group;
import com.ejornal.ejornal.model.Schedule;
import com.ejornal.ejornal.repositories.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;


    public List<GroupDto> findAll(){
        List<Group> groupList = groupRepository.findAll();
        List<GroupDto> groupDtoList = new ArrayList<>();

        for(Group g : groupList){
            groupDtoList.add(GroupMapper.entityToDto(g));
        }
        return groupDtoList;
    }

    public GroupDto findById(Long id) {
        return GroupMapper.entityToDto(groupRepository.findById(id).get());
    }

    public GroupDto findByTitle(String title){
        return GroupMapper.entityToDto(groupRepository.findByTitle(title).get());
    }

    public void createNewGroup(GroupDto groupDto) {
        groupRepository.save(GroupMapper.dtoToEntity(groupDto));
    }

    public void deleteById(Long id) {
        groupRepository.deleteById(id);
    }
}
