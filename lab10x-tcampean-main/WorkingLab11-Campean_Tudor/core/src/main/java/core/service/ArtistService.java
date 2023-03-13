package core.service;

import core.domain.Artist;
import core.dto.ArtistDto;

import java.util.List;
import java.util.Set;

public interface ArtistService {
    Set<ArtistDto> getArtists();

    ArtistDto saveArtist(ArtistDto artist);

    ArtistDto updateArtist(ArtistDto artist);

    void deleteArtist(Long id);

    public ArtistDto findById(Long id);

    public ArtistDto stat();
}