package com.muralfest.tbilisimuralfest.repository;

import com.muralfest.tbilisimuralfest.model.Sponsor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SponsorRepository extends JpaRepository<Sponsor, Long> {
    // Additional custom queries (if needed) can be defined here
}