package com.modu.OAuth2Client.security.repository;


import com.modu.OAuth2Client.security.util.CookieUtils;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.oauth2.client.web.AuthorizationRequestRepository;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;
import org.springframework.web.util.WebUtils;


/**
 * OAuth2AuthorizationRequestBasedOnCookieRepository
 * OAuth2에 필요한 정보를 세션이 아닌 쿠키에 저장해서 쓸 수 있도록 인증 요청과 관련된 상태를 저장할 저장소
 * 권한 인증 흐름에서 클라이언트의 요청을 유지하는 데 사용하는 AuthorizationRequestRepository 클래스를 구현하여
 * 쿠키를 사용해 OAuth2 의 정보를 가져오고 저장하는 로직
 * TODO 정확히 어느 지점에서 쓰이는지 디버깅을 통해 확인할 것
 */
public class OAuth2AuthorizationRequestBasedOnCookieRepository implements AuthorizationRequestRepository<OAuth2AuthorizationRequest> {

    public final static String OAUTH2_AUTHORIZATION_REQUEST_COOKIE_NAME = "oauth2_auth_request";

    private final static int COOKIE_EXPIRE_SECONDS = 18000;

    /**
     * request 객체에서 쿠키를 얻어 OAuth2AuthorizationRequest 객체로 역직렬화
     */
    @Override
    public OAuth2AuthorizationRequest loadAuthorizationRequest(HttpServletRequest request) {
        Cookie cookie = WebUtils.getCookie(request, OAUTH2_AUTHORIZATION_REQUEST_COOKIE_NAME);
        return CookieUtils.deserialize(cookie, OAuth2AuthorizationRequest.class);
    }

    /**
     * 쿠키 추가해서 응답하기
     */
    @Override
    public void saveAuthorizationRequest(OAuth2AuthorizationRequest authorizationRequest, HttpServletRequest request, HttpServletResponse response) {
        if (authorizationRequest == null) {
            removeAuthorizationRequestCookies(request, response);
            return;
        }
        CookieUtils.addCookie(response, OAUTH2_AUTHORIZATION_REQUEST_COOKIE_NAME,
                CookieUtils.serialize(authorizationRequest), COOKIE_EXPIRE_SECONDS);
    }

    public void removeAuthorizationRequestCookies(HttpServletRequest request, HttpServletResponse response) {
        CookieUtils.deleteCookie(request, response, OAUTH2_AUTHORIZATION_REQUEST_COOKIE_NAME);
    }

    public OAuth2AuthorizationRequest removeAuthorizationRequest(HttpServletRequest request) {
        return this.loadAuthorizationRequest(request);
    }

    @Override
    public OAuth2AuthorizationRequest removeAuthorizationRequest(HttpServletRequest request, HttpServletResponse response) {
        return this.loadAuthorizationRequest(request);
    }
}
