package com.muralfest.tbilisimuralfest.service.impl;

import com.muralfest.tbilisimuralfest.model.Sponsor;
import com.muralfest.tbilisimuralfest.repository.SponsorRepository;
import com.muralfest.tbilisimuralfest.service.SponsorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SponsorServiceImpl implements SponsorService {
    private final SponsorRepository sponsorRepository;

    @Autowired
    public SponsorServiceImpl(SponsorRepository sponsorRepository) {
        this.sponsorRepository = sponsorRepository;
    }

    @Override
    public Sponsor saveSponsor(Sponsor sponsor) {
        return sponsorRepository.save(sponsor);
    }

    @Override
    public Optional<Sponsor> getSponsorById(Long id) {
        return sponsorRepository.findById(id);
    }

    @Override
    public List<Sponsor> getAllSponsors() {
        return sponsorRepository.findAll();
    }

    @Override
    public void deleteSponsor(Long id) {
        sponsorRepository.deleteById(id);
    }
}
