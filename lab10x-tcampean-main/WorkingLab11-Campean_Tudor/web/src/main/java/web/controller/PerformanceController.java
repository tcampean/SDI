package web.controller;

import core.converter.PerformanceConverter;
import core.converter.SceneConverter;
import core.domain.Performance;
import core.dto.PerformanceDto;
import core.dto.SceneDto;
import core.service.PerformanceService;
import core.service.SceneService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class PerformanceController {
    public static final Logger logger = LoggerFactory.getLogger(PerformanceController.class);
    private final PerformanceService performanceService;
    private final PerformanceConverter performanceConverter;

    @Autowired
    public PerformanceController(PerformanceService performanceService, PerformanceConverter performanceConverter) {
        this.performanceService = performanceService;
        this.performanceConverter = performanceConverter;
    }

    @RequestMapping(value = "/performances")
    Set<PerformanceDto> getPerformances() {
        logger.trace("getPerformances - method entered");
        var performance = performanceService.getPerformances();
        logger.trace("getPerformances - method returned a set of dtos");
        return performance;
    }

    @RequestMapping(value = "/performances", method = RequestMethod.POST)
    PerformanceDto addPerformance(@RequestBody PerformanceDto performanceDto) {
        logger.trace("addPerformance - method entered");
        performanceService.savePerformance(performanceDto);
        logger.trace("addPerformance - method added performance and returned an instance of it");
        return performanceDto;
    }

    @RequestMapping(value = "/performances", method = RequestMethod.PUT)
    PerformanceDto updatePerformance(@RequestBody PerformanceDto dto) {
        logger.trace("updatePerformance - method entered");
        performanceService.updatePerformance(dto);
        logger.trace("updatePerformance - method updated performance and returned an instance of it");
        return dto;
    }

    @RequestMapping(value = "/performances/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deletePerformance(@PathVariable Long id) {
        logger.trace("deletePerformance - method entered");
        performanceService.deletePerformance(id);
        logger.trace("deletePerformance - method delete performance and returned a response");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}