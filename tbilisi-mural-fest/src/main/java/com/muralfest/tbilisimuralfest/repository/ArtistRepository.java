package com.muralfest.tbilisimuralfest.repository;

import com.muralfest.tbilisimuralfest.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {
    List<Artist> findByNameContainingIgnoreCase(String name);

    // Find artists with a specific project (based on project name)
    @Query("SELECT a FROM Artist a JOIN a.projects p WHERE p.name = ?1")
    List<Artist> findByProjectName(String projectName);

    // Find artists with a short bio containing a specific keyword
    List<Artist> findByShortBioContainingIgnoreCase(String keyword);
}
