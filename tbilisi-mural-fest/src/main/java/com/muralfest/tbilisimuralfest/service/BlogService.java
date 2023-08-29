package com.muralfest.tbilisimuralfest.service;

import com.muralfest.tbilisimuralfest.model.Blog;

import java.util.List;
import java.util.Optional;

public interface BlogService {
    Blog saveBlog(Blog blog);
    Optional<Blog> getBlogById(Long id);
    List<Blog> getAllBlogs();
    void deleteBlog(Long id);
}
