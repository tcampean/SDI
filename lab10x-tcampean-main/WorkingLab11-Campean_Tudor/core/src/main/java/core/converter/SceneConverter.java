package core.converter;

import core.domain.Artist;
import core.domain.Scene;
import core.dto.ArtistDto;
import core.dto.SceneDto;
import org.springframework.stereotype.Component;

@Component
public class SceneConverter extends BaseConverter<Scene, SceneDto> {
    @Override
    public Scene convertDtoToModel(SceneDto dto) {
        var model = new Scene();
        model.setId(dto.getId());
        model.setScenename(dto.getScenename());
        return model;
    }

    @Override
    public SceneDto convertModelToDto(Scene scene) {
        SceneDto dto = new SceneDto(scene.getScenename());
        dto.setId(scene.getId());
        return dto;
    }
}