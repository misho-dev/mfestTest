package com.muralfest.tbilisimuralfest.service.impl;

import com.muralfest.tbilisimuralfest.model.Project;
import com.muralfest.tbilisimuralfest.repository.ProjectRepository;
import com.muralfest.tbilisimuralfest.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Optional<Project> getProjectById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}
