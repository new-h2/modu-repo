package com.modu.GatewayServer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class HomeController {

    private final RestTemplate restTemplate;

    @GetMapping("/free")
    public ResponseEntity<Message> getFree() {
        log.info("GET /free 컨트롤러 진입");
        return new ResponseEntity<>(new Message("익명 사용자도 얻을 수 있는 자원"), HttpStatus.OK);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<PostDto>> getAllPosts() {
        log.info("GET /posts 컨트롤러 진입");
        String uriString = UriComponentsBuilder
                .newInstance()
                .scheme("http")
                .host("127.0.0.1")
                .port(8085)
                .path("/posts")
                .build().toUriString();

        HttpEntity<String> entity = new HttpEntity<>(new HttpHeaders());
        ResponseEntity<List<PostDto>> response = restTemplate.exchange(uriString, HttpMethod.GET, entity, new ParameterizedTypeReference<>() {});

        List<PostDto> postDtoList = response.getBody();
        postDtoList.sort((post1, post2) ->
                post2.getUpdatedAt().compareTo(post1.getUpdatedAt()));
        return new ResponseEntity<>(postDtoList, HttpStatus.OK);
    }

    @Data
    @AllArgsConstructor
    public class Message {
        String message;
    }
}
