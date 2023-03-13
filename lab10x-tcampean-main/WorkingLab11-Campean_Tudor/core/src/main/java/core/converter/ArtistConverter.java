package core.converter;

import core.domain.Artist;
import core.dto.ArtistDto;
import org.springframework.stereotype.Component;

@Component
public class ArtistConverter extends BaseConverter<Artist, ArtistDto> {
    @Override
    public Artist convertDtoToModel(ArtistDto dto) {
        var model = new Artist();
        model.setId(dto.getId());
        model.setName(dto.getName());
        model.setDateofbirth(dto.getDateofbirth());
        model.setGenre(dto.getGenre());
        return model;
    }

    @Override
    public ArtistDto convertModelToDto(Artist artist) {
        ArtistDto dto = new ArtistDto(artist.getName(), artist.getDateofbirth(), artist.getGenre());
        dto.setId(artist.getId());
        return dto;
    }
}