package com.ltimindtree.BlogConnectAssignment.service;

import com.ltimindtree.BlogConnectAssignment.entity.BlogPost;
import com.ltimindtree.BlogConnectAssignment.entity.Comment;
import com.ltimindtree.BlogConnectAssignment.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;


    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public List<Comment> getCommentsByBlogPost(BlogPost blogPost) {
        return commentRepository.findByBlogPost(blogPost);
    }
}
