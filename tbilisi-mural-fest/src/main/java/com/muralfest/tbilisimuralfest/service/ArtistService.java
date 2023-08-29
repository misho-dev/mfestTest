package com.muralfest.tbilisimuralfest.service;

import com.muralfest.tbilisimuralfest.model.Artist;

import java.util.List;
import java.util.Optional;
public interface ArtistService {
    Artist saveArtist(Artist artist);
    Optional<Artist> getArtistById(Long id);
    List<Artist> getAllArtists();
    List<Artist> findArtistsByName(String name);
    List<Artist> findArtistsByProjectName(String projectName);
    List<Artist> findArtistsByShortBioKeyword(String keyword);
    void deleteArtist(Long id);
}
