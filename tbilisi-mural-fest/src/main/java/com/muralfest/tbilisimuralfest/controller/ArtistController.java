package com.muralfest.tbilisimuralfest.controller;

import com.muralfest.tbilisimuralfest.model.Artist;
import com.muralfest.tbilisimuralfest.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/artists")
@CrossOrigin(origins = "*")
public class ArtistController {
    private final ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping
    public List<Artist> getAllArtists() {
        return artistService.getAllArtists();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Artist> getArtistById(@PathVariable Long id) {
        return artistService.getArtistById(id)
                .map(artist -> ResponseEntity.ok(artist))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Artist createArtist(@RequestBody Artist artist) {
        return artistService.saveArtist(artist);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Artist> updateArtist(@PathVariable Long id, @RequestBody Artist artistDetails) {
        return artistService.getArtistById(id).map(artist -> {
            artist.setName(artistDetails.getName());
            artist.setShortBio(artistDetails.getShortBio());
            artist.setLongBio(artistDetails.getLongBio());
            artist.setProfilePicture(artistDetails.getProfilePicture());
            Artist updatedArtist = artistService.saveArtist(artist);
            return ResponseEntity.ok(updatedArtist);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArtist(@PathVariable Long id) {
        Optional<Artist> artistOptional = artistService.getArtistById(id);
        if (artistOptional.isPresent()) {
            artistService.deleteArtist(id);
            return ResponseEntity.noContent().build();  // This signifies a successful operation with no content in response
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
