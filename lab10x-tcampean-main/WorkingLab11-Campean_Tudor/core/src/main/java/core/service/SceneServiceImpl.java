package core.service;

import core.converter.ArtistConverter;
import core.converter.SceneConverter;
import core.dto.ArtistDto;
import core.dto.SceneDto;
import core.repository.ArtistRepository;
import core.repository.SceneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class SceneServiceImpl implements SceneService{

    private SceneRepository sceneRepository;
    private SceneConverter sceneConverter;

    @Autowired
    public SceneServiceImpl(SceneRepository sceneRepository, SceneConverter sceneConverter)
    {
        this.sceneRepository = sceneRepository;
        this.sceneConverter = sceneConverter;
    }

    @Override
    public Set<SceneDto> getScenes() {
        var scenes = sceneRepository.findAll();
        return sceneConverter.convertModelsToDtos(scenes);
    }

    @Override
    public SceneDto saveScene(SceneDto scene) {
        var entity = sceneConverter.convertDtoToModel(scene);
        var createdEntity = sceneRepository.save(entity);
        return sceneConverter.convertModelToDto(createdEntity);
    }

    @Override
    @Transactional
    public SceneDto updateScene(SceneDto scene) {
        var updatedScene = sceneRepository.findById(scene.getId()).orElseThrow();
        updatedScene.setScenename(scene.getScenename());
        sceneRepository.save(updatedScene);
        return scene;
    }

    @Override
    public void deleteScene(Long id) {
        sceneRepository.deleteById(id);
    }


    @Override
    public SceneDto findById(Long id) {
        var entity = sceneRepository.findById(id).orElseThrow();
        return sceneConverter.convertModelToDto(entity);
    }
}
