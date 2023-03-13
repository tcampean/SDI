package core.service;

import core.converter.ArtistConverter;
import core.domain.Artist;
import core.domain.Performance;
import core.dto.ArtistDto;
import core.dto.PerformanceDto;
import core.repository.ArtistRepository;
import core.repository.PerformanceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class ArtistServiceImpl implements  ArtistService{

    public static final Logger logger = LoggerFactory.getLogger(ArtistServiceImpl.class);
    private ArtistRepository artistRepository;
    private ArtistConverter artistConverter;
    private PerformanceRepository performanceRepository;

    @Autowired
    public ArtistServiceImpl(ArtistRepository artistRepository, ArtistConverter artistConverter, PerformanceRepository performanceService)
    {
        this.artistRepository = artistRepository;
        this.artistConverter = artistConverter;
        this.performanceRepository = performanceService;
    }

    @Override
    public Set<ArtistDto> getArtists() {
        logger.trace("getArtists - method entered");
        var artists = artistRepository.findAll();
        logger.trace("getArtists - method returned");
        return artistConverter.convertModelsToDtos(artists);
    }

    @Override
    public ArtistDto saveArtist(ArtistDto artist) {
        logger.trace("saveArtists - method entered");
        var entity = artistConverter.convertDtoToModel(artist);
        var createdEntity = artistRepository.save(entity);
        logger.trace("getArtists - method returned");
        return artistConverter.convertModelToDto(createdEntity);
    }

    @Override
    @Transactional
    public ArtistDto updateArtist(ArtistDto artist) {
        logger.trace("updateArtists - method entered");
        var updatedArtist = artistRepository.findById(artist.getId()).orElseThrow();
        updatedArtist.setGenre(artist.getGenre());
        updatedArtist.setName(artist.getName());
        updatedArtist.setDateofbirth(artist.getDateofbirth());
        artistRepository.save(updatedArtist);
        logger.trace("updateArtists - method entered");
        return artist;
    }

    @Override
    public void deleteArtist(Long id) {

        logger.trace("deleteArtists - method entered");
        artistRepository.deleteById(id);
        logger.trace("deleteArtists - method finished");
    }


    @Override
    public ArtistDto findById(Long id) {
        logger.trace("findArtists - method entered");
        var entity = artistRepository.findById(id).orElseThrow();
        logger.trace("findArtists - method returned");
        return artistConverter.convertModelToDto(entity);
    }

    @Override
    public ArtistDto stat()
    {
        List<Artist> artists = artistRepository.findAll();
        List<Performance> performances = performanceRepository.findAll();
        Artist resultArtist = null;

        Integer countMax = 0;

        for(Artist artist : artists)
        {
            Integer currentCount = 0;

            for(Performance performance: performances)
                if(performance.getArtistid() == artist.getId())
                {
                    currentCount++;
                }
            if(currentCount > countMax) {
                resultArtist = artist;
                countMax = currentCount;
            }

        }
        return artistConverter.convertModelToDto(resultArtist);
    }


}

