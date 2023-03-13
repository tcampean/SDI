package client.controller;

import core.domain.ScheduleDay;
import core.dto.SceneDto;
import core.dto.ScheduleDayDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@Service
public class ScheduleDayController {
    public static final Logger logger = LoggerFactory.getLogger(PerformanceController.class);
    private final ExecutorService executorService;
    private final RestTemplate restTemplate;

    @Autowired
    public ScheduleDayController(ExecutorService executorService, RestTemplate restTemplate) {
        this.executorService = executorService;
        this.restTemplate = restTemplate;
    }

    public CompletableFuture<Iterable<ScheduleDayDto>> getScheduleDaysFromRepository() {
        logger.trace("addScheduleDaysFromRepository - method entered and returned a completable future");
        return CompletableFuture.supplyAsync(() -> {
            String url = "http://localhost:8080/Gradle___org_example___web_1_0_SNAPSHOT_war/api/schedules";
            Set<ScheduleDayDto> days = restTemplate.getForObject(url, Set.class);
            return days;
        }, executorService);
    }

    public CompletableFuture<String> addScheduleDay(ScheduleDayDto dayDto) {
        logger.trace("addScheduleDay - method entered and returned a completable future");
        return CompletableFuture.supplyAsync(() -> {
            try {
                String url = "http://localhost:8080/Gradle___org_example___web_1_0_SNAPSHOT_war/api/schedules";
                restTemplate.postForObject(url, dayDto, ScheduleDayDto.class);
                return "Day added";
            } catch (ResourceAccessException resourceAccessException) {
                return "Inaccessible server";
            }
        }, executorService);
    }

    public CompletableFuture<String> deleteScheduleDay(Long id) {
        logger.trace("deleteScheduleDay - method entered and returned a completable future");
        return CompletableFuture.supplyAsync(() -> {
            try {
                String url = "http://localhost:8080/Gradle___org_example___web_1_0_SNAPSHOT_war/api/schedules";
                restTemplate.delete(url + "/{id}", id);
                return "Day successfully deleted";
            } catch (ResourceAccessException resourceAccessException) {
                return "Inaccessible server";
            }
        }, executorService);
    }

    public CompletableFuture<String> updateScheduleDay(ScheduleDayDto dayDto) {
        logger.trace("updateScheduleDay - method entered and returned a completable future");
        return CompletableFuture.supplyAsync(() -> {
            try {
                String url = "http://localhost:8080/Gradle___org_example___web_1_0_SNAPSHOT_war/api/schedules";
                dayDto.setId(dayDto.getId());
                restTemplate.put(url, dayDto);
                return "Day successfully updated";
            } catch (ResourceAccessException resourceAccessException) {
                return "Inaccessible server";
            }
        }, executorService);
    }
}