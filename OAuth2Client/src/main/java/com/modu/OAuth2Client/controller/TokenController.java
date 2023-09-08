package com.modu.OAuth2Client.controller;

import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenController {

    @GetMapping("/token")
    public OAuth2AccessToken token(@RegisteredOAuth2AuthorizedClient("springOAuth2") OAuth2AuthorizedClient oAuth2AuthorizedClient) {
        return oAuth2AuthorizedClient.getAccessToken();
    }
}
