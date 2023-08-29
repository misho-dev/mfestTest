package com.muralfest.tbilisimuralfest.repository;

import com.muralfest.tbilisimuralfest.model.Artist;
import com.muralfest.tbilisimuralfest.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    // Find artists by name

}