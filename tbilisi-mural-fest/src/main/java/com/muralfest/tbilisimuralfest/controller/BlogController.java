package com.muralfest.tbilisimuralfest.controller;

import com.muralfest.tbilisimuralfest.model.Blog;
import com.muralfest.tbilisimuralfest.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/blogs")
@CrossOrigin(origins = "http://localhost:3000")
public class BlogController {

    private final BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping
    public List<Blog> getAllBlogs() {
        return blogService.getAllBlogs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable Long id) {
        return blogService.getBlogById(id)
                .map(blog -> ResponseEntity.ok(blog))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Blog createBlog(@RequestBody Blog blog) {
        return blogService.saveBlog(blog);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable Long id, @RequestBody Blog blogDetails) {
        return blogService.getBlogById(id).map(blog -> {
            blog.setArticleName(blogDetails.getArticleName());
            blog.setHtmlContent(blogDetails.getHtmlContent());
            blog.setThumbnail(blogDetails.getThumbnail());
            blog.setAuthor(blogDetails.getAuthor());
            Blog updatedBlog = blogService.saveBlog(blog);
            return ResponseEntity.ok(updatedBlog);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlog(@PathVariable Long id) {
        Optional<Blog> blogOptional = blogService.getBlogById(id);
        if (blogOptional.isPresent()) {
            blogService.deleteBlog(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}