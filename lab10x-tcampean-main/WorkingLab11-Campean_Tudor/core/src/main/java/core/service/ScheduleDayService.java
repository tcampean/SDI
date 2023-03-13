package core.service;

import core.dto.SceneDto;
import core.dto.ScheduleDayDto;

import java.util.Set;

public interface ScheduleDayService {

    Set<ScheduleDayDto> getScheduleDays();

    ScheduleDayDto saveScheduleDay(ScheduleDayDto scheduleDay);

    ScheduleDayDto updateScheduleDay(ScheduleDayDto scheduleDay);

    void deleteScheduleDay(Long id);

    public ScheduleDayDto findById(Long id);

}