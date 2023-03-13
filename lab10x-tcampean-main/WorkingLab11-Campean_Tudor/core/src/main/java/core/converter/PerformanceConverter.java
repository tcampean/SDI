package core.converter;

import core.domain.Performance;
import core.domain.Scene;
import core.dto.PerformanceDto;
import core.dto.SceneDto;
import org.springframework.stereotype.Component;

@Component
public class PerformanceConverter extends BaseConverter<Performance, PerformanceDto>{
    @Override
    public Performance convertDtoToModel(PerformanceDto dto) {
        var model = new Performance();
        model.setId(dto.getId());
        model.setArtistid(dto.getArtistid());
        model.setDayid(dto.getDayid());
        model.setEndingtime(dto.getEndingtime());
        model.setStartingtime(dto.getStartingtime());
        return model;
    }

    @Override
    public PerformanceDto convertModelToDto(Performance performance) {
        PerformanceDto dto = new PerformanceDto(performance.getArtistid(),performance.getDayid(), performance.getStartingtime(), performance.getEndingtime());
        dto.setId(performance.getId());
        return dto;
    }
}
