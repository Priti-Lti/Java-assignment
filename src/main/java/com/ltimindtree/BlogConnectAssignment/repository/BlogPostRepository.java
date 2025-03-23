package com.ltimindtree.BlogConnectAssignment.repository;

import com.ltimindtree.BlogConnectAssignment.entity.BlogPost;
import com.ltimindtree.BlogConnectAssignment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
    List<BlogPost> findByUser(User user);
}
