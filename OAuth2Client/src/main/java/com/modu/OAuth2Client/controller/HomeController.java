package com.modu.OAuth2Client.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class HomeController {

    @GetMapping("/")
    public RedirectView home(@RegisteredOAuth2AuthorizedClient("springOAuth2") OAuth2AuthorizedClient oAuth2AuthorizedClient, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        log.info("인가서버 callback 컨트롤러 접근");
        String tokenValue = oAuth2AuthorizedClient.getAccessToken().getTokenValue();
        log.info("tokenValue={}", tokenValue);

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://127.0.0.1:8080?tokenValue=" + tokenValue);
        return redirectView;
    }

    @Data
    @AllArgsConstructor
    public class Message {
        String message;
    }


}
