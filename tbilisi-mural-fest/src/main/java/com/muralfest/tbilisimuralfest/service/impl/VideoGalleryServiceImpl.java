package com.muralfest.tbilisimuralfest.service.impl;

import com.muralfest.tbilisimuralfest.model.VideoGallery;
import com.muralfest.tbilisimuralfest.repository.VideoGalleryRepository;
import com.muralfest.tbilisimuralfest.service.VideoGalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoGalleryServiceImpl implements VideoGalleryService {
    private final VideoGalleryRepository videoGalleryRepository;

    @Autowired
    public VideoGalleryServiceImpl(VideoGalleryRepository videoGalleryRepository) {
        this.videoGalleryRepository = videoGalleryRepository;
    }

    @Override
    public VideoGallery saveVideo(VideoGallery video) {
        return videoGalleryRepository.save(video);
    }

    @Override
    public Optional<VideoGallery> getVideoById(Long id) {
        return videoGalleryRepository.findById(id);
    }

    @Override
    public List<VideoGallery> getAllVideos() {
        return videoGalleryRepository.findAll();
    }

    @Override
    public void deleteVideo(Long id) {
        videoGalleryRepository.deleteById(id);
    }
}
