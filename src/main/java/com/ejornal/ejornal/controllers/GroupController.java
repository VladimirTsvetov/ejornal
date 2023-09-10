package com.ejornal.ejornal.controllers;

import com.ejornal.ejornal.dto.EmployeeDto;
import com.ejornal.ejornal.dto.GroupDto;
import com.ejornal.ejornal.services.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin("*")
@RequestMapping("/groups")
@RequiredArgsConstructor
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping
    List<GroupDto> findAll(){
        return groupService.findAll();
    }

    @GetMapping("/{id}")
    GroupDto findById(@PathVariable Long id){
        return groupService.findById(id);
    }

    @GetMapping("/bytitle")
    GroupDto findByTitle(@RequestParam String title){
        return groupService.findByTitle(title);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewGroup(@RequestBody GroupDto groupDto) {
        groupService.createNewGroup(groupDto);
    }

    @DeleteMapping("/{id}")
    public void deleteGroupById(@PathVariable Long id) {
        groupService.deleteById(id);
    }

}
