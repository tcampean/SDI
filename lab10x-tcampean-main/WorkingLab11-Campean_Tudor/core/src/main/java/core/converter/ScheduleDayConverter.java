package core.converter;

import core.domain.Artist;
import core.domain.ScheduleDay;
import core.dto.ArtistDto;
import core.dto.ScheduleDayDto;
import org.springframework.stereotype.Component;

@Component
public class ScheduleDayConverter extends BaseConverter<ScheduleDay, ScheduleDayDto> {
    @Override
    public ScheduleDay convertDtoToModel(ScheduleDayDto dto) {
        var model = new ScheduleDay();
        model.setId(dto.getId());
        model.setNrofparticipants(dto.getNrofparticipants());
        model.setSceneid(dto.getSceneid());
        model.setDate(dto.getDate());
        return model;
    }

    @Override
    public ScheduleDayDto convertModelToDto(ScheduleDay day) {
        ScheduleDayDto dto = new ScheduleDayDto(day.getDate(), day.getSceneid(), day.getNrofparticipants());
        dto.setId(day.getId());
        return dto;
    }
}