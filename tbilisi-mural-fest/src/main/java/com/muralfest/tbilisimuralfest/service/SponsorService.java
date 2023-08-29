package com.muralfest.tbilisimuralfest.service;

import com.muralfest.tbilisimuralfest.model.Sponsor;

import java.util.List;
import java.util.Optional;

public interface SponsorService {
    Sponsor saveSponsor(Sponsor sponsor);
    Optional<Sponsor> getSponsorById(Long id);
    List<Sponsor> getAllSponsors();
    void deleteSponsor(Long id);
}
