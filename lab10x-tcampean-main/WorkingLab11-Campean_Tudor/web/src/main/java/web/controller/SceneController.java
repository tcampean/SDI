package web.controller;

import core.converter.ArtistConverter;
import core.converter.SceneConverter;
import core.dto.ArtistDto;
import core.dto.SceneDto;
import core.service.ArtistService;
import core.service.SceneService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class SceneController {
    public static final Logger logger = LoggerFactory.getLogger(SceneController.class);
    private final SceneService sceneService;
    private final SceneConverter sceneConverter;

    @Autowired
    public SceneController(SceneService sceneService, SceneConverter sceneConverter) {
        this.sceneService = sceneService;
        this.sceneConverter = sceneConverter;
    }

    @RequestMapping(value = "/scenes")
    Set<SceneDto> getScenes() {
        logger.trace("getScenes - method entered");
        var scenes = sceneService.getScenes();
        logger.trace("getScenes - method returned as set of dtos");
        return scenes;
    }


    @RequestMapping(value = "/scenes", method = RequestMethod.POST)
    SceneDto addScene(@RequestBody SceneDto sceneDto) {
        logger.trace("addScene - method entered");
        sceneService.saveScene(sceneDto);
        logger.trace("addScene - method added scene and returned an instance of it");
        return sceneDto;
    }

    @RequestMapping(value = "/scenes", method = RequestMethod.PUT)
    SceneDto updateScene(@RequestBody SceneDto dto) {
        logger.trace("updateScene - method entered");
        sceneService.updateScene(dto);
        logger.trace("updateScene - method updated scene and returned an instance of it");
        return dto;
    }

    @RequestMapping(value = "/scenes/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteScene(@PathVariable Long id) {
        logger.trace("deleteScene - method entered");
        sceneService.deleteScene(id);
        logger.trace("deleteScene - method deleted scene and returned a response");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}