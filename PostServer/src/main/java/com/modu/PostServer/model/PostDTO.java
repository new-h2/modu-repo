package com.modu.PostServer.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@Component("postdto")
public class PostDTO {

    private long postId;
    private String title;
    private long memberId;
    private String startTime;
    private String endTime;
    private String content;
    private String postAddress;
    private long postPictureId;
    private long postLikeId;
    private Date createAt;
    private Date updateAt;
    private int matchingStatus; //'0.신청 1.컨펌 2.리뷰가능
    private int postStatus; //'0.거래가능, 1.예약 2.거래완료 3.삭제
    private int price;      // 5천 -1만원


    public PostDTO(long postId, String title, long memberId, String startTime, String endTime, String content, String postAddress, long postPictureId, long postLikeId, Date createAt, Date updateAt, int matchingStatus, int postStatus, int price) {
        this.postId = postId;
        this.title = title;
        this.memberId = memberId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.content = content;
        this.postAddress = postAddress;
        this.postPictureId = postPictureId;
        this.postLikeId = postLikeId;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.matchingStatus = matchingStatus;
        this.postStatus = postStatus;
        this.price = price;
    }


}

