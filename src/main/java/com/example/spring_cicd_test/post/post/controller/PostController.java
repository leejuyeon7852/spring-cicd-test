package com.example.spring_cicd_test.post.post.controller;

import com.example.spring_cicd_test.post.post.dto.PostDto;
import com.example.spring_cicd_test.post.post.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/post")
public class PostController {
    private final PostService postService;

    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPosts(){
        List<PostDto> allPosts = postService.getAllPosts();

        return ResponseEntity.ok(allPosts);
    }

    @PostMapping
    public ResponseEntity<PostDto> createPost(
            @RequestBody PostDto dto
    ){
        PostDto saved = postService.createPost(dto);

        return ResponseEntity.ok(saved);
    }
}
