package com.ejornal.ejornal.services;

import com.ejornal.ejornal.model.Schedule;
import com.ejornal.ejornal.repositories.ScheduleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Time;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ScheduleServiceTest {

    @Autowired
    ScheduleRepository scheduleRepository;

    @Test
    void findAll() {
        List<Schedule> scheduleList = scheduleRepository.findAll();
        Assertions.assertNotEquals(scheduleList.isEmpty(),true);
    }

    @Test
    void findById() {
        Schedule schedule = scheduleRepository.findById(1L).get();
        Assertions.assertNotNull(schedule);
    }

    @Test
    void createNewSchedule() {
        Schedule schedule = new Schedule();
        schedule.setWork_time(new Time(13,30,00));
        schedule.setWork_day("пятница");
        scheduleRepository.save(schedule);
        Schedule testSchedule = scheduleRepository.findById(3L).get();
        Assertions.assertNotNull(testSchedule);
    }


}