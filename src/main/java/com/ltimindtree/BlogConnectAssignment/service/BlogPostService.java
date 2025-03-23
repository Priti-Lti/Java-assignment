package com.ltimindtree.BlogConnectAssignment.service;

import com.ltimindtree.BlogConnectAssignment.entity.BlogPost;
import com.ltimindtree.BlogConnectAssignment.entity.User;
import com.ltimindtree.BlogConnectAssignment.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogPostService {

    @Autowired
    private BlogPostRepository blogPostRepository;

    public BlogPost createBlogPost(BlogPost blogPost) {
        return blogPostRepository.save(blogPost);
    }

    public List<BlogPost> getAllBlogPosts() {
        return blogPostRepository.findAll();
    }

    public List<BlogPost> getBlogPostsByUser(User user) {
        return blogPostRepository.findByUser(user);
    }
}
