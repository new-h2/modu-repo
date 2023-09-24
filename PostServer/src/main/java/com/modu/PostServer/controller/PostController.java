package com.modu.PostServer.controller;

import com.modu.PostServer.model.PostDTO;
import com.modu.PostServer.service.PostService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Delete;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;


    @GetMapping("/posts")
    public String postList(Model model) {
        /*게시글 목록 조회*/
        model.addAttribute("postList",postService.getPostList());
        return "postList";
    }

@GetMapping("/posts/{postId}")
    public String postDetail(Model model, @PathVariable("postId") long postId) {
        /*게시글 상세글 조회*/
        model.addAttribute("postList",postService.getPostOne(postId));
        return "postDetail";
    }

    @GetMapping("/posts/insert")
    public String postInsertPage() {
        /* 게시글 작성페이지 이동*/
        return "postInsert";
    }


    @PostMapping("/posts/{postId}")
    public String postInsert() {
        /* 게시글 작성 */
        // 작성 로직 끝나면  "redirect:/postlist";로 보내기
        return  "redirect:/postList";
    }

    @GetMapping("/posts/update")
    public String postUpdatePage() {
        /* 게시글 수정페이지 이동*/
        return "postUpdate";
    }


    @PutMapping("/posts/{postId}")
    public String postUpdate( @PathVariable("postId") long postId) {
        /* 게시글 수정*/
        System.out.println("게시글 수정완료");
        return "redirect:/postList";
    }


    @GetMapping("/posts/delete/{postId}")
    public String postDelete( @PathVariable("postId") long postId) {
        /* 게시글 삭제*/
        postService.deletePost(postId);
        return "redirect:/posts";
    }



}
