package com.example.spring_cicd_test.global.initData;

import com.example.spring_cicd_test.post.post.dto.PostDto;
import com.example.spring_cicd_test.post.post.entity.Post;
import com.example.spring_cicd_test.post.post.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.List;

@Configuration
@AllArgsConstructor
public class PostInit {
    private final PostRepository postRepository;

    @Bean
    @Order(3)
    public ApplicationRunner initPost(){
        return args -> {
            if(postRepository.count() == 0){
                insertPost();
            }
        };
    }

    private void insertPost() {
        List<Post> initPosts = List.of(
                new Post(null, "테스트", "자동배포 테스트입니다."),
                new Post(null, "안녕", "안녕하세요!"),
                new Post(null, "오늘 날짜는", "2025-09-28"),
                new Post(null, "title", "body!")
        );

        postRepository.saveAll(initPosts);
    }
}
