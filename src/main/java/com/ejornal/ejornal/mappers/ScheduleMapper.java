package com.ejornal.ejornal.mappers;

import com.ejornal.ejornal.dto.ScheduleDto;
import com.ejornal.ejornal.model.Schedule;

public class ScheduleMapper {
    public static ScheduleDto entityToDto(Schedule schedule){
        ScheduleDto scheduleDto = new ScheduleDto();
        scheduleDto.setId(schedule.getId());
        scheduleDto.setWork_time(schedule.getWork_time());
        scheduleDto.setWork_day(schedule.getWork_day());
        return scheduleDto;
    }
    public static Schedule dtoToEntity(ScheduleDto scheduleDto){
        Schedule schedule = new Schedule();
        schedule.setId(scheduleDto.getId());
        schedule.setWork_day(scheduleDto.getWork_day());
        schedule.setWork_time(scheduleDto.getWork_time());
        return schedule;
    }
}
