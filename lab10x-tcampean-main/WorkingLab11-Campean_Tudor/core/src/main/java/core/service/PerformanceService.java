package core.service;

import core.domain.Performance;
import core.dto.ArtistDto;
import core.dto.PerformanceDto;

import java.util.Set;

public interface PerformanceService {

    Set<PerformanceDto> getPerformances();

    PerformanceDto savePerformance(PerformanceDto performance);

    PerformanceDto updatePerformance(PerformanceDto performance);

    void deletePerformance(Long id);

    public PerformanceDto findById(Long id);
}
