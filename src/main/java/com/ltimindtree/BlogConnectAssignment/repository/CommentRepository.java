package com.ltimindtree.BlogConnectAssignment.repository;

import com.ltimindtree.BlogConnectAssignment.entity.BlogPost;
import com.ltimindtree.BlogConnectAssignment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByBlogPost(BlogPost blogPost);
}
