package core.service;

import core.converter.ArtistConverter;
import core.converter.ScheduleDayConverter;
import core.domain.ScheduleDay;
import core.dto.ArtistDto;
import core.dto.ScheduleDayDto;
import core.repository.ArtistRepository;
import core.repository.ScheduleDayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class ScheduleDayServiceImpl implements ScheduleDayService{

    private ScheduleDayRepository scheduleDayRepository;
    private ScheduleDayConverter scheduleDayConverter;

    @Autowired
    public ScheduleDayServiceImpl(ScheduleDayRepository scheduleDayRepository, ScheduleDayConverter dayConverter)
    {
        this.scheduleDayRepository = scheduleDayRepository;
        this.scheduleDayConverter = dayConverter;
    }

    @Override
    public Set<ScheduleDayDto> getScheduleDays() {
        var days = scheduleDayRepository.findAll();
        return scheduleDayConverter.convertModelsToDtos(days);
    }

    @Override
    public ScheduleDayDto saveScheduleDay(ScheduleDayDto day) {
        var entity = scheduleDayConverter.convertDtoToModel(day);
        var createdEntity = scheduleDayRepository.save(entity);
        return scheduleDayConverter.convertModelToDto(createdEntity);
    }

    @Override
    @Transactional
    public ScheduleDayDto updateScheduleDay(ScheduleDayDto day) {
        var updatedDay = scheduleDayRepository.findById(day.getId()).orElseThrow();
        updatedDay.setDate(day.getDate());
        updatedDay.setNrofparticipants(day.getNrofparticipants());
        scheduleDayRepository.save(updatedDay);
        return day;
    }

    @Override
    public void deleteScheduleDay(Long id) {
        scheduleDayRepository.deleteById(id);
    }


    @Override
    public ScheduleDayDto findById(Long id) {
        var entity = scheduleDayRepository.findById(id).orElseThrow();
        return scheduleDayConverter.convertModelToDto(entity);
    }
}

