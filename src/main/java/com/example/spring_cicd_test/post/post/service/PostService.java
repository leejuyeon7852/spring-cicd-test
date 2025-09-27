package com.example.spring_cicd_test.post.post.service;

import com.example.spring_cicd_test.post.post.dto.PostDto;
import com.example.spring_cicd_test.post.post.entity.Post;
import com.example.spring_cicd_test.post.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public List<PostDto> getAllPosts(){
        return postRepository.findAll().stream()
                .map(post-> PostDto.builder()
                        .id(post.getId())
                        .title(post.getTitle())
                        .body(post.getBody())
                        .build()
                )
                .toList();
    }

    public PostDto createPost(PostDto dto) {
        Post post = Post.builder()
                .title(dto.getTitle())
                .body(dto.getBody())
                .build();

        Post saved = postRepository.save(post);

        return PostDto.builder()
                .id(saved.getId())
                .title(saved.getTitle())
                .body(saved.getBody())
                .build();
    }
}
