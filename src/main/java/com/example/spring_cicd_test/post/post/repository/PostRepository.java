package com.example.spring_cicd_test.post.post.repository;

import com.example.spring_cicd_test.post.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
