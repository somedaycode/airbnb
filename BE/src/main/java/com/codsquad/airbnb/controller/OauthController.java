package com.codsquad.airbnb.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.codsquad.airbnb.dto.Code;
import com.codsquad.airbnb.dto.GithubAccessTokenRequestDto;
import com.codsquad.airbnb.dto.GithubAccessTokenResponseDto;
import com.codsquad.airbnb.dto.User;
import com.codsquad.airbnb.service.OauthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class OauthController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OauthController.class);

    private OauthService oauthService;

    public OauthController(OauthService oauthService) {
        this.oauthService = oauthService;
    }

    @GetMapping
    public ResponseEntity auth(String code) {
        LOGGER.debug("code : {}", code);

        GithubAccessTokenResponseDto accessToken = oauthService.getAccessToken(code)
                .orElseThrow(() -> new RuntimeException("바디가 존재하지 않습니다."));

        LOGGER.debug("accessToken : {}", accessToken);

        User user = oauthService.getUserFromGitHub(accessToken)
                .orElseThrow(() -> new RuntimeException("바디가 존재하지 않습니다."));

        String jwt = oauthService.getJwt(user);

        LOGGER.debug("user : {}", user);
        LOGGER.debug("jwt : {}", jwt);

        return new ResponseEntity(jwt, HttpStatus.OK);
    }
}
