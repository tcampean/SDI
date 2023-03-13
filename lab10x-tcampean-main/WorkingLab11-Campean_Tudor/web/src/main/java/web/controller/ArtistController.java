package web.controller;

import core.domain.Artist;
import core.dto.*;
import core.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import core.converter.*;

import java.util.List;
import java.util.Set;

@RestController
public class ArtistController {
    public static final Logger logger = LoggerFactory.getLogger(ArtistController.class);
    private final ArtistService artistService;
    private final ArtistConverter artistConverter;

    @Autowired
    public ArtistController(ArtistService artistService, ArtistConverter artistConverter) {
        this.artistService = artistService;
        this.artistConverter = artistConverter;
    }

    @RequestMapping(value = "/artists")
    Set<ArtistDto> getArtists() {
        logger.trace("getArtists - method entered");
        var artists = artistService.getArtists();
        logger.trace("getArtists - method returned a dto as a set of dtos");
        return artists;
    }

    @RequestMapping(value = "/artists", method = RequestMethod.POST)
    ArtistDto addArtist(@RequestBody ArtistDto artistDto) {
        logger.trace("addArtist - method entered");
        artistService.saveArtist(artistDto);
        logger.trace("addArtist - method added artist and returned an instance of it");
        return artistDto;
    }

    @RequestMapping(value = "/artists", method = RequestMethod.PUT)
    ArtistDto updateArtist(@RequestBody ArtistDto dto) {
        logger.trace("updateArtist - method entered");
        artistService.updateArtist(dto);
        logger.trace("updateArtist - method updated artist and returned an instance of it");
        return dto;
    }

    @RequestMapping(value = "/artists/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteArtist(@PathVariable Long id) {
        logger.trace("deleteArtist - method entered");
        artistService.deleteArtist(id);
        logger.trace("deleteArtist - method deleted artist and returned a response");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/artists/stat", method = RequestMethod.GET)
    ArtistDto getArtistStat() {
        logger.trace("getArtists - method entered");
        var artists = artistService.stat();
        logger.trace("getArtists - method returned a dto as a set of dtos");
        return artists;
    }
}