package com.modu.ClientViewServer;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenController {

    @GetMapping("/token")
    public ResponseEntity<Message> token(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        Message message = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("access_token")) {
                message = new Message(cookie.getValue());
            }
        }
        if (message == null) {
            message = new Message("토큰이 없네요~");
        }

        return new ResponseEntity<Message>(message, HttpStatus.OK);
    }

    @Data
    @AllArgsConstructor
    public class Message {
        String message;
    }
}
