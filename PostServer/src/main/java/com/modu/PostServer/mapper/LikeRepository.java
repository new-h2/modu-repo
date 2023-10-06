package com.modu.PostServer.mapper;

import com.modu.PostServer.model.LikeDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository("likerepository")
public interface LikeRepository {

    public int countHeartsByPostId(long postId);

    public void deleteHeart(LikeDTO heart);

    public void insertHeart(LikeDTO heart);

}
