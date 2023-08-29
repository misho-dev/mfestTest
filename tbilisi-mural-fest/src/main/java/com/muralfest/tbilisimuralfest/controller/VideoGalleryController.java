package com.muralfest.tbilisimuralfest.controller;

import com.muralfest.tbilisimuralfest.model.VideoGallery;
import com.muralfest.tbilisimuralfest.service.VideoGalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/videos")
@CrossOrigin(origins = "http://localhost:3000")
public class VideoGalleryController {

    private final VideoGalleryService videoGalleryService;

    @Autowired
    public VideoGalleryController(VideoGalleryService videoGalleryService) {
        this.videoGalleryService = videoGalleryService;
    }

    @GetMapping
    public List<VideoGallery> getAllVideos() {
        return videoGalleryService.getAllVideos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VideoGallery> getVideoById(@PathVariable Long id) {
        return videoGalleryService.getVideoById(id)
                .map(video -> ResponseEntity.ok(video))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public VideoGallery createVideo(@RequestBody VideoGallery video) {
        return videoGalleryService.saveVideo(video);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VideoGallery> updateVideo(@PathVariable Long id, @RequestBody VideoGallery videoDetails) {
        return videoGalleryService.getVideoById(id).map(video -> {
            video.setThumbnail(videoDetails.getThumbnail());
            video.setYoutubeLink(videoDetails.getYoutubeLink());
            VideoGallery updatedVideo = videoGalleryService.saveVideo(video);
            return ResponseEntity.ok(updatedVideo);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVideo(@PathVariable Long id) {
        Optional<VideoGallery> videoOptional = videoGalleryService.getVideoById(id);
        if (videoOptional.isPresent()) {
            videoGalleryService.deleteVideo(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}