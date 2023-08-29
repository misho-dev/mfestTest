package com.muralfest.tbilisimuralfest.service;

import com.muralfest.tbilisimuralfest.model.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    Project saveProject(Project project);
    Optional<Project> getProjectById(Long id);
    List<Project> getAllProjects();
    void deleteProject(Long id);
}
