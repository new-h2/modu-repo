package com.modu.PostServer.controller;

import com.modu.PostServer.mapper.LikeRepository;
import com.modu.PostServer.model.LikeDTO;
import com.modu.PostServer.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LikeController {

    private final LikeService likeservice;

    @Autowired // LikeService를 주입받도록 설정
    public LikeController(LikeService likeservice) {
        this.likeservice = likeservice;
    }


    @PostMapping("/heart/toggle")
    public ResponseEntity<String> toggleHeart(@RequestParam long postId, @RequestParam long memberId) {
        LikeDTO heart = new LikeDTO();
        heart.setPostId(postId);
        heart.setLikeMemberId(memberId);

        System.out.println("postId"+ postId);
        System.out.println("memberId" + memberId);
        System.out.println(heart.toString());

        // 이미 하트를 눌렀는지 확인
        //int existingHearts = likeservice.countHeartsByPostId(postId);

       // if (existingHearts > 0) {
            // 하트를 이미 눌렀으면 하트 삭제
            //likeservice.deleteHeart(heart);
            //return ResponseEntity.ok("unliked");
        //} else {
            // 하트를 누르지 않았으면 하트 추가
        likeservice.insertHeart(heart);
            return ResponseEntity.ok("liked");
        //}
    }
}
