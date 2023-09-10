package com.ejornal.ejornal.mappers;

import com.ejornal.ejornal.dto.ScheduleDto;
import com.ejornal.ejornal.model.Schedule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Time;

import static org.junit.jupiter.api.Assertions.*;

class ScheduleMapperTest {

    @Test
    void entityToDto() {
        //создаем расписание
        Time time = new Time(13,30,00);
        Schedule schedule = new Schedule();
        schedule.setId(1L);
        schedule.setWork_day("понедельник");
        schedule.setWork_time(time);
        //проверяем расписание
        Assertions.assertNotNull(schedule);
        Assertions.assertEquals(1L,schedule.getId());
        Assertions.assertEquals("понедельник",schedule.getWork_day());
        Assertions.assertEquals("13:30:00",schedule.getWork_time().toString());

        //выполняем преобразование и проверяем результат
        ScheduleDto scheduleDto = new ScheduleDto();
        scheduleDto.setId(schedule.getId());
        scheduleDto.setWork_day(schedule.getWork_day());
        scheduleDto.setWork_time(schedule.getWork_time());

        Assertions.assertEquals(scheduleDto.getId(),schedule.getId());
        Assertions.assertEquals(scheduleDto.getWork_day(),schedule.getWork_day());
        Assertions.assertEquals(scheduleDto.getWork_time(),schedule.getWork_time());

    }

    @Test
    void dtoToEntity() {
        //создаем расписание
        Time time = new Time(13,30,00);
        ScheduleDto scheduleDto = new ScheduleDto();
        scheduleDto.setId(1L);
        scheduleDto.setWork_day("понедельник");
        scheduleDto.setWork_time(time);
        //проверяем расписание
        Assertions.assertNotNull(scheduleDto);
        Assertions.assertEquals(1L,scheduleDto.getId());
        Assertions.assertEquals("понедельник",scheduleDto.getWork_day());
        Assertions.assertEquals("13:30:00",scheduleDto.getWork_time().toString());

        //выполняем преобразование и проверяем результат
        Schedule schedule = new Schedule();
        schedule.setId(scheduleDto.getId());
        schedule.setWork_day(scheduleDto.getWork_day());
        schedule.setWork_time(scheduleDto.getWork_time());

        Assertions.assertEquals(scheduleDto.getId(),schedule.getId());
        Assertions.assertEquals(scheduleDto.getWork_day(),schedule.getWork_day());
        Assertions.assertEquals(scheduleDto.getWork_time(),schedule.getWork_time());

    }
}