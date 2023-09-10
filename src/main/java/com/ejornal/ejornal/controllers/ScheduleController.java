package com.ejornal.ejornal.controllers;

import com.ejornal.ejornal.dto.EmployeeDto;
import com.ejornal.ejornal.dto.ScheduleDto;
import com.ejornal.ejornal.model.Schedule;
import com.ejornal.ejornal.services.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin("*")
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;
    @GetMapping
    List<ScheduleDto> findAll(){
        return scheduleService.findAll();
    };

    @GetMapping("/{id}")
    ScheduleDto findById(@PathVariable Long id){
        return scheduleService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewSchedule(@RequestBody ScheduleDto scheduleDto) {
        scheduleService.createNewSchedule(scheduleDto);
    }

    @DeleteMapping("/{id}")
    public void deleteScheduleById(@PathVariable Long id) {
        scheduleService.deleteById(id);
    }
}

