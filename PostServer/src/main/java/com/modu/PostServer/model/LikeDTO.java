package com.modu.PostServer.model;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@NoArgsConstructor
@Builder
@Setter
@AllArgsConstructor
@Component("likedto")
public class LikeDTO {
    private long likeId;
    private long likeMemberId;
    private Date createAt;
    private long postId;

    @Override
    public String toString() {
        return "LikeDTO{" +
                "likeId=" + likeId +
                ", likeMemberId=" + likeMemberId +
                ", createAt=" + createAt +
                ", postId=" + postId +
                '}';
    }

}



