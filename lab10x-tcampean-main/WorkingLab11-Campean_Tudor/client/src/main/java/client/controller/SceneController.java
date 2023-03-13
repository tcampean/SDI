package client.controller;

import core.domain.Artist;
import core.dto.ArtistDto;
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
public class SceneController {
    public static final Logger logger = LoggerFactory.getLogger(SceneController.class);
    private final ExecutorService executorService;
    private final RestTemplate restTemplate;

    @Autowired
    public SceneController(ExecutorService executorService, RestTemplate restTemplate) {
        this.executorService = executorService;
        this.restTemplate = restTemplate;
    }

    public CompletableFuture<Iterable<SceneDto>> getScenesFromRepository() {
        logger.trace("getScenesFromRepository - method entered and returned a completable future");
        return CompletableFuture.supplyAsync(() -> {
            String url = "http://localhost:8080/Gradle___org_example___web_1_0_SNAPSHOT_war/api/scenes";
            Set<SceneDto> scenes = restTemplate.getForObject(url, Set.class);
            return scenes;
        }, executorService);
    }

    public CompletableFuture<String> addScene(SceneDto sceneDto) {
        logger.trace("addScene - method entered and returned a completable future");
        return CompletableFuture.supplyAsync(() -> {
            try {
                String url = "http://localhost:8080/Gradle___org_example___web_1_0_SNAPSHOT_war/api/scenes";
                restTemplate.postForObject(url, sceneDto, SceneDto.class);
                return "Scene added";
            } catch (ResourceAccessException resourceAccessException) {
                return "Inaccessible server";
            }
        }, executorService);
    }

    public CompletableFuture<String> deleteScene(Long id) {
        logger.trace("deleteScene - method entered and returned a completable future");
        return CompletableFuture.supplyAsync(() -> {
            try {
                String url = "http://localhost:8080/Gradle___org_example___web_1_0_SNAPSHOT_war/api/scenes";
                restTemplate.delete(url + "/{id}", id);
                return "Scene successfully deleted";
            } catch (ResourceAccessException resourceAccessException) {
                return "Inaccessible server";
            }
        }, executorService);
    }

    public CompletableFuture<String> updateScene(SceneDto sceneDto) {
        logger.trace("updateScene - method entered and returned a completable future");
        return CompletableFuture.supplyAsync(() -> {
            try {
                String url = "http://localhost:8080/Gradle___org_example___web_1_0_SNAPSHOT_war/api/scenes";
                sceneDto.setId(sceneDto.getId());
                restTemplate.put(url, sceneDto);
                return "Scene successfully updated";
            } catch (ResourceAccessException resourceAccessException) {
                return "Inaccessible server";
            }
        }, executorService);
    }
}