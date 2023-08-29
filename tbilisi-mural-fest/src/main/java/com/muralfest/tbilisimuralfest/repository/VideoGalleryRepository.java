package com.muralfest.tbilisimuralfest.repository;

import com.muralfest.tbilisimuralfest.model.VideoGallery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoGalleryRepository extends JpaRepository<VideoGallery, Long> {
    // Additional custom queries (if needed) can be defined here
}