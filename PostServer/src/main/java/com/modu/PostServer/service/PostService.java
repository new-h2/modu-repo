package com.modu.PostServer.service;

import com.modu.PostServer.mapper.PostRepository;
import com.modu.PostServer.model.PostDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public List<PostDTO> getPostList() {
        return postRepository.getPostList();
    }

    public List<PostDTO> getPostOne(long postId) {
        return postRepository.getPostOne(postId);
    }

    public void deletePost(long postId) {
        postRepository.deletePost(postId);
    }

    public int insertPost(PostDTO postdto) {
        return postRepository.insertPost(postdto);
    }
}
