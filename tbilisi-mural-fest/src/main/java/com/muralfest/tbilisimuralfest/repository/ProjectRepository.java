package com.muralfest.tbilisimuralfest.repository;

import com.muralfest.tbilisimuralfest.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    // Additional custom queries (if needed) can be defined here
}
