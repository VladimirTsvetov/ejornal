package com.ejornal.ejornal.mappers;

import com.ejornal.ejornal.dto.GroupDto;
import com.ejornal.ejornal.model.Group;

public class GroupMapper {
    public static Group dtoToEntity(GroupDto groupDto){
        Group group = new Group();
        group.setId(groupDto.getId());
        group.setTitle(groupDto.getTitle());

        return group;
    }
    public static GroupDto entityToDto(Group group){
        GroupDto groupDto = new GroupDto();
        groupDto.setId(group.getId());
        groupDto.setTitle(group.getTitle());

        return groupDto;
    }

}
