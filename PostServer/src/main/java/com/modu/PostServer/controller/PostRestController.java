package com.modu.PostServer.controller;

import com.modu.PostServer.model.PostDTO;
import com.modu.PostServer.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/posts")
public class PostRestController {
    private final PostService postService;
    public PostRestController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<List<PostDTO>> postList() {
        /*게시글 목록 조회*/
        List<PostDTO> postList = postService.getPostList();
        return ResponseEntity.ok(postList);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostDTO> postDetail( @PathVariable("postId") long postId) {
        /*게시글 상세글 조회*/
        PostDTO post = postService.getPostOne(postId);
        if (post != null) {
            return ResponseEntity.ok(post);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/insertp")
    public ResponseEntity<Void> postInsert(@RequestBody PostDTO PostDTO) {
        /* 게시글 작성 */
        log.info("Postdto",PostDTO);
        int result = postService.insertPost(PostDTO);
        if (result > 0) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/update/{postId}")
    public ResponseEntity<PostDTO> postUpdatePage(Model model,
                                 @PathVariable("postId") long postId, PostDTO postdto) {
        /* 게시글 수정페이지 이동*/
        PostDTO post = postService.getPostOne(postId);
        if (post != null) {
            return ResponseEntity.ok(post);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/updatep")
    public ResponseEntity<Void> postUpdate(@RequestBody PostDTO postdto) {
        /* 게시글 수정*/
        log.info("postdto",postdto);
        int result = postService.updatePost(postdto);
        if (result > 0) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/delete/{postId}")
    public ResponseEntity<Void> postDelete( @PathVariable("postId") long postId) {
        /* 게시글 삭제*/

        int result = postService.deletePost(postId);
        if (result > 0) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
