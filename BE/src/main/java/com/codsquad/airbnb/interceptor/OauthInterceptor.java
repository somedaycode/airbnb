package com.codsquad.airbnb.interceptor;

import com.codsquad.airbnb.dto.User;
import com.codsquad.airbnb.service.OauthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class OauthInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(OauthInterceptor.class);

    private final String BEARER = "Bearer";
    private static final int TOKEN_INDEX = 1;

    private final OauthService oauthService;

    public OauthInterceptor(OauthService oauthService) {
        this.oauthService = oauthService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String jwt = extractTokenFromHeader(request);
        User user = oauthService.getLoginFromEncodedJwt(jwt)
                .orElseThrow(() -> new RuntimeException("유저가 존재하지 않습니다."));

        LOGGER.debug("{}", user);

        request.setAttribute("login", user.getLogin());

        return true;
    }

    private String extractTokenFromHeader (HttpServletRequest request) {
        String jwt = request.getHeader("Authorization");

        LOGGER.debug("{}", jwt);

        if(jwt == null || jwt.isEmpty()) {
            throw new RuntimeException("jwt가 존재하지 않습니다.");
        }

        String[] splitedValues = jwt.split(" ");

        if(!jwt.startsWith(BEARER) || splitedValues.length != 2) {
            throw new RuntimeException(("인증된 jwt가 아닙니다."));
        }

        return splitedValues[TOKEN_INDEX];
    }
}
