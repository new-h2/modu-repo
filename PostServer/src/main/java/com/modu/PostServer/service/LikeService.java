package com.modu.PostServer.service;

import com.modu.PostServer.mapper.LikeRepository;
import com.modu.PostServer.mapper.PostRepository;
import com.modu.PostServer.model.LikeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeService {
    private final LikeRepository likerepository;

    public int countHeartsByPostId(long postId) {
        return 0;
    }

    public void deleteHeart(LikeDTO heart) {
    }

    public void insertHeart(LikeDTO heart) {
        likerepository.insertHeart(heart);
    }
}
