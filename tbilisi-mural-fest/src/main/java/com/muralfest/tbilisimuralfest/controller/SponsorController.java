package com.muralfest.tbilisimuralfest.controller;

import com.muralfest.tbilisimuralfest.model.Sponsor;
import com.muralfest.tbilisimuralfest.service.SponsorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sponsors")
@CrossOrigin(origins = "http://localhost:3000")
public class SponsorController {

    private final SponsorService sponsorService;

    @Autowired
    public SponsorController(SponsorService sponsorService) {
        this.sponsorService = sponsorService;
    }

    @GetMapping
    public List<Sponsor> getAllSponsors() {
        return sponsorService.getAllSponsors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sponsor> getSponsorById(@PathVariable Long id) {
        return sponsorService.getSponsorById(id)
                .map(sponsor -> ResponseEntity.ok(sponsor))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Sponsor createSponsor(@RequestBody Sponsor sponsor) {
        return sponsorService.saveSponsor(sponsor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sponsor> updateSponsor(@PathVariable Long id, @RequestBody Sponsor sponsorDetails) {
        return sponsorService.getSponsorById(id).map(sponsor -> {
            sponsor.setName(sponsorDetails.getName());
            sponsor.setLogo(sponsorDetails.getLogo());
            sponsor.setActive(sponsorDetails.getActive());
            Sponsor updatedSponsor = sponsorService.saveSponsor(sponsor);
            return ResponseEntity.ok(updatedSponsor);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSponsor(@PathVariable Long id) {
        Optional<Sponsor> sponsorOptional = sponsorService.getSponsorById(id);
        if (sponsorOptional.isPresent()) {
            sponsorService.deleteSponsor(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
