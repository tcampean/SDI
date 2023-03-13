package client.controller;

import core.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import core.dto.*;

import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@Service
public class ArtistController {
    public static final Logger logger = LoggerFactory.getLogger(ArtistController.class);
    private final ExecutorService executorService;
    private final RestTemplate restTemplate;

    @Autowired
    public ArtistController(ExecutorService executorService, RestTemplate restTemplate) {
        this.executorService = executorService;
        this.restTemplate = restTemplate;
    }

    public CompletableFuture<Iterable<ArtistDto>> getArtistsFromRepository() {
        logger.trace("getArtistsFromRepository - method entered and returned a completable future");
        return CompletableFuture.supplyAsync(() -> {
            String url = "http://localhost:8080/Gradle___org_example___web_1_0_SNAPSHOT_war/api/artists";
            Set<ArtistDto> scenes = restTemplate.getForObject(url, Set.class);
            return scenes;
        }, executorService);
    }

    public CompletableFuture<String> addArtist(ArtistDto artistDto) {
        logger.trace("addArtist - method entered and returned a completable future");
        return CompletableFuture.supplyAsync(() -> {
            try {
                String url = "http://localhost:8080/Gradle___org_example___web_1_0_SNAPSHOT_war/api/artists";
                restTemplate.postForObject(url, artistDto, ArtistDto.class);
                return "Artist added";
            } catch (ResourceAccessException resourceAccessException) {
                return "Inaccessible server";
            }
        }, executorService);
    }

    public CompletableFuture<String> deleteArtist(Long id) {
        logger.trace("deleteArtist - method entered and returned a completable future");
        return CompletableFuture.supplyAsync(() -> {
            try {
                String url = "http://localhost:8080/Gradle___org_example___web_1_0_SNAPSHOT_war/api/artists";
                restTemplate.delete(url + "/{id}", id);
                return "Artist successfully deleted";
            } catch (ResourceAccessException resourceAccessException) {
                return "Inaccessible server";
            }
        }, executorService);
    }

    public CompletableFuture<String> updateArtist(ArtistDto artistDto) {
        logger.trace("updateArtist - method entered and returned a completable future");
        return CompletableFuture.supplyAsync(() -> {
            try {
                String url = "http://localhost:8080/Gradle___org_example___web_1_0_SNAPSHOT_war/api/artists";
                restTemplate.put(url, artistDto);
                return "Artist successfully updated";
            } catch (ResourceAccessException resourceAccessException) {
                return "Inaccessible server";
            }
        }, executorService);
    }

    public CompletableFuture<ArtistDto> getStat() {
        logger.trace("getArtistsFromRepository - method entered and returned a completable future");
        return CompletableFuture.supplyAsync(() -> {
            String url = "http://localhost:8080/Gradle___org_example___web_1_0_SNAPSHOT_war/api/artists/stat";
            ArtistDto scenes = restTemplate.getForObject(url, ArtistDto.class);
            return scenes;
        }, executorService);
    }
}