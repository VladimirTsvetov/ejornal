package com.ejornal.ejornal.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
@Data
public class ScheduleDto {

    private Long id;
    private String work_day;
    private Time work_time;

}
