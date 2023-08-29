package com.muralfest.tbilisimuralfest.service.impl;

import com.muralfest.tbilisimuralfest.model.Artist;
import com.muralfest.tbilisimuralfest.repository.ArtistRepository;
import com.muralfest.tbilisimuralfest.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistServiceImpl implements ArtistService{
    private final ArtistRepository artistRepository;

    @Autowired
    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public Artist saveArtist(Artist artist) {
        return artistRepository.save(artist);
    }

    @Override
    public Optional<Artist> getArtistById(Long id) {
        return artistRepository.findById(id);
    }

    @Override
    public List<Artist> getAllArtists() {
        return artistRepository.findAll();
    }

    @Override
    public List<Artist> findArtistsByName(String name) {
        return artistRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public List<Artist> findArtistsByProjectName(String projectName) {
        return artistRepository.findByProjectName(projectName);
    }

    @Override
    public List<Artist> findArtistsByShortBioKeyword(String keyword) {
        return artistRepository.findByShortBioContainingIgnoreCase(keyword);
    }

    @Override
    public void deleteArtist(Long id) {
        artistRepository.deleteById(id);
    }
}
