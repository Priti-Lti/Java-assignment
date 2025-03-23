package com.ltimindtree.BlogConnectAssignment.controller;

import com.ltimindtree.BlogConnectAssignment.entity.BlogPost;
import com.ltimindtree.BlogConnectAssignment.entity.User;
import com.ltimindtree.BlogConnectAssignment.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blogposts")
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;


    @PostMapping
    public BlogPost createBlogPost(@RequestBody BlogPost blogPost, @AuthenticationPrincipal UserDetails userDetails) {
        User user = new User();
        user.setUsername(userDetails.getUsername());
        blogPost.setUser(user);
        return blogPostService.createBlogPost(blogPost);
    }

    @GetMapping
    public List<BlogPost> getAllBlogPosts() {
        return blogPostService.getAllBlogPosts();
    }

    @GetMapping("/my")
    public List<BlogPost> getMyBlogPosts(@AuthenticationPrincipal UserDetails userDetails) {
        User user = new User();
        user.setUsername(userDetails.getUsername());
        return blogPostService.getBlogPostsByUser(user);
    }

}