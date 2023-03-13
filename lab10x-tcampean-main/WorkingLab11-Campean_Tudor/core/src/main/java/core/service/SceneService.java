package core.service;

import core.dto.ArtistDto;
import core.dto.SceneDto;

import java.util.Set;

public interface SceneService {

    Set<SceneDto> getScenes();

    SceneDto saveScene(SceneDto scene);

    SceneDto updateScene(SceneDto scene);

    void deleteScene(Long id);

    public SceneDto findById(Long id);

}
