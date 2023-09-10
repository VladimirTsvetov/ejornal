package com.ejornal.ejornal.services;

import com.ejornal.ejornal.dto.ScheduleDto;
import com.ejornal.ejornal.mappers.ScheduleMapper;
import com.ejornal.ejornal.model.Schedule;
import com.ejornal.ejornal.repositories.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class ScheduleService {
    private final ScheduleRepository scheduleRepository;


    public List<ScheduleDto> findAll(){
        List<Schedule> scheduleList = scheduleRepository.findAll();
        List<ScheduleDto> scheduleDtoList = new ArrayList<>();

        for(Schedule s : scheduleList){
            scheduleDtoList.add(ScheduleMapper.entityToDto(s));
        }
        return scheduleDtoList;
    }

    public ScheduleDto findById(Long id) {
        ScheduleDto scheduleDto = ScheduleMapper.entityToDto(scheduleRepository.findById(id).get());
        return scheduleDto;
    }

    public void createNewSchedule(ScheduleDto scheduleDto) {
        scheduleRepository.save(ScheduleMapper.dtoToEntity(scheduleDto));
    }


    public void deleteById(Long id) {
        scheduleRepository.deleteById(id);
    }
}
