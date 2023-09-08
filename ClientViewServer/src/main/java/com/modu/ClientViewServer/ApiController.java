package com.modu.ClientViewServer;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
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
public class ApiController {

    private final RestTemplate restTemplate;

    @GetMapping("/posts")
    public ResponseEntity<List<PostDto>> getPosts(HttpServletRequest request) {

        Cookie[] cookies = request.getCookies();
        String access_token = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("access_token")) {
                access_token = cookie.getValue();
            }
        }

        if (access_token == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        log.info("cookie에 access_token 있음.");

        String uriString = UriComponentsBuilder
                .newInstance()
                .scheme("http")
                .host("127.0.0.1")
                .port(8082)
                .path("/posts")
                .build().toUriString();

        HttpHeaders headers = new HttpHeaders();
        headers.put("Authorization", List.of("Bearer " + access_token));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<List<PostDto>> response = restTemplate.exchange(uriString, HttpMethod.GET, entity, new ParameterizedTypeReference<>() {});

        return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
    }


}
