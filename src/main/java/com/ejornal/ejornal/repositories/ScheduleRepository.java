package com.ejornal.ejornal.repositories;

import com.ejornal.ejornal.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule,Long> {
}
