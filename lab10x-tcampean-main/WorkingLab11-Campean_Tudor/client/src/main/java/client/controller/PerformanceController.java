package client.controller;

import core.domain.Performance;
import core.dto.PerformanceDto;
import core.dto.SceneDto;
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
public class PerformanceController {
    public static final Logger logger = LoggerFactory.getLogger(PerformanceController.class);
    private final ExecutorService executorService;
    private final RestTemplate restTemplate;

    @Autowired
    public PerformanceController(ExecutorService executorService, RestTemplate restTemplate) {
        this.executorService = executorService;
        this.restTemplate = restTemplate;
    }

    public CompletableFuture<Iterable<PerformanceDto>> getPerformancesFromRepository() {
        logger.trace("getPerformancesFromRepository - method entered and returned a completable future");
        return CompletableFuture.supplyAsync(() -> {
            String url = "http://localhost:8080/Gradle___org_example___web_1_0_SNAPSHOT_war/api/performances";

            Set<PerformanceDto> performances = restTemplate.getForObject(url, Set.class);
            return performances;
        }, executorService);
    }

    public CompletableFuture<String> addPerformance(PerformanceDto performanceDto) {
        logger.trace("addPerformance - method entered and returned a completable future");
        return CompletableFuture.supplyAsync(() -> {
            try {
                String url = "http://localhost:8080/Gradle___org_example___web_1_0_SNAPSHOT_war/api/performances";
                restTemplate.postForObject(url, performanceDto, PerformanceDto.class);
                return "Performance added";
            } catch (ResourceAccessException resourceAccessException) {
                return "Inaccessible server";
            }
        }, executorService);
    }

    public CompletableFuture<String> deletePerformance(Long id) {
        logger.trace("deletePerformance - method entered and returned a completable future");
        return CompletableFuture.supplyAsync(() -> {
            try {
                String url = "http://localhost:8080/Gradle___org_example___web_1_0_SNAPSHOT_war/api/performances";
                restTemplate.delete(url + "/{id}", id);
                return "Performance successfully deleted";
            } catch (ResourceAccessException resourceAccessException) {
                return "Inaccessible server";
            }
        }, executorService);
    }

    public CompletableFuture<String> updatePerformance(PerformanceDto performanceDto) {
        logger.trace("updatePerformance - method entered and returned a completable future");
        return CompletableFuture.supplyAsync(() -> {
            try {
                String url = "http://localhost:8080/Gradle___org_example___web_1_0_SNAPSHOT_war/api/performances";
                performanceDto.setId(performanceDto.getId());
                restTemplate.put(url, performanceDto);
                return "Performance successfully updated";
            } catch (ResourceAccessException resourceAccessException) {
                return "Inaccessible server";
            }
        }, executorService);
    }
}