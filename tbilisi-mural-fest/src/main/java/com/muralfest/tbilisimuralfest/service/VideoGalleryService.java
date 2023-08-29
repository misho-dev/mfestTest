package com.muralfest.tbilisimuralfest.service;

import com.muralfest.tbilisimuralfest.model.VideoGallery;

import java.util.List;
import java.util.Optional;

public interface VideoGalleryService {
    VideoGallery saveVideo(VideoGallery video);
    Optional<VideoGallery> getVideoById(Long id);
    List<VideoGallery> getAllVideos();
    void deleteVideo(Long id);
}
