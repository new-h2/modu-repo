package com.modu.PostServer.mapper;

import com.modu.PostServer.model.PostDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("postrepository")
public interface PostRepository {
    List<PostDTO> getPostList();

    List<PostDTO> getPostOne(long postId);

    void deletePost(long postId);
}
