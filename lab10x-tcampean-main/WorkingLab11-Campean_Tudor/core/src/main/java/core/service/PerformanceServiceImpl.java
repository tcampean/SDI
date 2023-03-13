package core.service;

import core.converter.PerformanceConverter;
import core.converter.SceneConverter;
import core.domain.Performance;
import core.dto.PerformanceDto;
import core.dto.SceneDto;
import core.repository.PerformanceRepository;
import core.repository.SceneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class PerformanceServiceImpl implements PerformanceService{
    private PerformanceRepository performanceRepository;
    private PerformanceConverter performanceConverter;

    @Autowired
    public PerformanceServiceImpl(PerformanceRepository performanceRepository, PerformanceConverter performanceConverter)
    {
        this.performanceRepository = performanceRepository;
        this.performanceConverter = performanceConverter;
    }

    @Override
    public Set<PerformanceDto> getPerformances() {
        var performances = performanceRepository.findAll();
        return performanceConverter.convertModelsToDtos(performances);
    }

    @Override
    public PerformanceDto savePerformance(PerformanceDto performance) {
        var entity = performanceConverter.convertDtoToModel(performance);
        var createdEntity = performanceRepository.save(entity);
        return performanceConverter.convertModelToDto(createdEntity);
    }

    @Override
    @Transactional
    public PerformanceDto updatePerformance(PerformanceDto performance) {
        var updatedPerformance = performanceRepository.findById(performance.getId()).orElseThrow();
        updatedPerformance.setStartingtime(performance.getStartingtime());
        updatedPerformance.setEndingtime(performance.getEndingtime());
        performanceRepository.save(updatedPerformance);
        return performance;
    }

    @Override
    public void deletePerformance(Long id) {
        performanceRepository.deleteById(id);
    }


    @Override
    public PerformanceDto findById(Long id) {
        var entity = performanceRepository.findById(id).orElseThrow();
        return performanceConverter.convertModelToDto(entity);
    }
}
