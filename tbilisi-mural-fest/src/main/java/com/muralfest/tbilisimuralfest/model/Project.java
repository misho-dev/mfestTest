package com.muralfest.tbilisimuralfest.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(length = 2000)
    private String description;

    @ElementCollection
    private List<String> imageGallery;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;

    public Project() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getImageGallery() {
        return imageGallery;
    }

    public void setImageGallery(List<String> imageGallery) {
        this.imageGallery = imageGallery;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}
