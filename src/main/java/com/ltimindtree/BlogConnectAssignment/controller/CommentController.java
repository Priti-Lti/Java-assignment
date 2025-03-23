package com.ltimindtree.BlogConnectAssignment.controller;

import com.ltimindtree.BlogConnectAssignment.entity.BlogPost;
import com.ltimindtree.BlogConnectAssignment.entity.Comment;
import com.ltimindtree.BlogConnectAssignment.entity.User;
import com.ltimindtree.BlogConnectAssignment.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public Comment createComment(@RequestBody Comment comment, @AuthenticationPrincipal UserDetails userDetails) {
        User user = new User();
        user.setUsername(userDetails.getUsername());
        comment.setUser(user);
        return commentService.createComment(comment);
    }

    @GetMapping("/blogpost/{blogPostId}")
    public List<Comment> getCommentsByBlogPost(@PathVariable Long blogPostId) {
        BlogPost blogPost = new BlogPost();
        blogPost.setId(blogPostId);
        return commentService.getCommentsByBlogPost(blogPost);
    }

}
