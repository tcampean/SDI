package web.controller;

import core.converter.ScheduleDayConverter;

import core.dto.ScheduleDayDto;
import core.service.ScheduleDayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class ScheduleDayController {

    public static final Logger logger = LoggerFactory.getLogger(ScheduleDayController.class);
    private final ScheduleDayService scheduleDayService;
    private final ScheduleDayConverter scheduleDayConverter;

    @Autowired
    public ScheduleDayController(ScheduleDayService dayService, ScheduleDayConverter scheduleDayConverter) {
        this.scheduleDayService = dayService;
        this.scheduleDayConverter = scheduleDayConverter;
    }

    @RequestMapping(value = "/schedules")
    Set<ScheduleDayDto> getScheduleDays() {
        logger.trace("getScheduleDay - method entered");
        var days = scheduleDayService.getScheduleDays();
        logger.trace("getScheduleDay - method returned a set of dtos");
        return days;
    }

    @RequestMapping(value = "/schedules", method = RequestMethod.POST)
    ScheduleDayDto addScheduleDay(@RequestBody ScheduleDayDto dayDto) {
        logger.trace("addScheduleDay - method entered");
        scheduleDayService.saveScheduleDay(dayDto);
        logger.trace("addScheduleDay - method added schedule and returned an instance of it");
        return dayDto;
    }

    @RequestMapping(value = "/schedules", method = RequestMethod.PUT)
    ScheduleDayDto updateScheduleDay(@RequestBody ScheduleDayDto dto) {
        logger.trace("updateScheduleDay - method entered");
        scheduleDayService.updateScheduleDay(dto);
        logger.trace("updateScheduleDay - method updated schedule and returned an instance of it");
        return dto;
    }

    @RequestMapping(value = "/schedules/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteScheduleDay(@PathVariable Long id) {
        logger.trace("deleteScheduleDay - method entered");
        scheduleDayService.deleteScheduleDay(id);
        logger.trace("deleteScheduleDay - method deleted schedule and returned an instance of it");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
