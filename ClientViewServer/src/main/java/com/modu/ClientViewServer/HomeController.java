package com.modu.ClientViewServer;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class HomeController {

    @GetMapping("/")
    public String index(HttpServletRequest request, HttpServletResponse response) {
//        String tokenValue = request.getParameter("tokenValue");
//        if (tokenValue != null) {
//            log.info("tokenValue={}", tokenValue);
//            Cookie cookie = new Cookie("access_token", tokenValue);
//            cookie.setMaxAge(3600);
//            cookie.setHttpOnly(true);
//            response.addCookie(cookie);
//            return "redirect:/";
//        }
//
//        Cookie[] cookies = request.getCookies();
//        if (cookies != null) {
//            for (Cookie cookie : cookies) {
//                if (cookie.getName().equals("access_token")) {
//                    Cookie responseCookie = new Cookie("access_token", cookie.getValue());
//                    responseCookie.setMaxAge(3600);
//                    responseCookie.setHttpOnly(true);
//                    response.addCookie(responseCookie);
//                }
//            }
//        }
//
        return "index";
    }
    @GetMapping("/posts")
    public String postlist() {

        return "postlist";
    }

    @GetMapping("/postdetail")
    public String postdetail() {

        return "postdetail";
    }
    @GetMapping("/postinsert")
    public String postinsert() {

        return "postinsert";
    }


}
